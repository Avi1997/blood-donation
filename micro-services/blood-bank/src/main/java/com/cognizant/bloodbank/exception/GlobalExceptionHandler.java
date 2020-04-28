package com.cognizant.bloodbank.exception;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cognizant.bloodbank.model.ErrorCode;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		LOGGER.info("START");
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("status", status.value());
		List<String> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(x -> x.getDefaultMessage()).collect(Collectors.toList());
		body.put("errors", errors);
		LOGGER.info("END");
		return new ResponseEntity<>(body, headers, status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		LOGGER.info("START");
		return super.handleHttpMessageNotReadable(ex, headers, status, request);
	}
	@ExceptionHandler(UserAlreadyExistsException.class)
	public final ResponseEntity<Object> notFoundObject(UserAlreadyExistsException userAlreadyExistsException, WebRequest webRequest) {
		LOGGER.info("INSIDE UserAlreadyExistsException");
		ErrorCode ec = new ErrorCode(userAlreadyExistsException.getMessage(), true,901);
		LOGGER.info("UserAlreadyExistsException End");
		return new ResponseEntity<>(ec, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(SlotAlreadyTaken.class)
	public final ResponseEntity<Object> alreadyBooked(SlotAlreadyTaken slotAlreadyTaken, WebRequest webRequest) {
		LOGGER.info("INSIDE SlotAlreadyTaken");
		ErrorCode ec = new ErrorCode(slotAlreadyTaken.getMessage(), true,902);
		LOGGER.info("SlotAlreadyTaken END");
		return new ResponseEntity<>(ec, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoBloodGroupAvailable.class)
	public final ResponseEntity<Object> alreadyBooked(NoBloodGroupAvailable noBloodGroupAvailable, WebRequest webRequest) {
		LOGGER.info("INSIDE SlotAlreadyTaken");
		ErrorCode ec = new ErrorCode(noBloodGroupAvailable.getMessage(), true,903);
		LOGGER.info("SlotAlreadyTaken END");
		return new ResponseEntity<>(ec, HttpStatus.NOT_FOUND);
	}
}