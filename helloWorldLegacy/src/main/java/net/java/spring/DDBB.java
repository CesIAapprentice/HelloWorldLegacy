package net.java.spring;

import java.util.ArrayList;

public class DDBB {
	
	ArrayList<User> userdatabase = new ArrayList<User>();

	public DDBB(ArrayList<User> userdatabase) {
		super();
		this.userdatabase = userdatabase;
	}

	public ArrayList<User> getUserdatabase() {
		return userdatabase;
	}

	public void setUserdatabase(ArrayList<User> userdatabase) {
		this.userdatabase = userdatabase;
	}
	
	

}
