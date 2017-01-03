package io.github.xausky.eventuate.handler;

import io.eventuate.DispatchedEvent;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;
import io.github.xausky.eventuate.entity.Note;
import io.github.xausky.eventuate.event.CreateNoteEvent;
import io.github.xausky.eventuate.event.DeleteNoteEvent;
import io.github.xausky.eventuate.service.NoteRepository;

/**
 * Created by xausky on 12/28/16.
 */
@EventSubscriber(id = "NoteHandler")
public class NoteHandler {
    private NoteRepository repository;
    public NoteHandler(NoteRepository repository){
        this.repository = repository;
    }
    @EventHandlerMethod
    public void create(DispatchedEvent<CreateNoteEvent> de){
        Note note = new Note();
        note.setId(de.getEntityId());
        note.setTitle(de.getEvent().getTitle());
        note.setContent(de.getEvent().getContent());
        repository.save(note);
    }
    @EventHandlerMethod
    public void delete(DispatchedEvent<DeleteNoteEvent> de){
        repository.delete(de.getEntityId());
    }
}
