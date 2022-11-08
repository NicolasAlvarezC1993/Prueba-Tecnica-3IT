package com.example.poll.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.poll.dao.PollDao;
import com.example.poll.dto.PollDto;
import com.example.poll.exception.BusinessException;
import com.example.poll.model.Poll;
import com.example.poll.model.PollMapper;

@Service
public class PollServiceImpl implements PollService{

    private static final Log LOGGER = LogFactory.getLog(PollServiceImpl.class.getName());

    @Autowired
	private PollDao pollDao;

    @Override
    public Poll save(PollDto pollDto) {
        LOGGER.info ("Se validan los campos enviados segun el negocio, poll :"+pollDto.toString());
        Pattern pattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(pollDto.getEmail());
        if (!mather.find()) {
            throw new BusinessException("El formato del correo es invalido");
        } 
        LOGGER.info ("La validacion ha sido exitosa"); 
        return pollDao.save(PollMapper.INSTANCE.pollDtoToPoll(pollDto));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Poll> findAll() {
        LOGGER.info ("Se buscan todos los elementos");
        return (List<Poll>) pollDao.findAll();
    }
    
}
