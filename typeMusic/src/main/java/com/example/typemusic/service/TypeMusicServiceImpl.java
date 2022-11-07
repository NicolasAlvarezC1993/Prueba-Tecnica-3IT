package com.example.typemusic.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.typemusic.dao.TypeMusicDao;
import com.example.typemusic.dto.TypeMusicDto;
import com.example.typemusic.model.TypeMusic;
import com.example.typemusic.model.TypeMusicMapper;

@Service
public class TypeMusicServiceImpl implements TypeMusicService{

    private static final Log LOGGER = LogFactory.getLog(TypeMusicServiceImpl.class.getName());

    @Autowired
	private TypeMusicDao typeMusicDao;

    @Override
    public TypeMusic save(TypeMusicDto typeMusicDto) {
        LOGGER.info ("Se Crea TypeMusic en BD"); 
        return typeMusicDao.save(TypeMusicMapper.INSTANCE.typeMusicDtoToTypeMusic(typeMusicDto));
    }

    @Override
    @Transactional(readOnly = true)
    public List<TypeMusic> findAll() {
        LOGGER.info ("Se buscan todos los elementos");
        return (List<TypeMusic>) typeMusicDao.findAll();
    }

}
