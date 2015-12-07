package in.com.pradeepit.repo;

import in.com.pradeepit.service.UserService;
import in.com.pradeepit.service.impl.MockUserService;

public class RepoServiceDemo {
	
	public static void main(String[] args) {
		
		UserService userService =new MockUserService();
		System.out.println(userService.getUserNames());
	}

}
