package model;

public class Person extends Entity {
	private int age;
	private String position, gender;
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	private Country country;
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		if (age <= 0) 
			throw new IllegalArgumentException("Age must be positive number");
		this.age = age;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public Country getCountry() {
		return country;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
	
}
