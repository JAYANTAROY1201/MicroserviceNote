package com.todo.utility;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

/**
 * purpose: This class is designed to access messeges from property files
 * 
 * @author JAYANTA ROY
 * @version 1.0
 * @since 10/07/18
 */
@Component
public class Messages {

	private final MessageSourceAccessor accessor;

	public Messages(MessageSource messageSource) {
		this.accessor = new MessageSourceAccessor(messageSource, Locale.getDefault());

	}

	/**
	 * @param code
	 * @return
	 */
	public String get(String code) {
		return accessor.getMessage(code);
	}

}