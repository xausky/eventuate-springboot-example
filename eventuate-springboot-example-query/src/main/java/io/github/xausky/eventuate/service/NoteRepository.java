package io.github.xausky.eventuate.service;

import io.github.xausky.eventuate.entity.Note;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by xausky on 12/28/16.
 */
public interface NoteRepository extends CrudRepository<Note,String> {
}
