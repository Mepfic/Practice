package users;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {
	final static String FILE_PATH = "res\\1.txt";
	
	public static void main(String[] arg) throws IOException {
		myScanner(FILE_PATH);		
	}

	private static void myScanner(String filePath) {
		String firstName;
		String lastName;		
		int age = 0;
		String gender;
		String ifStudentS;
		boolean ifStudent;		
		float rating = 0;
		File inData = new File(filePath);
		
		try {			
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
				if (ifStudentS.equalsIgnoreCase("нет")|ifStudentS.equalsIgnoreCase("no")) {
					ifStudent = false;
				} else ifStudent = true;
					
				/*System.out.print(firstName);
				System.out.print(lastName);
				System.out.print(age);
				System.out.print(gender);
				System.out.print(ifStudent);
				System.out.print(rating);
				System.out.println();
				*/				
				list.createUser(firstName, lastName, age, gender, ifStudent, rating);
			
			}
			list.outputUsers();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
}
