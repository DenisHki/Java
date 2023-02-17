import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		LinkedList<City> cities = new LinkedList<>();
		
		AddCity(cities, new City("Tampere", 180));
		AddCity(cities, new City("Turku", 168));
		AddCity(cities, new City("Porvoo", 52));
		AddCity(cities, new City("Kotka", 133));
		AddCity(cities, new City("Rovaniemi", 811));
		AddCity(cities, new City("Lappeenranta", 224));
		AddCity(cities, new City("Oulu", 610));
		
		cities.addFirst(new City("Helsinki", 0));
				
		var iterator = cities.listIterator();
		Scanner input = new Scanner(System.in);
		boolean quiteLoop = false;
		boolean forward = true;
		
		printMenu();
		
		while (!quiteLoop) {
			
			if (!iterator.hasPrevious()) {
				System.out.println("Starting : " + iterator.next());
				forward = true;
			}
			
			if (!iterator.hasNext()) {
				System.out.println("Final : " + iterator.previous());
				forward = false;
			}
			
			System.out.println();
			System.out.print("Enter Value: ");
			String menuItem = input.nextLine().toUpperCase().substring(0, 1);
			System.out.println();
			
			switch (menuItem) {
			
			case "F":
				System.out.println("User wants to go forward");
				
				// Reversing direction:
				if (!forward) {
					forward = true;
					
					// Adjust position forward:
					if (iterator.hasNext()) {
						iterator.next();
					}
				}
				
				if (iterator.hasNext()) {
					System.out.println(iterator.next());
				}
				
				break;
				
			case "B":
				System.out.println("User wants to go backwards");
				
				// Reversing direction:
				if (forward) {
					forward = false;
					
					// Adjust position backwards:
					if (iterator.hasPrevious()) {
						iterator.previous();
					}				
				}
				
				if (iterator.hasPrevious()) {
					System.out.println(iterator.previous());
				}
				
				break;
				
			case "M":
				printMenu();
				break;
				
			case "L":
				System.out.println(cities);
				break;
				
			default:
				quiteLoop = true;
				break;
			}		
		}
		
		input.close();

	}
	
	private static void AddCity(LinkedList<City> list, City city) {
		
		if (list.contains(city)) {
			System.out.println("Found duplicate: " + city);
			return;
		}
		
		for (City c : list) {
			if(c.getName().equalsIgnoreCase(city.getName())) {
				System.out.println("Found dublicate: " + city);
				return;
			}
		}
		
		int matchedIndex = 0;
		
		for (var listCity : list) {
			if (city.getDistance() < listCity.getDistance()) {
				list.add(matchedIndex, city);
				return;
			}
			
			matchedIndex++;
			
		}
		
		list.add(city);
	
	}
	
	private static void printMenu() {
		
		System.out.println("Available actions (select word or letter):");
		System.out.println("(F)orward\n(B)ackward\n(L)ist Places\n(M)enu\n(Q)uit");
		System.out.println();
		
	}

}
