package com.example.typemusic.exception.config;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.typemusic.exception.BusinessException;
import com.example.typemusic.exception.DataAccessException;
import com.example.typemusic.exception.ServiceException;

@ControllerAdvice
public class ExceptionConfig {
    private static final Log LOGGER = LogFactory.getLog(ExceptionConfig.class.getName());
    private static final String CAUSA = " causa: ";
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorBody> methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        LOGGER.info ("Ha ocurrido de formato: "+e.getMessage()+ CAUSA +e.getCause());
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuilder errorMessage = new StringBuilder();
        fieldErrors.forEach(f -> errorMessage.append(f.getField()).append(" ").append(f.getDefaultMessage()).append(" "));
        ErrorBody errorBody = new ErrorBody(HttpStatus.BAD_REQUEST.value(),errorMessage.toString());
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorBody> businessException (BusinessException e) {
        LOGGER.info ("Ha ocurrido un error de negocio: "+e.getMessage()+ CAUSA +e.getCause());
        ErrorBody errorBody = new ErrorBody(999,e.getMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ErrorBody> dataAccessException (DataAccessException e) {
        LOGGER.info ("Ha ocurrido un error de acceso a los datos: "+e.getMessage()+ CAUSA +e.getCause());
        ErrorBody errorBody = new ErrorBody(998,e.getMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorBody> serviceException (ServiceException e) {
        LOGGER.info ("Ha ocurrido un error en el consumo de un servicio: "+e.getMessage()+ CAUSA +e.getCause());
        ErrorBody errorBody = new ErrorBody(997,e.getMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorBody> exception (Exception e) {
        LOGGER.info ("Ha ocurrido un error generico: "+e.getMessage()+ CAUSA +e.getCause());
        ErrorBody errorBody = new ErrorBody(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
