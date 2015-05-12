package challenge212_easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jon on 5/12/15.
 */
public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        String[] notConsonantArray = new String[]{"a", "A", "e", "E", "i", "I", "o", "O", "u", "U", "'"};
        StringBuilder stringBuilder = new StringBuilder();
        String[] inputStringArray = inputString.split(" ");
        for (String token : inputStringArray) {
            String[] characterArray = token.split("");
            for (String character : characterArray) {
                if (!Arrays.asList(notConsonantArray).contains(character)) {
                    stringBuilder.append(character + "o" + character.toLowerCase());
                } else {
                    stringBuilder.append(character);
                }
            }
            stringBuilder.append(" ");
        }

        System.out.println(stringBuilder.toString());
    }
}
