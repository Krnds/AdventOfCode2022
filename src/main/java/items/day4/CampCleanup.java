package items.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CampCleanup {

    public static void main(String[] args) throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader("./resources/input-day4.txt"));
        List<Boolean> results = new ArrayList<>();

        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            results.add(isSectionAssignmentContainsFully(line));
        }
        System.out.println("The answer of day 4 is: " + results.stream().filter(r -> r == true).count());
    }

    private static boolean isSectionAssignmentContainsFully(String intervalsOfLists) {
        List<String> sections = new ArrayList<>();
        sections.addAll(Arrays.stream(intervalsOfLists.split(",")).collect(Collectors.toList()));

        List<Integer> firstSection = Arrays.stream(sections.get(0).split("-")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondSection = Arrays.stream(sections.get(1).split("-")).map(Integer::parseInt).collect(Collectors.toList());

        int A0 = firstSection.get(0);
        int A1 = firstSection.get(1);
        int B0 = secondSection.get(0);
        int B1 = secondSection.get(1);
        boolean firstIntersection = A0 <= B0 && B1 <= A1;
        boolean secondIntersection = B0 <= A0 && A1 <= B1;
        return firstIntersection || secondIntersection;
    }
}