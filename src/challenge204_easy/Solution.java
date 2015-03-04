package challenge204_easy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jon on 3/3/15.
 */
public class Solution {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input-files/challenge204/macbeth.txt"))) {

            System.out.print("What should I search for?: ");
            Scanner scannner = new Scanner(System.in);
            String stringToSearchFor = scannner.nextLine();

            StringBuilder currentPassageBuilder = new StringBuilder();
            boolean isPassageFound = false;
            Pattern pattern = Pattern.compile("\\s{4}\\w*");
            Matcher matcher;

            String nextLine = bufferedReader.readLine();
            while (!isPassageFound) {
                matcher = pattern.matcher(nextLine);
                if (matcher.find()) {
                    currentPassageBuilder.append(nextLine);
                } else {
                    String currentPassageString = currentPassageBuilder.toString();
                    if (currentPassageString.contains(stringToSearchFor)) {
                        isPassageFound = true;
                    } else {
                        currentPassageBuilder.setLength(0);
                    }
                }
                nextLine = bufferedReader.readLine();
            }

            for (String passageLine : currentPassageBuilder.toString().split("\\s{4}")) {
                System.out.println(passageLine);
            }
        } catch (Exception exception) {
            System.out.println(exception.getStackTrace());
        }
    }
}
