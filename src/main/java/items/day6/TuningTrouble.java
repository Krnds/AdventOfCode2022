package items.day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TuningTrouble {

    public static void main(String[] args) throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader("./resources/input-day6.txt"));
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            char[] solution = findFirstStartOfPacketMarker(line, 0);
            Pattern packetWithoutDuplicates = Pattern.compile(new String(solution));
            Matcher matcher = packetWithoutDuplicates.matcher(line);
            if (matcher.find()) {
                System.out.println("The answer of day 6 is : " + (matcher.end()));
            }
        }

    }

    private static char[] findFirstStartOfPacketMarker(String input, int i) {
        char[] packet = input.substring(i, i + 4).toCharArray();
        for (int j = 0; j < input.length() - 4;) {
            if (isMarkerLettersAllDifferent(packet)) {
                return packet;
            } else return findFirstStartOfPacketMarker(input, i + 1);
        }
        return new String().toCharArray();
    }

    private static boolean isMarkerLettersAllDifferent(char[] packet) {
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (packet[i] == packet[j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
