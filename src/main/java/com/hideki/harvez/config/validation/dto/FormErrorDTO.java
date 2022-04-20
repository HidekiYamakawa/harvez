package com.hideki.harvez.config.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FormErrorDTO {

	private String campo;
	private String erro;
}