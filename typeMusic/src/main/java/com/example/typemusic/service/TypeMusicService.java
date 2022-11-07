package com.example.typemusic.service;

import java.util.List;

import com.example.typemusic.dto.TypeMusicDto;
import com.example.typemusic.model.TypeMusic;

public interface TypeMusicService {
    public  TypeMusic save(TypeMusicDto typeMusicDto);

    public List<TypeMusic> findAll();
    
    
}
