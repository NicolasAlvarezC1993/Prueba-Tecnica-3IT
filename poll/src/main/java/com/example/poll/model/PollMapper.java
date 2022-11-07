package com.example.poll.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.example.poll.dto.PollDto;

@Mapper (componentModel="spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, implementationPackage = "com.example.poll.model")
public interface PollMapper {
    
    PollMapper INSTANCE = Mappers.getMapper(PollMapper.class);
    
    @Mapping(target ="email", source ="email")
    @Mapping(target ="typeMusic", source ="typeMusic")
    PollDto pollToPollDto (Poll poll);

    @Mapping(target ="email", source ="email")
    @Mapping(target ="typeMusic", source ="typeMusic")
    Poll pollDtoToPoll (PollDto pollDto);
}
