package com.example.sentry.demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
public class OutputDto {
	
	@NotNull(message = "This parameters must be a string and cannot be null")
	@Getter
	@Setter
	private String nonNull;

	@Size(max=4, message = "Max length of string is 4 characteres")
	@Getter
	@Setter
	private String max4;

	@Min(value = 0, message = "The value must be a positive integer")
	@Getter
	@Setter
	private Integer natNumber;

	public String getDto() {
		return OutputDto.class.getName();
	}
}
