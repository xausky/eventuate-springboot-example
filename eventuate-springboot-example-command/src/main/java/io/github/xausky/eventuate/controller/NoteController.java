package io.github.xausky.eventuate.controller;

import io.github.xausky.eventuate.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * Created by xausky on 12/28/16.
 */
@RestController
public class NoteController {
    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/notes", method = RequestMethod.POST)
    public CompletableFuture<String> post(@RequestBody CreateNoteRequest request){
        return noteService.create(request.getTitle(),request.getContent()).thenApply(info -> info.getEntityId());
    }

    @RequestMapping(value = "/notes/{id}", method = RequestMethod.DELETE)
    public CompletableFuture<String> delete(@PathVariable String id){
        return noteService.delete(id).thenApply(info -> info.getEntityId());
    }
}
