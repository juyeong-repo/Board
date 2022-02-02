package com.springbook.biz.user;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

public class UserServiceClient {
	public static void main(String[] args) {
		// Spring container 구동
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		//스프링 컨테이너로부터  userServiceImpl 객체 룩업
		UserService userService = (UserService) container.getBean("userService");
		
		//test
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
		
		UserVO user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName()+"님 환영합니다");
		}else {
			System.out.println("로그인 실패");
		}
		
		//컨테이너 종료
		container.close();
	}

}
