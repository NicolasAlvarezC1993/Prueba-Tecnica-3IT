package com.example.poll.service;

import java.util.List;

import com.example.poll.dto.PollDto;
import com.example.poll.model.Poll;

public interface PollService {
    public  Poll save(PollDto pollDto);

    public List<Poll> findAll();
        
}
