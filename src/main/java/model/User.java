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
		
	public int getId() {
		return id;
	}
	
	
	public String getFname() {
		return first_name;
	}
	
		
	public String getLname() {
		return last_name;
	}
	
	public String getCourse() {
		return course;
	}
		
	public int getAge() {
		return age;
	}

}
