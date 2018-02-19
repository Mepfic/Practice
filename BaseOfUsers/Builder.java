package listOfUsers;

public class Builder {
    private User user;
    public void create (){
        user = new User();
    }

    public void setFirstName(String firstName) {
        this.user.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.user.lastName = lastName;
    }

    public void setAge(int age) {
        this.user.age = age;
    }

    public void setGender(String gender) {
        this.user.gender = gender;
    }

    public void setIfStudent(boolean ifStudent) {
        this.user.ifStudent = ifStudent;
    }

    public void setRating(float rating) {
        this.user.rating = rating;
    }

    public User getUser(){
        return this.user;
    }
}
