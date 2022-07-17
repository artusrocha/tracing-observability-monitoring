package com.example.sentry.demo.exception;

import java.time.Instant;
import java.util.UUID;

import lombok.Getter;

public class SomeBusinessException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter
	private static final BusinessErros error = BusinessErros.SOME;
	
	@Getter
	private UUID occurrence = UUID.randomUUID() ;

	@Getter
	private Instant occurrenceDt = Instant.now();

	public SomeBusinessException(String msg){
        super(msg);
    }

    public SomeBusinessException(String msg, Throwable cause){
        super(msg, cause);
    }
}