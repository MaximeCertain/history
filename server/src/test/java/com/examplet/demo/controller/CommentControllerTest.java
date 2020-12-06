package com.examplet.demo.controller;

import com.examplet.demo.beans.Comment;
import com.examplet.demo.repository.CommentRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.DisabledIf;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CommentControllerTest {
    @Mock
    CommentRepository commentRepository;

    CommentController commentController;
    @Disabled
    public void getCommentTest(){
    /*    //given
        Comment comment = new Comment();
        comment.setContent("bonjour");
        when(commentRepository.findById(1)).thenReturn(java.util.Optional.of(comment)); //simule cette opération, aucun echec de test ne peut venir de cette méthode

        //when
         Optional<Comment> result = commentController.getCommentById(1); // le test se concentre donc sur cette méthode getCommetnById

        //given
        verify(commentRepository, times(1)).findById(1); //vérifie qu'on a bien appelé cette méthode,, une seule fois
        assertThat(result).isEqualTo(comment); //Vérifie l'assertion d'égalité*/
    }

}
