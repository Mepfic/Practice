package listOfUsers;

import java.io.*;
import java.util.ArrayList;


public class Input {
    final static String FILE_PATH = "res\\1.txt";
    static String sData;
    static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] arg) throws IOException {
        reading(FILE_PATH);
        outputUsers();
    }

    private static void reading(String filePath) {
        String firstName;
        String lastName;
        int age = 0;
        String gender;
        boolean ifStudent;
        float rating = 0;
        BufferedReader in;
        String [] dataUser;

        UserBuilder userBuilder = new UserBuilder();
        try {
            in = new BufferedReader(new FileReader(filePath));
            MappingString splitting = sData -> sData.split("\\|");
            while ((sData = in.readLine()) != null) {
                dataUser = splitting.map(sData);
                firstName = dataUser[0].trim();
                lastName = dataUser[1].trim();
                age = Integer.parseInt(dataUser[2].trim());
                gender = dataUser[3].trim();
                if (dataUser[4].trim().equalsIgnoreCase("not")|dataUser[4].trim().equalsIgnoreCase("no")) {
                    ifStudent = false;
                } else ifStudent = true;
                rating = Float.parseFloat(dataUser[5].trim());
                users.add(userBuilder.createUser(firstName, lastName, age, gender,ifStudent,rating));
                /*for (String s : splitting.map(sData)) {
                    System.out.print(s.trim());
                }
                System.out.println();*/
            }
            in.close();

        } catch(Exception e) {};
    }

    private static void outputUsers() {
        System.out.println("List of users:");
        for (User user : users) {
            System.out.printf("Name: %s, Last name: %s, age: %d, sex: %s, student or no: %s, rating %.2f; \n",
                    user.getFirstName(), user.getLastName(), user.getAge(), user.getGender(), user.getIfStudent(), user.getRating());

        }
    }
}



/*try {
            Pattern p = Pattern.compile("\\||\\|\\s|\\s\\|\\s|\r\n|\n|\r");
            @SuppressWarnings("resource")
            Scanner scn = new Scanner(inData).useDelimiter(p);
            ListOfUsers list = new ListOfUsers();
            while (scn.hasNextLine()) {
                firstName = scn.next();
                lastName = scn.next();
                age = scn.nextInt();
                gender = scn.next();
                ifStudentS = scn.next();
                rating = scn.nextFloat();
                if (ifStudentS.equalsIgnoreCase("not")|ifStudentS.equalsIgnoreCase("no")) {
                    ifStudent = false;
                } else ifStudent = true;

				System.out.print(firstName);
				System.out.print(lastName);
				System.out.print(age);
				System.out.print(gender);
				System.out.print(ifStudent);
				System.out.print(rating);
				System.out.println();

                list.createUser(firstName, lastName, age, gender, ifStudent, rating);
            }
            list.outputUsers();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/