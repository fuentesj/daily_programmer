package challenge204_easy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
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

            List<String> passageLineList = new ArrayList<>();
            boolean isPassageFound = false;

            Pattern pattern = Pattern.compile("^\t{4}");
            Matcher matcher;

            String nextLine = bufferedReader.readLine();
            while (nextLine != null && !isPassageFound) {
                matcher = pattern.matcher(nextLine);
                if (matcher.matches()) {
                    passageLineList.add(nextLine.trim());
                } else if (!passageLineList.isEmpty() && passageLineList.contains(stringToSearchFor)) {
                    break;
                } else {
                    passageLineList.clear();
                }
                nextLine = bufferedReader.readLine();
            }

            if (passageLineList.contains(stringToSearchFor)) {
                for(String line : passageLineList) {
                    System.out.println(line);
                }
            }


        } catch (Exception exception) {
            System.out.println(exception.getStackTrace());
        }
    }
}
