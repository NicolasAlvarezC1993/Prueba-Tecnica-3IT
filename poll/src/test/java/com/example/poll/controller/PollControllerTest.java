package com.example.poll.controller;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.poll.dto.PollDto;
import com.example.poll.model.Poll;
import com.example.poll.service.PollService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class PollControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PollService pollService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void givenPollObject_whenCreatePoll_theReturnSavedPoll() throws Exception{

        PollDto pollDto = new PollDto("nicolas.alvarez@usach.cl",1L);
        Poll poll = new Poll("nicolas.alvarez@usach.cl",1L);

        given(pollService.save(pollDto)).willReturn(poll);
        
        mockMvc.perform(post("/pollApi/create")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(pollDto)))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.email", is(pollDto.getEmail())))
        .andExpect(jsonPath("$.typeMusic",is(pollDto.getTypeMusic().intValue())));
    }

    @Test
    public void givenListPollObject_whenGetAll_theReturnGetAll() throws Exception{

        Poll poll = new Poll("nicolas.alvarez@usach.cl",1L);
        List<Poll> pollList = new ArrayList<Poll>();
        pollList.add(poll);
        given(pollService.findAll()).willReturn(pollList);
        
        mockMvc.perform(get("/pollApi/getAll")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].email",is(pollList.get(0).getEmail())))
        .andExpect(jsonPath("$[0].typeMusic",is(pollList.get(0).getTypeMusic().intValue())));
    }
}
