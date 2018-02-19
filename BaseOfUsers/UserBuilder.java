package listOfUsers;

public class UserBuilder {
    Builder builder = new Builder();

    public User createUser (String firstName, String lastName, int age, String gender, boolean ifStudent, float rating){
        builder.create();
        builder.setFirstName(firstName);
        builder.setLastName(lastName);
        builder.setAge(age);
        builder.setGender(gender);
        builder.setIfStudent(ifStudent);
        builder.setRating(rating);
        return builder.getUser();
    }
}
