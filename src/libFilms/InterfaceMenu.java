package libFilms;


import java.util.Scanner;


public class InterfaceMenu extends Main{
	public final int startYearFilm = 1895;
	public final int currentlyYearFilm = 2018;
	Scanner scn;
	
	public void mainMenu() {		
		System.out.println("Добро пожаловать в фильмотеку. Только у нас уникальная подборка фильмов всех времен и народов!!!"+ "\n"+ 
				"Введите номер пункта меню:" + "\n"+
				"1. показать список фильмов" + "\n"+
				"2. найти фильм" + "\n"+
				"3. добавить фильм"  + "\n"+
				"0. выйти из программы");
		
		scn = new Scanner(System.in);
		switch (scn.next()) {
		case ("1"): listMenu(); break;			
		case ("2"): findMenu();	break;
		case ("3"): addingMenu(); break;
		case ("0"): list.saveAll(); System.exit(0); break;		
		default:{
			System.out.println("Введенное значение неверно. Попробуйте еще раз");
			mainMenu();
			break;					
			}
		}
		scn.close();  
	}
	
	public void listMenu() {
		list.showAll();
		System.out.println("\n"+ 
				"Введите номер пункта меню:" + "\n"+
				"1. сортировать по названию" + "\n"+
				"2. сортировать по году" + "\n"+
				"3. добавить фильм"  + "\n"+
				"4. найти фильм"  + "\n"+				
				"0. вернуться назад");
		
		scn = new Scanner(System.in);
		switch (scn.next()) {
		case ("1"): list.sortByName(); listMenu(); break;			
		case ("2"): list.sortByYear(); listMenu(); break;
		case ("3"): addingMenu(); break;
		case ("4"): findMenu(); break;
		case ("0"): mainMenu(); break;		
		default:{
			System.out.println("Введенное значение неверно. Попробуйте еще раз");
			listMenu();
			break;					
			}
		}
		scn.close(); 
		
	}
	
	public void findMenu() {
		System.out.println("Можно и поискать. Как будем искать?"+ "\n"+ 
				"Введите номер пункта меню:" + "\n"+
				"1. найти по названию" + "\n"+
				"2. найти по году" + "\n"+							
				"0. вернуться назад");
		
		scn = new Scanner(System.in);
		switch (scn.next()) {
		case ("1"): findOfNameMenu(); break;			
		case ("2"): findOfYearMenu(); break;		
		case ("0"): listMenu(); break;		
		default:{
			System.out.println("Введенное значение неверно. Попробуйте еще раз");
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
		
		System.out.println("Будем добавлять новый фильм в нашу коллекцию:"+ "\n"+ 
				"введите название и нажмите Enter" + "\n"+							
				"0. вернуться назад");
		
		scn = new Scanner(System.in);
		input = scn.nextLine();
		if (input.equals("0")) {listMenu(); return;}			
		else name = input;	
		
		System.out.println("Введите жанр");
		genre = scn.nextLine();
		
		System.out.println("Введите год премьеры");	
		input = scn.nextLine();		
		if (isNumeric(input) && Integer.parseInt(input) > startYearFilm && Integer.parseInt(input) < currentlyYearFilm)  year = Integer.parseInt(input);	
		else year = startYearFilm;	
		
		System.out.println("Введите имя продюссера");	
		producer = scn.nextLine();	
		
		System.out.println("Введите рейтинг фильма");
		if (scn.hasNextDouble()) rating = scn.nextDouble();
		else rating = 0.0; input = scn.nextLine();
		
		System.out.println("Введите продолжительность в минутах");	
		if (scn.hasNextInt()) longTime = scn.nextInt();
		else longTime = 0; input = scn.nextLine();	
		
		System.out.println("Широкоформатный фильм (16*9)? Введите 1 если да, или нажмите любую клавишу, если нет.");
		if (scn.next().equals("1")) format = "16*9";
		else format = "4*3";
		
		list.createFilm(name, genre, year, producer, rating, longTime, format);		
		listMenu();
		scn.close();
	}
	
	public void findOfNameMenu() {
		System.out.println(
				"введите название и нажмите Enter" + "\n"+
				"0. вернуться назад");
		
		scn = new Scanner(System.in);
		int index;
		String input = scn.nextLine();
		if (input.equals("0")) {listMenu(); return;}			
			else index = list.findByName(input);
		if (index == -1) {System.out.println("Фильм не найден"); findMenu();} 
			else filmMenu(index);
		scn.close();
	}
	 
	public void findOfYearMenu() {
		System.out.println(
				"введите год и нажмите Enter" + "\n"+
				"0. вернуться назад");
		
		scn = new Scanner(System.in);
		int index;
		String input = scn.next();
		if (input.equals("0")) {listMenu(); return; }		
			else if (!isNumeric(input)) {findOfYearMenu(); return;}
			else index = list.findByYear(Integer.parseInt(input));
		if (index == -1) {System.out.println("Фильм не найден"); findMenu();}
			else filmMenu(index);
		scn.close();
	}
	
	public void filmMenu(int index) {
		System.out.println("\n"+"Что с фильмом будем делать?"+ "\n"+ 
				"Введите номер пункта меню:" + "\n"+
				"1. распечатать" + "\n"+
				"2. изменить" + "\n"+
				"3. удалить" + "\n"+
				"0. вернуться назад");
		
		scn = new Scanner(System.in);
		switch (scn.next()) {
		case ("1"): list.printAboutFilm(index); mainMenu(); break;			
		case ("2"): changeMenu(index); mainMenu(); break;
		case ("3"): list.removeFilm(index); mainMenu(); break;
		case ("0"): findMenu(); break;		
		default:{
			System.out.println("Введенное значение неверно. Попробуйте еще раз");
			filmMenu(index);
			break;					
			}
		}
		scn.close(); 
	}
	
	public void changeMenu(int index){
		System.out.println("Что будем менять?"+ "\n"+ 
				"Введите номер пункта меню:" + "\n"+
				"1. название" + "\n"+
				"2. жанр" + "\n"+
				"3. год" + "\n"+
				"4. продюссер" + "\n"+
				"5. рейтинг" + "\n"+
				"6. продолжительность" + "\n"+
				"7. формат" + "\n"+
				"0. вернуться назад");
		
		scn = new Scanner(System.in);
		switch (scn.next()) {
		case ("1"): {
			System.out.println("Введите новое название");
			scn = new Scanner(System.in);
			list.films.get(index).setName(scn.nextLine());	
			list.saveAll();
			mainMenu();
			}
			break;			
		case ("2"): {
			System.out.println("Введите новый жанр");
			scn = new Scanner(System.in);
			list.films.get(index).setGenre(scn.nextLine());	
			list.saveAll();
			mainMenu();
			}
			break;		
		case ("3"): {
			System.out.println("Введите год");
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
			System.out.println("Введите имя продюссера");
			scn = new Scanner(System.in);
			list.films.get(index).setProducer(scn.nextLine());
			list.saveAll();
			mainMenu();
			}
			break;		
		case ("5"): {
			System.out.println("Введите новый рейтинг");
			scn = new Scanner(System.in);
			if (scn.hasNextDouble()) list.films.get(index).setRating(scn.nextDouble()); 
			else list.films.get(index).setRating(0.0);	
			list.saveAll();
			mainMenu();
			}
			break;					
		case ("6"): {
			System.out.println("Введите продолжительность");
			scn = new Scanner(System.in);
			if (scn.hasNextInt()) list.films.get(index).setLongTime(scn.nextInt());
			else list.films.get(index).setLongTime(0);
			list.saveAll();
			mainMenu();
			}
			break;		
		case ("7"): {
			System.out.println("Формат фильма. Введите 1 если формат 16*9, или нажмите любую клавишу, если 4*3.");
			scn = new Scanner(System.in);
			if (scn.next().equals("1")) list.films.get(index).setFormat("16*9");
			else list.films.get(index).setFormat("4*3");
			list.saveAll();
			mainMenu();
			}
			break;		
		case ("0"): filmMenu(index); break;	
		default:{
			System.out.println("Введенное значение неверно. Попробуйте еще раз");
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
