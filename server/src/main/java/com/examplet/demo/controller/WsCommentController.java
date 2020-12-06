package com.examplet.demo.controller;

import com.examplet.demo.beans.Comment;
import com.examplet.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WsCommentController {
    @Autowired
    CommentRepository commentRepository;

    @MessageMapping("/user-all")
    @SendTo("/topic/comments")  //tous les subscribeurs, qui écoutent vont recevoir
    public Comment postMessage(Comment comment) throws Exception {
        Thread.sleep(500);
        System.out.println(comment.getContent());
        commentRepository.save(comment);
        return comment;
    }
}
