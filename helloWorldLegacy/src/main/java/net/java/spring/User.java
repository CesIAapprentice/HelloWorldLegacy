package net.java.spring;

public class User {
	
	private String name;
	private Integer age;
	private String email;
	
	public User() {
		this.name = "";
		this.age = 0;
		this.email = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
