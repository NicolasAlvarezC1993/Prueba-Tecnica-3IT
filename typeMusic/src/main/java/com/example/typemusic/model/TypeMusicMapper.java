package com.example.typemusic.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.example.typemusic.dto.TypeMusicDto;

@Mapper (componentModel="spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, implementationPackage = "com.example.typemusic.model")
public interface TypeMusicMapper {
    
    TypeMusicMapper INSTANCE = Mappers.getMapper(TypeMusicMapper.class);
    
    @Mapping(target ="id", source ="id")
    @Mapping(target ="name", source ="name")
    TypeMusicDto typeMusicToTypeMusicDto (TypeMusic typeMusic);

    @Mapping(target ="id", source ="id")
    @Mapping(target ="name", source ="name")
    TypeMusic typeMusicDtoToTypeMusic (TypeMusicDto typeMusicDto);
}
