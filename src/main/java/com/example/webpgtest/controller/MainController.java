package com.example.webpgtest.controller;

import com.example.webpgtest.domain.Note;
import com.example.webpgtest.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Note> notes = noteRepository.findAll();

        model.put("notes", notes);

        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String tittle, @RequestParam String content, Map<String, Object> model) {
        Note note = new Note(tittle, content);
        noteRepository.save(note);

        Iterable<Note> notes = noteRepository.findAll();

        model.put("notes", notes);

        return "main";
    }

}
