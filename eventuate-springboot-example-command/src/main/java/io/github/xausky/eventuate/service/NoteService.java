package io.github.xausky.eventuate.service;

import io.eventuate.AggregateRepository;
import io.eventuate.EntityWithIdAndVersion;
import io.github.xausky.eventuate.NoteAggregate;
import io.github.xausky.eventuate.command.CreateNoteCommand;
import io.github.xausky.eventuate.command.DeleteNoteCommand;
import io.github.xausky.eventuate.command.NoteCommand;

import java.util.concurrent.CompletableFuture;

/**
 * Created by xausky on 12/28/16.
 */
public class NoteService {
    private AggregateRepository<NoteAggregate,NoteCommand> aggregateRepository;
    public NoteService(AggregateRepository<NoteAggregate,NoteCommand> repository){
        aggregateRepository = repository;
    }
    public CompletableFuture<EntityWithIdAndVersion<NoteAggregate>> create(String title, String content){
        CreateNoteCommand command = new CreateNoteCommand();
        command.setTitle(title);
        command.setContent(content);
        return aggregateRepository.save(command);
    }

    public CompletableFuture<EntityWithIdAndVersion<NoteAggregate>> delete(String id){
        return aggregateRepository.update(id,new DeleteNoteCommand());
    }
}
