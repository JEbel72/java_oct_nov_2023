package tuesdayWeek2Demo;

public class TuesdayDemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		House myHouse = new House();
		House dreamHouse = new House(37, 50000, "10000 Millionaire Way", "gold");
		dreamHouse.repaintHouse("purple");
		myHouse.repaintHouse("pink");
		System.out.println(dreamHouse.getNumberOfBedrooms());
	}

}
