package com.fmi.demo.exposition.exceptions;

public class CustomErrorHandler extends RuntimeException{

    public CustomErrorHandler(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getError_message(), new Throwable(exceptionEnum.getError_key()));
    }
}