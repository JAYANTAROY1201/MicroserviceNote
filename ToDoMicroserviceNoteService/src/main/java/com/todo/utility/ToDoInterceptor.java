//package com.todo.utility;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import com.todo.noteservice.dao.IRedisRepository;
//
//
///**
// * purpose: Interceptor class for application
// * 
// * @author JAYANTA ROY
// * @version 1.0
// * @since 30/07/18
// */
//@Component
//public class ToDoInterceptor implements HandlerInterceptor {
//
//	@Autowired
//	private IRedisRepository redisRepository;
//	
//	/**
//	 * (non-Javadoc)
//	 * 
//	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest,
//	 *      javax.servlet.http.HttpServletResponse, java.lang.Object)
//	 */
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) {
//        System.out.println("entering Prehandle");
//		String tokenFromHeader = request.getHeader("JWTToken");
//		System.out.println("token fom header "+tokenFromHeader);
//		String userId = JwtTokenBuilder.parseJWT(tokenFromHeader).getId();
//		String tokenFromRedis = redisRepository.getToken(userId);
//		if (tokenFromRedis == null) {
//			return false;
//		}
//		else {
//		request.setAttribute("userId", userId);
//		return true;
//
//	}
//	}
//
//}
