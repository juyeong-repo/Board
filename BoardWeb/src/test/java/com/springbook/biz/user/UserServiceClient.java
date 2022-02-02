package com.springbook.biz.user;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

public class UserServiceClient {
	public static void main(String[] args) {
		// Spring container ����
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		//������ �����̳ʷκ���  userServiceImpl ��ü ���
		UserService userService = (UserService) container.getBean("userService");
		
		//test
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
		
		UserVO user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName()+"�� ȯ���մϴ�");
		}else {
			System.out.println("�α��� ����");
		}
		
		//�����̳� ����
		container.close();
	}

}
