package com.todo.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Purpose:Proxy interface to connect with user microservice application
 * @author JAYANTA ROY
 *
 */
@FeignClient(name="todo", url="localhost:8762")
public interface IUserProxy {
	/**
	 * @return
	 */
	@GetMapping("/todo/user/send")
	public String send();
	
//	@GetMapping("/todo/user/view_all")
//	public List<?> viewAll();
}
