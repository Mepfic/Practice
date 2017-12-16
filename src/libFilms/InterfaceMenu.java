package libFilms;


import java.util.Scanner;


public class InterfaceMenu extends Main{
	public final int startYearFilm = 1895;
	public final int currentlyYearFilm = 2018;
	Scanner scn;
	
	public void mainMenu() {		
		System.out.println("����� ���������� � ����������. ������ � ��� ���������� �������� ������� ���� ������ � �������!!!"+ "\n"+ 
				"������� ����� ������ ����:" + "\n"+
				"1. �������� ������ �������" + "\n"+
				"2. ����� �����" + "\n"+
				"3. �������� �����"  + "\n"+
				"0. ����� �� ���������");
		
		scn = new Scanner(System.in);
		switch (scn.next()) {
		case ("1"): listMenu(); break;			
		case ("2"): findMenu();	break;
		case ("3"): addingMenu(); break;
		case ("0"): list.saveAll(); System.exit(0); break;		
		default:{
			System.out.println("��������� �������� �������. ���������� ��� ���");
			mainMenu();
			break;					
			}
		}
		scn.close();  
	}
	
	public void listMenu() {
		list.showAll();
		System.out.println("\n"+ 
				"������� ����� ������ ����:" + "\n"+
				"1. ����������� �� ��������" + "\n"+
				"2. ����������� �� ����" + "\n"+
				"3. �������� �����"  + "\n"+
				"4. ����� �����"  + "\n"+				
				"0. ��������� �����");
		
		scn = new Scanner(System.in);
		switch (scn.next()) {
		case ("1"): list.sortByName(); listMenu(); break;			
		case ("2"): list.sortByYear(); listMenu(); break;
		case ("3"): addingMenu(); break;
		case ("4"): findMenu(); break;
		case ("0"): mainMenu(); break;		
		default:{
			System.out.println("��������� �������� �������. ���������� ��� ���");
			listMenu();
			break;					
			}
		}
		scn.close(); 
		
	}
	
	public void findMenu() {
		System.out.println("����� � ��������. ��� ����� ������?"+ "\n"+ 
				"������� ����� ������ ����:" + "\n"+
				"1. ����� �� ��������" + "\n"+
				"2. ����� �� ����" + "\n"+							
				"0. ��������� �����");
		
		scn = new Scanner(System.in);
		switch (scn.next()) {
		case ("1"): findOfNameMenu(); break;			
		case ("2"): findOfYearMenu(); break;		
		case ("0"): listMenu(); break;		
		default:{
			System.out.println("��������� �������� �������. ���������� ��� ���");
			findMenu();
			break;					
			}
		}
		scn.close(); 
	}
	
	public void addingMenu() {
		String name;
		String genre;
		int year;
		String producer;
		double rating;
		int longTime;
		String format; //16*9 == yes, 4*3 == no;
		String input;
		
		System.out.println("����� ��������� ����� ����� � ���� ���������:"+ "\n"+ 
				"������� �������� � ������� Enter" + "\n"+							
				"0. ��������� �����");
		
		scn = new Scanner(System.in);
		input = scn.nextLine();
		if (input.equals("0")) {listMenu(); return;}			
		else name = input;	
		
		System.out.println("������� ����");
		genre = scn.nextLine();
		
		System.out.println("������� ��� ��������");	
		input = scn.nextLine();		
		if (isNumeric(input) && Integer.parseInt(input) > startYearFilm && Integer.parseInt(input) < currentlyYearFilm)  year = Integer.parseInt(input);	
		else year = startYearFilm;	
		
		System.out.println("������� ��� ����������");	
		producer = scn.nextLine();	
		
		System.out.println("������� ������� ������");
		if (scn.hasNextDouble()) rating = scn.nextDouble();
		else rating = 0.0; input = scn.nextLine();
		
		System.out.println("������� ����������������� � �������");	
		if (scn.hasNextInt()) longTime = scn.nextInt();
		else longTime = 0; input = scn.nextLine();	
		
		System.out.println("��������������� ����� (16*9)? ������� 1 ���� ��, ��� ������� ����� �������, ���� ���.");
		if (scn.next().equals("1")) format = "16*9";
		else format = "4*3";
		
		list.createFilm(name, genre, year, producer, rating, longTime, format);		
		listMenu();
		scn.close();
	}
	
	public void findOfNameMenu() {
		System.out.println(
				"������� �������� � ������� Enter" + "\n"+
				"0. ��������� �����");
		
		scn = new Scanner(System.in);
		int index;
		String input = scn.nextLine();
		if (input.equals("0")) {listMenu(); return;}			
			else index = list.findByName(input);
		if (index == -1) {System.out.println("����� �� ������"); findMenu();} 
			else filmMenu(index);
		scn.close();
	}
	 
	public void findOfYearMenu() {
		System.out.println(
				"������� ��� � ������� Enter" + "\n"+
				"0. ��������� �����");
		
		scn = new Scanner(System.in);
		int index;
		String input = scn.next();
		if (input.equals("0")) {listMenu(); return; }		
			else if (!isNumeric(input)) {findOfYearMenu(); return;}
			else index = list.findByYear(Integer.parseInt(input));
		if (index == -1) {System.out.println("����� �� ������"); findMenu();}
			else filmMenu(index);
		scn.close();
	}
	
	public void filmMenu(int index) {
		System.out.println("\n"+"��� � ������� ����� ������?"+ "\n"+ 
				"������� ����� ������ ����:" + "\n"+
				"1. �����������" + "\n"+
				"2. ��������" + "\n"+
				"3. �������" + "\n"+
				"0. ��������� �����");
		
		scn = new Scanner(System.in);
		switch (scn.next()) {
		case ("1"): list.printAboutFilm(index); mainMenu(); break;			
		case ("2"): changeMenu(index); mainMenu(); break;
		case ("3"): list.removeFilm(index); mainMenu(); break;
		case ("0"): findMenu(); break;		
		default:{
			System.out.println("��������� �������� �������. ���������� ��� ���");
			filmMenu(index);
			break;					
			}
		}
		scn.close(); 
	}
	
	public void changeMenu(int index){
		System.out.println("��� ����� ������?"+ "\n"+ 
				"������� ����� ������ ����:" + "\n"+
				"1. ��������" + "\n"+
				"2. ����" + "\n"+
				"3. ���" + "\n"+
				"4. ���������" + "\n"+
				"5. �������" + "\n"+
				"6. �����������������" + "\n"+
				"7. ������" + "\n"+
				"0. ��������� �����");
		
		scn = new Scanner(System.in);
		switch (scn.next()) {
		case ("1"): {
			System.out.println("������� ����� ��������");
			scn = new Scanner(System.in);
			list.films.get(index).setName(scn.nextLine());	
			list.saveAll();
			mainMenu();
			}
			break;			
		case ("2"): {
			System.out.println("������� ����� ����");
			scn = new Scanner(System.in);
			list.films.get(index).setGenre(scn.nextLine());	
			list.saveAll();
			mainMenu();
			}
			break;		
		case ("3"): {
			System.out.println("������� ���");
			scn = new Scanner(System.in);
			String input = scn.next();		
			if (isNumeric(input) && Integer.parseInt(input) > startYearFilm && Integer.parseInt(input) < currentlyYearFilm) 
				list.films.get(index).setYear(Integer.parseInt(input));
			else list.films.get(index).setYear(startYearFilm);
			list.saveAll();
			mainMenu();
			}
			break;		
		case ("4"): {
			System.out.println("������� ��� ����������");
			scn = new Scanner(System.in);
			list.films.get(index).setProducer(scn.nextLine());
			list.saveAll();
			mainMenu();
			}
			break;		
		case ("5"): {
			System.out.println("������� ����� �������");
			scn = new Scanner(System.in);
			if (scn.hasNextDouble()) list.films.get(index).setRating(scn.nextDouble()); 
			else list.films.get(index).setRating(0.0);	
			list.saveAll();
			mainMenu();
			}
			break;					
		case ("6"): {
			System.out.println("������� �����������������");
			scn = new Scanner(System.in);
			if (scn.hasNextInt()) list.films.get(index).setLongTime(scn.nextInt());
			else list.films.get(index).setLongTime(0);
			list.saveAll();
			mainMenu();
			}
			break;		
		case ("7"): {
			System.out.println("������ ������. ������� 1 ���� ������ 16*9, ��� ������� ����� �������, ���� 4*3.");
			scn = new Scanner(System.in);
			if (scn.next().equals("1")) list.films.get(index).setFormat("16*9");
			else list.films.get(index).setFormat("4*3");
			list.saveAll();
			mainMenu();
			}
			break;		
		case ("0"): filmMenu(index); break;	
		default:{
			System.out.println("��������� �������� �������. ���������� ��� ���");
			changeMenu(index);
			break;					
			}
		}
		scn.close(); 
		
	}
	
	public boolean isNumeric(String str) {
		try {
		      Integer.parseInt(str);
		      return true;
		    } catch (NumberFormatException e) {
		        return false;
		    }
		}

}
