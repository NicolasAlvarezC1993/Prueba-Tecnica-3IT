package com.example.typemusic.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.typemusic.dao.TypeMusicDao;
import com.example.typemusic.dto.TypeMusicDto;
import com.example.typemusic.model.TypeMusic;


@ExtendWith(MockitoExtension.class)
public class TypeMusicServiceTest {
    @Mock
    private TypeMusicDao typeMusicDao;

    @InjectMocks
    private TypeMusicServiceImpl typeMusicServiceImpl;

    @Test
    public void whenSaveTypeMusic_shouldReturnTypeMusic() {
        TypeMusic typeMusic = new TypeMusic(1L,"Metal");
        TypeMusicDto typeMusicDto = new TypeMusicDto(1L,"Metal");

        when(typeMusicDao.save(ArgumentMatchers.any(TypeMusic.class))).thenReturn(typeMusic);

        TypeMusic created = typeMusicServiceImpl.save(typeMusicDto);

        assertThat(created.getId()).isSameAs(typeMusic.getId());
        verify(typeMusicDao).save(typeMusic);
    }

    @Test
    public void shouldReturnAllTypeMusics() {
        List<TypeMusic> typeMusicList = new ArrayList<TypeMusic>();
        typeMusicList.add(new TypeMusic(1L,"Metal"));

        given(typeMusicDao.findAll()).willReturn(typeMusicList);

        List<TypeMusic> expected = typeMusicServiceImpl.findAll();

        assertEquals(expected, typeMusicList);
        verify(typeMusicDao).findAll();
    }
}
