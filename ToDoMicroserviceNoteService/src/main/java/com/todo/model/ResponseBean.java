package com.todo.model;

import java.io.Serializable;

/**
 * purpose:
 * 
 * @author JAYANTA ROY
 * @version 1.0
 * @since 10/07/18
 */
public class ResponseBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public ResponseBean() {
	}

	private Object message;
	private Integer status;

	
	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	/**
	 * @return
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ResponseBean [message=" + message + ", status=" + status + "]";
	}

}
