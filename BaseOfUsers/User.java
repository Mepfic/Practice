package listOfUsers;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private boolean ifStudent;
    private float rating;

    public static Builder userBuilder() {
        return new User().new Builder();
    }
     class Builder {
         public Builder firstName(String firstName) {
             User.this.firstName = firstName;
             return this;
         }

         public Builder lastName(String lastName) {
             User.this.lastName = lastName;
             return this;
         }

         public Builder age (int age) {
             User.this.age = age;
             return this;
         }

         public Builder gender(String gender) {
             User.this.gender = gender;
             return this;
         }

         public Builder ifStudent(boolean ifStudent) {
             User.this.ifStudent = ifStudent;
             return this;
         }

         public Builder rating(float rating) {
             User.this.rating = rating;
             return this;
         }

         public User build() {
             return User.this;
         }

     }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public boolean getIfStudent() {
        return ifStudent;
    }

    public float getRating() {
        return rating;
    }

}
