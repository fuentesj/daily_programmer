package challenge238_easy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by jon on 11/3/15.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            Pattern vowelPattern = Pattern.compile("[aeiouAEIOU]");
            Pattern consonantPattern = Pattern.compile("bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ");

            String currentLine = null;
            while ( (currentLine = bufferedReader.readLine()) != null) {
                if (0 < currentLine.length()) {
                    String[] currentLineArrray = currentLine.split("");
                    for (String string : currentLineArrray) {
                        if (string.equals("c")) {
                            System.out.println();
                        } else if (string.equals("v")) {
                            System.out.println();
                        } else {
                            System.out.println("Invalid character");
                            break;
                        }
                    }
                }
            }

        } catch (FileNotFoundException fileNotFoundException) {

        } catch (IOException ioException) {

        }
    }
}
