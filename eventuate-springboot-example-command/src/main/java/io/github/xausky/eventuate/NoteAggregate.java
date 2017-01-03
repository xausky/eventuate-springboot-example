package io.github.xausky.eventuate;

import io.eventuate.Event;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;
import io.github.xausky.eventuate.command.CreateNoteCommand;
import io.github.xausky.eventuate.command.DeleteNoteCommand;
import io.github.xausky.eventuate.command.NoteCommand;
import io.github.xausky.eventuate.event.CreateNoteEvent;
import io.github.xausky.eventuate.event.DeleteNoteEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xausky on 12/28/16.
 */
public class NoteAggregate extends ReflectiveMutableCommandProcessingAggregate<NoteAggregate,NoteCommand> {
    private static final Logger logger = LoggerFactory.getLogger(NoteAggregate.class);
    public List<Event> process(CreateNoteCommand cmd){
        CreateNoteEvent event = new CreateNoteEvent();
        event.setTitle(cmd.getTitle());
        event.setContent(cmd.getContent());
        return Arrays.asList(event);
    }

    public List<Event> process(DeleteNoteCommand cmd){
        DeleteNoteEvent event = new DeleteNoteEvent();
        return Arrays.asList(event);
    }

    public void apply(CreateNoteEvent event){
        logger.info("apply:{}",event);
    }

    public void apply(DeleteNoteEvent event){

    }
}
