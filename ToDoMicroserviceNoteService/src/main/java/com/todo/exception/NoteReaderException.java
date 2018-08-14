package com.todo.exception;

/**
 * purpose:handle Exception occurred for note
 * 
 * @author JAYANTA ROY
 * @version 1.0
 * @since 10/07/18
 */
public class NoteReaderException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoteReaderException(String message) {
		super(message);
	}
}
