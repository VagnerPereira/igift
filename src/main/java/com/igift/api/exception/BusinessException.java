package com.igift.api.exception;

public class BusinessException extends RuntimeException {

    public  BusinessException (String mensagem) {
        super(mensagem);
    }

}
