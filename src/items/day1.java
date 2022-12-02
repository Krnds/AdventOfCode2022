package items;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class day1 {

    public static void main(String[] args) {
        findSolution();
    }

    public static void findSolution() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("./resources/input-day1.txt"));
            List<Integer> caloriesCurrentElf = new ArrayList<>();
            List<Integer> listOfCalories = new ArrayList<>();

            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (!line.isBlank()) {
                    caloriesCurrentElf.add(Integer.parseInt(line));
                } else {
                    var totalCaloriesCurrentElf = (Integer) caloriesCurrentElf.stream().mapToInt(Integer::intValue).sum();
                    listOfCalories.add(totalCaloriesCurrentElf);
                    caloriesCurrentElf.clear();
                }
            }
            reader.close();
            Collections.sort(listOfCalories, Collections.reverseOrder());
            System.out.println("The answer of day 1 is: " + listOfCalories.get(0));
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
