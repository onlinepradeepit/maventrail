package in.com.pradeepit.service.impl;

import in.com.pradeepit.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class MockUserService implements UserService {

	final List<String> userList = new ArrayList<String>();
	public List<String> getUserNames() {
		
		userList.add("Vinod");
		userList.add("Divya");
		return userList;
	}
	
	public void addUser(final String aUser){
		
	}

}
