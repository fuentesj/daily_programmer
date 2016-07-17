package challenge273_easy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jonathan on 7/16/16.
 */
public class Solution {

    private static final String DEGREE_UNIT = "d";
    private static final String RADIAN_UNIT = "r";

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter input filename: ");
        String inputFileName = scanner.nextLine();

        Pattern numberValueRegex = Pattern.compile("[0-9]+.?[0-9]+");
        Pattern unitRegex = Pattern.compile("[a-z]{2}$");

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("input-files/challenge273/" + inputFileName))) {
            String nextLine = bufferedReader.readLine();
            while (nextLine != null) {
                Matcher numberValueMatcher = numberValueRegex.matcher(nextLine);
                numberValueMatcher.find();
                Float numberValue = Float.parseFloat(numberValueMatcher.group(0));

                Matcher unitMatcher = unitRegex.matcher(nextLine);
                unitMatcher.find();
                String unit = unitMatcher.group(0);
                String fromUnit = Character.toString(unit.charAt(0));
                String toUnit = Character.toString(unit.charAt(1));

                if (RADIAN_UNIT.equals(fromUnit) && DEGREE_UNIT.equals(toUnit)) {
                    System.out.println(radianToDegrees(numberValue) + DEGREE_UNIT);
                } else if (DEGREE_UNIT.equals(fromUnit) && RADIAN_UNIT.equals(toUnit)) {
                    System.out.println(degreesToRadians(numberValue) + RADIAN_UNIT);
                } else {
                    System.out.println("Invalid input entered.");
                }
                nextLine = bufferedReader.readLine();
            }
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }
    }

    private static double radianToDegrees(double numOfRadians) {
        return (numOfRadians * (180 / Math.PI));
    }

    private static double degreesToRadians(double numOfDegrees) {
        return (numOfDegrees * (Math.PI / 180));
    }
}
