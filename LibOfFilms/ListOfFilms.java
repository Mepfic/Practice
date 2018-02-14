package libFilms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ListOfFilms extends Main {
	final String dbWay = "res//db.dat";
	final String printWay = "res//print.txt";
	Scanner scn;
	ArrayList <Film> films  = new ArrayList<Film>();
	
	@SuppressWarnings("unchecked")
	public void downloadBase() {
		System.out.println("������� ��������� ���� �������...");
		try(FileInputStream fis=new FileInputStream(dbWay)){
				ObjectInputStream ois = new ObjectInputStream(fis);
				try {
					films = (ArrayList <Film>) ois.readObject();					
				} catch (ClassNotFoundException e) {
					System.out.println(e.getMessage());					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("���� ������� ���������!");
	}
	
	public void saveAll() {
		System.out.println("������� ��������� ���� �������...");			
		try(FileOutputStream fos=new FileOutputStream(dbWay)){
        	ObjectOutputStream oos = new ObjectOutputStream(fos);        	  
        		oos.writeObject(films);
        		oos.flush();
        		oos.close();           	  
		 }
         catch (FileNotFoundException e) {
        	System.out.println(e.getMessage());
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("���� ������� ������� ���������!");
	}
	
	public void showAll() {
		System.out.println("\n"+"������ ���� �������... �� ��� �����, ��� �������� ��. ��������� �����������, ����� ��������� ���������!");	
		for (Film film : films) {
				System.out.printf("�����: %s, ����: %s, %d ���, ���������: %s, ������� %.2f, ����������������� %d ���, ������ %s; \n", 
						film.getName(), film.getGenre(), film.getYear(), film.getProducer(), film.getRating(), film.getLongTime(), film.getFormat());
		}
		
	}
	
	public void createFilm (String name, String genre, int year, String producer, double rating, int longTime, String format) {		
		
		films.add(new Film (				
			name, 
			genre,
			year,
			producer,
			rating,
			longTime,
			format));
		saveAll();
		System.out.println("����� ������� �������� � ���������" + "\n");
		
	}
	
	public int findByName (String name) {
		
		for (Film film : films) {
			if (film.getName().equals(name)) {
				System.out.println("���-�� ���� �����...");
				System.out.printf("�����: %s, ����: %s, %d ���, ���������: %s, ������� %.2f, ����������������� %d ���, ������ %s;", 
						film.getName(), film.getGenre(), film.getYear(), film.getProducer(), film.getRating(), film.getLongTime(), film.getFormat());				
				return films.indexOf(film);				
			}	
		}
		return -1;
	}
	
	public int findByYear (int year) {
		
		for (Film film : films) {
			if (film.getYear() == year) {
				System.out.println("���-�� ���� �����...");
				System.out.printf("�����: %s, ����: %s, %d ���, ���������: %s, ������� %.2f, ����������������� %d ���, ������ %s;", 
						film.getName(), film.getGenre(), film.getYear(), film.getProducer(), film.getRating(), film.getLongTime(), film.getFormat());				
				return films.indexOf(film);
			}
		}
		return -1;		
	}
	
	public void printAboutFilm(int index) {
		PrintWriter printInTxt = null;
	    	try
	    	{
	        	 printInTxt = new PrintWriter(new FileOutputStream(printWay));
		       }
	        catch(FileNotFoundException e)
	    	{
		             System.out.printf("������ �������� ����� %s", printWay);
		             
		        }
	    	Film film = films.get(index);
	        printInTxt.printf("�����: %s, %s, %d ���, ��������� %s, ������� %f, ����������������� %d ���, ������ %s \n", 
					film.getName(), film.getGenre(), film.getYear(), film.getProducer(), film.getRating(), film.getLongTime(), film.getFormat());
	           
	        printInTxt.close();
	        System.out.println("���������� � ������ ������� ��������� � ��������� ����");    
		         
	}
	
	public void removeFilm(int index) {
		films.remove(index);
		films.trimToSize();
		saveAll();
	}
	
	public void sortByName() {
		Collections.sort(films, Film.getFilmByName());
		saveAll();		
	}
	
	public void sortByYear() {
		Collections.sort(films, Film.getFilmByYear());
		saveAll();		
	}
	    
}
