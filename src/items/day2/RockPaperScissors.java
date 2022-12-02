package items.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RockPaperScissors {

    private static final int lost = 0;
    private static final int draw = 3;
    private static final int won = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader("./resources/input-day2.txt"));
        int totalSCore = 0;

        for (String line = reader.readLine(); line != null; line = reader.readLine()) {

            OpponentShape opp = OpponentShape.valueOf(String.valueOf(line.charAt(0)));
            UserShape user = UserShape.valueOf(String.valueOf(line.charAt(2)));
            totalSCore += getResultFromRound(opp, user);
        }

        System.out.println("The answer of day 2 is: " + totalSCore);
    }


    private static int getResultFromRound(OpponentShape opponentShape, UserShape userShape) {
        int roundResult = 0;
        char user = userShape.name().charAt(0);

        switch (opponentShape) {
            case A:
                if (user == 'X') {
                    roundResult = draw;
                } else if (user == 'Y') {
                    roundResult = won;
                } else if (user == 'Z') {
                    roundResult = lost;
                }
                break;
            case B:
                if (user == 'X') {
                    roundResult = lost;
                } else if (user == 'Y') {
                    roundResult = draw;
                } else if (user == 'Z') {
                    roundResult = won;
                }
                break;
            case C:
                if (user == 'X') {
                    roundResult = won;
                } else if (user == 'Y') {
                    roundResult = lost;
                } else if (user == 'Z') {
                    roundResult = draw;
                }
                break;
        }
        return userShape.score + roundResult;
    }
}

