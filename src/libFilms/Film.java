package libFilms;

import java.io.Serializable;
import java.util.Comparator;

@SuppressWarnings("serial")
public class Film implements Serializable, Comparator<Film>{
	private String name;
	private String genre;
	private int year;
	private String producer;
	private double rating;
	private int longTime;
	private String format; //16*9 or 4*3; 
	
	public static Comparator<Film> getFilmByName() {
		Comparator<Film> comp = new Comparator<Film>() {
			@Override
			public int compare(Film s1, Film s2) {
				return s1.name.compareTo(s2.name);
			}
		};
		return comp;
	}
	
	public static Comparator<Film> getFilmByYear() {
		Comparator<Film> comp = new Comparator<Film>() {
			@Override
			public int compare(Film s1, Film s2) {
				int compareTo;
				if (s1.year>s2.year) compareTo = 1;
				else if (s1.year<s2.year) compareTo = -1;
				else compareTo = 0;
				return compareTo;
			}
		};
		return comp;
	}
	
	
	public Film (String name, String genre, int year, String producer, double rating, int longTime, String format) {
		this.name = name;
		this.genre = genre;
		this.year = year;
		this.producer = producer;
		this.rating = rating;
		this.longTime = longTime;
		this.format = format;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getLongTime() {
		return longTime;
	}

	public void setLongTime(int longTime) {
		this.longTime = longTime;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	
	@Override
	public int compare(Film o1, Film o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
