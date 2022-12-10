package items.day5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SupplyStacks {

    public static void main(String[] args) {
        System.out.println("The answer of day 5 is : " + initShipConfig());
    }

    public static List<Character> moveCrates(List<LinkedList<Character>> entry, BufferedReader order, int acc) throws IOException {
        String line;
        while ((line = order.readLine()) != null) {
            Pattern p = Pattern.compile("move\\s(\\d\\d?) from (\\d) to (\\d)");
            Matcher m = p.matcher(line);
            int stacksToMove, x, y;
            stacksToMove = x = y = 0;
            if (m.find()) {
                stacksToMove = Integer.parseInt(m.group(1));
                x = Integer.parseInt(m.group(2)) - 1;
                y = Integer.parseInt(m.group(3)) - 1;
            }
            LinkedList<Character> copyOfStack = (LinkedList<Character>) entry.get(y).clone();

            // Add all stacks to destination
            for (int j = 0; j < stacksToMove; j++) {
                copyOfStack.add(0, entry.get(x).get(j));
            }
            entry.set(y, copyOfStack);
            // removing all the stacks to move
            for (int j = 0; j < stacksToMove; j++) {
                entry.get(x).removeFirst();
            }
            moveCrates(entry, order, acc + 1);
        }
        return entry.stream().map(l -> l.getFirst()).collect(Collectors.toList());
    }

    public static String initShipConfig() {
        List<String> listOfStacks = new ArrayList<>();
        listOfStacks.add("RHMPZ");
        listOfStacks.add("BJCP");
        listOfStacks.add("DCLGHNS");
        listOfStacks.add("LRSQDMTF");
        listOfStacks.add("MZTBQPSF");
        listOfStacks.add("GBZSFT");
        listOfStacks.add("VRN");
        listOfStacks.add("MCVDTLGP");
        listOfStacks.add("LMFJNQW");

        List<LinkedList<Character>> allStacks = new ArrayList<>();

        for (int i = 0; i < listOfStacks.size(); i++) {
            String currentString = listOfStacks.get(i);
            allStacks.add(i, currentString.chars().mapToObj(c -> (char) c).collect(Collectors.toCollection(LinkedList::new)));
        }

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("./resources/input-day5.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            return moveCrates(allStacks, reader, 0).toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
