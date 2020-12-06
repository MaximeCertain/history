package com.examplet.demo.controller;

import com.examplet.demo.beans.Comment;
import com.examplet.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/comments")
    public Iterable<Comment> getComments(){
        return commentRepository.findAll();
    }

   public Optional<Comment> getCommentById(Integer id){
        return commentRepository.findById(id);
    }

}
