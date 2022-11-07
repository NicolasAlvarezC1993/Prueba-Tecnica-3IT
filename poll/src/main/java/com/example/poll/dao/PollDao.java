package com.example.poll.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.poll.model.Poll;

public interface PollDao extends CrudRepository<Poll,Long> {
    
}
