package com.examplet.demo.repository;

import com.examplet.demo.beans.Checkpoint;
import org.springframework.data.repository.CrudRepository;

public interface CheckpointRepository extends CrudRepository<Checkpoint, Long> {

}
