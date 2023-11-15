package tuesdayWeek8Demo;

public class Solution {
	public void getSubstring(String str, int startingInd, int endingInd) {
		String actualSubstr = ""; // Hold the actual string we will eventually print, starting with an empty one
		// Grab each character we need and add it to the string
		for (int k = startingInd; k < endingInd; k++) {
			actualSubstr = actualSubstr + str.charAt(k); // Add character to string
		}
		System.out.println(actualSubstr); // Display substring
	}
}
