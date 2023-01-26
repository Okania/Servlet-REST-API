package model;

public class User {
	
	private int id;
	private String first_name;
	private String last_name;
	private String course;
	private int age;
	
	public User(int id, String fname, String lname, String course, int age) {
		this.id = id;
		this.first_name = fname;
		this.last_name = lname;
		this.course = course;
		this.age = age;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	
	public void setFname(String fname) {
		this.first_name = fname;
	}	
	public String getFname() {
		return first_name;
	}
	
	
	public void setLname(String lname) {
		this.last_name = lname;
	}
	
	public String getLname() {
		return last_name;
	}
	
	
	public void setCourse(String course) {
		this.course = course;
	}
	
	public String getCourse() {
		return course;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}

}
