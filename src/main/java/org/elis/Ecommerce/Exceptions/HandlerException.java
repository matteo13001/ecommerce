package org.elis.Ecommerce.Exceptions;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import DtoResponse.MessageDTO;

@RestControllerAdvice
public class HandlerException {

	@ExceptionHandler(SQLException.class)
	public ResponseEntity<MessageDTO> erroreDB(SQLException e){
		MessageDTO m=new MessageDTO(e.getMessage(), HttpStatus.BAD_REQUEST.value());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(m);
	}
	@ExceptionHandler(DatiNonValidiException.class)
	public ResponseEntity<MessageDTO> erroreDati(DatiNonValidiException e){
		MessageDTO m=new MessageDTO(e.getMessage(), HttpStatus.BAD_REQUEST.value(),e.getRequest());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(m);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MessageDTO> erroreValidazione(MethodArgumentNotValidException e){
								//col getBindingResult.getFiledErrors prendo tutti gli errori che ci sono
		Map<String, String> errori=e.getBindingResult().getFieldErrors()
									.stream()
									.collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage));
		List<String> erroriList=new ArrayList<>();
		//scorro tutte le chiavi presenti nella map(tutti i campi errati)
		for(String s:errori.keySet()) {
			//per ogni campo errato lo aggiungo alla lista insieme al suo errore
			erroriList.add(s+": "+errori.get(s));
		}
		MessageDTO m =new MessageDTO(erroriList, HttpStatus.BAD_REQUEST.value());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(m);
	}
}
	