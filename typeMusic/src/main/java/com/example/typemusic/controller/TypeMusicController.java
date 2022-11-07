package com.example.typemusic.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.typemusic.dto.TypeMusicDto;
import com.example.typemusic.model.TypeMusic;
import com.example.typemusic.service.TypeMusicService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/typeMusicApi")
@Api(value = "MICROSERVICIO DE TIPO DE MUSICA")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class TypeMusicController {

    private static final Log LOGGER = LogFactory.getLog(TypeMusicController.class.getName());
	private TypeMusicService typeMusicService;

    public TypeMusicController(TypeMusicService typeMusicService) {
		this.typeMusicService = typeMusicService;
	}

    @GetMapping("/getAll")
    @ApiOperation(value = "getAll", notes = "Obtiene todos los registros")
    public List<TypeMusic> getAll(){
        LOGGER.info ("Se inicia metodo para buscar todo");
        return typeMusicService.findAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "create", notes = "Crea un nuevo registro typeMusic")
    public TypeMusic create(@Validated @RequestBody TypeMusicDto typeMusicDto){
        LOGGER.info ("Se inicia metodo para crear typeMusic");
        return typeMusicService.save(typeMusicDto);
    }
    
}
