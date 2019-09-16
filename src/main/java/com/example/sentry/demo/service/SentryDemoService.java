package com.example.sentry.demo.service;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.example.sentry.demo.dto.InputDto;
import com.example.sentry.demo.dto.OutputDto;
import com.example.sentry.demo.exception.SomeBusinessException;

@Service
public class SentryDemoService {

	public OutputDto getResource(@Valid @NotNull InputDto input) throws SomeBusinessException {
		if( input.getNonNull().length() > 2 ) 
			throw new SomeBusinessException("allowed max length is 2");
			
		return new OutputDto(input.getNonNull(), input.getMax4(), input.getNatNumber());
	}
	
}
