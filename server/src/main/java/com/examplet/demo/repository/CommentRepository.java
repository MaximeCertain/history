package com.examplet.demo.repository;

import com.examplet.demo.beans.Checkpoint;
import com.examplet.demo.beans.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
