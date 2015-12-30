package in.com.pradeepit.service.impl;

import in.com.pradeepit.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class MockUserService.
 */
public class MockUserService implements UserService {

	/** The user list. */
	final List<String> userList = new ArrayList<String>();
	
	/* (non-Javadoc)
	 * @see in.com.pradeepit.service.UserService#getUserNames()
	 */
	public List<String> getUserNames() {
		
		userList.add("Vinod");
		userList.add("Divya");
		return userList;
	}
	
	/**
	 * Adds the user.
	 *
	 * @param aUser the a user
	 */
	public void addUser(final String aUser){
		
	}

}
