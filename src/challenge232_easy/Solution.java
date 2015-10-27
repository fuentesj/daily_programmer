package challenge232_easy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by jon on 10/27/15.
 */
public class Solution {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input-files/challenge232/input.txt"))) {

            String input = "";
            int numOfLines = Integer.parseInt(bufferedReader.readLine());

            for (int currentLineNum = 0; currentLineNum < numOfLines; currentLineNum++) {
                input += bufferedReader.readLine();
            }

            if (isPalindrome(input)) {
                System.out.println("Palindrome");
            } else {
                System.out.println("Not a palindrome");
            }
        } catch (IOException exception) {
            System.out.println(exception.getStackTrace());
        }
    }


    public static boolean isPalindrome(String input) {
        String inputWithNoWhitespace = input.replaceAll("[\\s?!.]", "");
        String[] inputArray = inputWithNoWhitespace.split("");

        int startIndex = 0;
        int endIndex = inputArray.length - 1;

        if (inputArray.length % 2 == 0) {
            while (startIndex != endIndex - 1) {
                if (!inputArray[startIndex].equals(inputArray[endIndex])) {
                    return false;
                }
                startIndex++;
                endIndex--;
            }
            return true;
        } else {
            while (startIndex != endIndex) {
                if (!inputArray[startIndex].equalsIgnoreCase(inputArray[endIndex])) {
                    return false;
                }
                startIndex++;
                endIndex--;
            }
            return true;
        }
    }
}
