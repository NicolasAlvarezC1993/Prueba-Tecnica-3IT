package com.example.poll.controller;

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

import com.example.poll.dto.PollDto;
import com.example.poll.model.Poll;
import com.example.poll.service.PollService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pollApi")
@Api(value = "MICROSERVICIO DE ENCUESTAS")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class PollController {

    private static final Log LOGGER = LogFactory.getLog(PollController.class.getName());
	private PollService pollService;

    public PollController(PollService pollService) {
		this.pollService = pollService;
	}

    @GetMapping("/getAll")
    @ApiOperation(value = "getAll", notes = "Obtiene todos los registros")
    public List<Poll> getAll(){
        LOGGER.info ("Se inicia metodo para buscar todo");
        return pollService.findAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "create", notes = "Crea un nuevo registro poll")
    public Poll create(@Validated @RequestBody PollDto pollDto){
        LOGGER.info ("Se inicia metodo para crear poll");
        return pollService.save(pollDto);
    }
    
}
