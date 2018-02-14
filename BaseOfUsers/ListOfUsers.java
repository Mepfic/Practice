package users;

import java.util.ArrayList;

public class ListOfUsers {
	ArrayList<User> users = new ArrayList<>();

	public void createUser(String firstName, String lastName, int age, String gender, boolean ifStudent, float rating) {
		users.add(new User(firstName, lastName, age, gender, ifStudent, rating));
	}

	public void outputUsers() {
		System.out.println("������ ���� ����������:");
		for (User user : users) {
			System.out.printf("���: %s, �������: %s, %d ���, ���: %s, �������� �� ���������: %s, ������� %.2f; \n",
					user.getFirstName(), user.getLastName(), user.getAge(), user.getGender(), user.getIfStudent(), user.getRating());
					
		}

	}
}
