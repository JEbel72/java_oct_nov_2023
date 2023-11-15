package tuesdayWeek8Demo;

public class SolutionTest {

	public static void main(String[] args) {
		// Inject our Solution class
		Solution mySolution = new Solution();
		// Various test cases - we will follow Hacker Rank and not worry about weird cases like start > end, indexes out of bounds,
		// empty strings, etc.
		mySolution.getSubstring("helloworld", 3, 7);
		mySolution.getSubstring("adrian", 3, 5);
		mySolution.getSubstring("anothertest",0,5);
	}

}
