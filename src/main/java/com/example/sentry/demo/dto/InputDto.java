package com.example.sentry.demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InputDto {

	@NotNull(message = "This parameters must be a string and cannot be null")
	private String nonNull;

	@Size(max=4, message = "Max length of string is 4 characteres")
	private String max4;

	@Min(value = 0, message = "The value must be a positive integer")
	private Integer natNumber;

	
}
