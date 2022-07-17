package com.example.sentry.demo.api.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.example.sentry.demo.dto.InputDto;
import com.example.sentry.demo.dto.OutputDto;
import com.example.sentry.demo.exception.SomeBusinessException;
import com.example.sentry.demo.service.SentryDemoService;

@RestController
public class SentryDemoWebApi {
	
    private static Logger logger = LoggerFactory.getLogger(SentryDemoWebApi.class);

	@Autowired
	private SentryDemoService service;

	@GetMapping
	public ResponseEntity<OutputDto> getResource(@Valid InputDto input) //, BindingResult validation)
			throws SomeBusinessException, MethodArgumentNotValidException {

//		if (validation.hasErrors())
//			throw new MethodArgumentNotValidException(null, validation);

		return ResponseEntity.ok(service.getResource(input));
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(SomeBusinessException.class)
	public Map<String, String> handleValidationExceptions(SomeBusinessException ex) {
		Map<String, String> errors = new HashMap<>();
		errors.put("error_message", ex.getMessage());
		logger.warn(ex.getMessage());
		return errors;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, Object> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
		logger.warn(ex.getMessage());
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    Map<String, Object> output = new HashMap<>();
	    output.put("errors", errors);
	    return output;
	}

}
