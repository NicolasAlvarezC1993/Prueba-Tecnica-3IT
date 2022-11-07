package com.example.typemusic.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.typemusic.model.TypeMusic;

public interface TypeMusicDao extends CrudRepository<TypeMusic,Long> {
    
}
