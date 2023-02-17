
public class City {
	
	private String name;
	private int distance;

	public City(String name, int distance) {
		this.name = name;
		this.distance = distance;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String toString() {
		return String.format("%s (%d)", name, distance);
	}

}
