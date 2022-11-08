package com.example.typemusic.controller;

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

import com.example.typemusic.dto.TypeMusicDto;
import com.example.typemusic.model.TypeMusic;
import com.example.typemusic.service.TypeMusicService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class TypeMusicControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TypeMusicService typeMusicService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void givenTypeMusicObject_whenCreateTypeMusic_theReturnSavedTypeMusic() throws Exception{

        TypeMusicDto typeMusicDto = new TypeMusicDto(1L,"Metal");
        TypeMusic typeMusic = new TypeMusic(1L,"Metal");

        given(typeMusicService.save(typeMusicDto)).willReturn(typeMusic);
        
        mockMvc.perform(post("/typeMusicApi/create")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(typeMusicDto)))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id", is(typeMusicDto.getId().intValue())))
        .andExpect(jsonPath("$.name",is(typeMusicDto.getName())));
    }

    @Test
    public void givenListTypeMusicObject_whenGetAll_theReturnGetAll() throws Exception{

        TypeMusic typeMusic = new TypeMusic(1L,"Metal");
        List<TypeMusic> typeMusicList = new ArrayList<TypeMusic>();
        typeMusicList.add(typeMusic);
        given(typeMusicService.findAll()).willReturn(typeMusicList);
        
        mockMvc.perform(get("/typeMusicApi/getAll")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].id",is(typeMusicList.get(0).getId().intValue())))
        .andExpect(jsonPath("$[0].name",is(typeMusicList.get(0).getName())));
    }
}
