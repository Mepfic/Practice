package users;

import java.util.ArrayList;

public class ListOfUsers {
	ArrayList<User> users = new ArrayList<>();

	public void createUser(String firstName, String lastName, int age, String gender, boolean ifStudent, float rating) {
		users.add(new User(firstName, lastName, age, gender, ifStudent, rating));
	}

	public void outputUsers() {
		System.out.println("Список всех участников:");
		for (User user : users) {
			System.out.printf("Имя: %s, Фамилия: %s, %d год, пол: %s, является ли студентом: %s, рейтинг %.2f; \n",
					user.getFirstName(), user.getLastName(), user.getAge(), user.getGender(), user.getIfStudent(), user.getRating());
					
		}

	}
}
