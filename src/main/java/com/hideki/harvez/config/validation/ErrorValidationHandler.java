package com.hideki.harvez.config.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hideki.harvez.config.validation.dto.FormErrorDTO;

import lombok.AllArgsConstructor;

@RestControllerAdvice
@AllArgsConstructor
public class ErrorValidationHandler {

	private final MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<FormErrorDTO> handle(MethodArgumentNotValidException exception) {
		List<FormErrorDTO> formErrorsDTO = new ArrayList<>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			FormErrorDTO erro = new FormErrorDTO(e.getField(), mensagem);
			formErrorsDTO.add(erro);
		});
		
		return formErrorsDTO;
	}
	
}
