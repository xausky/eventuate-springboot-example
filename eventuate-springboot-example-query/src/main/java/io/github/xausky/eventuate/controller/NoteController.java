package io.github.xausky.eventuate.controller;

import io.github.xausky.eventuate.entity.Note;
import io.github.xausky.eventuate.service.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xausky on 12/28/16.
 */
@RestController
public class NoteController {
    @Autowired
    NoteRepository repository;

    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public Iterable<Note> index(){
        return repository.findAll();
    }
}
