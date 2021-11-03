package com.laptrinhjavaweb.controlleradvice;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.exception.FieldNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Map<String, Object>> handleCityNotFoundException(ArithmeticException ex, WebRequest request) {
        Map<String, Object> data = new HashMap<>();
        data.put("error", ex.getMessage());
        data.put("message", SystemConstant.FAIL);
        return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FieldNullException.class)
    public ResponseEntity<Map<String, Object>> handleFileNullException(FieldNullException ex, WebRequest request) {
        Map<String, Object> data = new HashMap<>();
        data.put("error", ex.getMessage());
        data.put("message", SystemConstant.FAIL);
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
