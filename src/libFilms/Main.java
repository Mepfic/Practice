package libFilms;

public class Main {
	static InterfaceMenu menu = new InterfaceMenu();
	static ListOfFilms list = new ListOfFilms();
	public static void main(String[] args) {
		list.downloadBase();
		menu.mainMenu();
	}
}
