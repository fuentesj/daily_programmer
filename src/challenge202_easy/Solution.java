package challenge202_easy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by jon on 2/17/15.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter in file name: ");
        String inputFilename = scanner.nextLine();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input-files/challenge202/" + inputFilename))) {
            String nextLine = bufferedReader.readLine();
            StringBuilder outputStringBuilder = new StringBuilder();
            while (nextLine != null) {
                if (nextLine.length() % 8 != 0) {
                    nextLine += bufferedReader.readLine();
                } else {
                    outputStringBuilder.append(processInputString(nextLine));
                    nextLine = bufferedReader.readLine();
                }
            }
            System.out.println(outputStringBuilder.toString());
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }
    }

    private static String processInputString(String inputString) {
        StringBuilder stringBuilder = new StringBuilder();
        int currentIndex = 0;
        while (currentIndex < inputString.length()) {
            String inputSubstring = inputString.substring(currentIndex, currentIndex + 8);
            int charCode = Integer.parseInt(inputSubstring, 2);
            stringBuilder.append(new Character((char) charCode));
            currentIndex += 8;
        }
        return stringBuilder.toString();
    }
}
