package items.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RucksackReorganization {

    public static void main(String[] args) throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader("./resources/input-day3.txt"));
        int totalSCore = 0;

        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            totalSCore += findCommonItem(line);
        }
        System.out.println("The answer of day 3 is: " + totalSCore);
    }


    private static int findCommonItem(String rucksackContent) {
        int halfLength = rucksackContent.length() / 2;
        String firstCompartment = rucksackContent.substring(0, halfLength);
        String secondCompartment = rucksackContent.substring(halfLength, rucksackContent.length());
        CommonItemChar c = CommonItemChar.valueOf(String.valueOf(findCommonCharOptimized(firstCompartment, secondCompartment)));
        return c.priority;
    }

    private static char findCommonCharOptimized(String firstCompartment, String secondCompartment) {
        char commonChar = firstCompartment.chars().mapToObj(c1 -> (char) c1)
                .filter(c1 -> secondCompartment.chars().mapToObj(c2 -> (char) c2).anyMatch(c2 -> c1 == c2))
                .findFirst()
                .orElse('\u0000');
        return commonChar;
    }

}
