package users;

public class User {
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private boolean ifStudent;
	private float rating;
	
	public User (String firstName, String lastName, int age, String gender, boolean ifStudent, float rating) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.ifStudent = ifStudent;
		this.rating = rating;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean getIfStudent() {
		return ifStudent;
	}

	public void setIfStudent(boolean ifStudent) {
		this.ifStudent = ifStudent;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
	
}
