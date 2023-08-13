package com.example.webpgtest.repository;

import com.example.webpgtest.domain.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {

}
