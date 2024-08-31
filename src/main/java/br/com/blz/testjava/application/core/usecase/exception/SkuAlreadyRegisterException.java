package br.com.blz.testjava.application.core.usecase.exception;

public class SkuAlreadyRegisterException extends RuntimeException{

    public SkuAlreadyRegisterException(String message){
        super(message);
    }
}
