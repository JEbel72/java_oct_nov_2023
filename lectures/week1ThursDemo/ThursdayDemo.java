import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ThursdayDemo {

    public static void main(String[] args) {
        int[] myNumbers = {8, 15, 1, 6}; // Create an array with the values 8, 15, 1, 6
        System.out.println(myNumbers[1]);
        // myNumbers[1] = 30;
        // System.out.println(myNumbers[1]);

        String[] names = new String[10]; // {null, null, null, ...}
        System.out.println(names[0]);
        // Old-fashioned way to loop through an array
        // for (int i = 0; i < myNumbers.length; i++) {
        //     System.out.println(myNumbers[i]);
        // }
        // Enhanced for loop
        for (int currentValue : myNumbers) { // We grab the value directly - no index involved
            System.out.println(currentValue);
        }

        // ArrayList
        ArrayList<Integer> myScores = new ArrayList<Integer>(); // NO PRIMITIVE TYPES ALLOWED!!!!
        myScores.add(80);
        myScores.add(96);
        myScores.add(65);
        myScores.add(100);
        System.out.println(myScores);

        DataFun dataFunInstance = new DataFun();
        System.out.println(dataFunInstance.averageScores(myScores));

        // Demo with linking companies and headquarters with a HashMap
        HashMap<String, String> companyHeadquarters = new HashMap<String, String>();
        companyHeadquarters.put("Boeing", "Chicago");
        companyHeadquarters.put("Apple", "Cupertino");
        companyHeadquarters.put("Amazon", "Seattle");
        System.out.println(companyHeadquarters);
        Set<String> allCompanies = companyHeadquarters.keySet(); // Grab all the companies
        for (String company : allCompanies) { // Go through each company and display where its HQ are
            // Note the .get() below to grab the city the company is in
            System.out.println(company + " is in " + companyHeadquarters.get(company));
        }
    }
}