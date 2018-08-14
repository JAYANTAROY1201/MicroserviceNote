package com.todo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.todo.model.ResponseBean;
import com.todo.utility.Messages;

/**
 * <p>
 * purpose: This class is designed to handle all exceptions
 * </p>
 * <br>
 * 
 * @author JAYANTA ROY
 * @version 1.0
 * @since 12/07/18
 */

@ControllerAdvice
public class GlobalExceptionHandler {
	@Autowired
	Messages messsages;
	private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * This method to handle Note exception
	 * 
	 * @param exception
	 * @return response entity
	 */
	@ExceptionHandler(NoteReaderException.class)
	public ResponseEntity<ResponseBean> handleNoteException(NoteReaderException exception) {
		logger.info(messsages.get("error.note") + exception.getMessage(), exception);
		ResponseBean response = new ResponseBean();
		response.setMessage(exception.getMessage());
		response.setStatus(-1);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	
}