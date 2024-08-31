package br.com.blz.testjava.application.core.usecase.exception.advice;

import br.com.blz.testjava.application.core.usecase.exception.ProductNotFoundException;
import br.com.blz.testjava.application.core.usecase.exception.SkuAlreadyRegisterException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomProductExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(SkuAlreadyRegisterException.class)
    public ResponseEntity<String> handleSkuAlreadyRegisterException(SkuAlreadyRegisterException exception){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(exception.getMessage());
    }
}
