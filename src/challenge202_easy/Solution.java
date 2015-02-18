package challenge202_easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jon on 2/17/15.
 */
public class Solution {

    public static void main(String[] args) {

        String[] currentInputArray = new String[1000];
        System.out.print("Please enter binary here: ");
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        List<Integer> charCodeList = new ArrayList<>();
        while (!nextLine.equals("END")) {
            currentInputArray = nextLine.split("");
            charCodeList.addAll(processInputArray(currentInputArray));
            nextLine = scanner.nextLine();
        }

        for (Integer charCode : charCodeList) {
            Character character = new Character((char) charCode.intValue());
            System.out.println(character);
        }

    }

    private static List<Integer> processInputArray(String[] currentInputArray) {
        List<Integer> userInputStringList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        int nextStartingIndex = 0;
        int nextEndingIndex = 8;
        while (nextEndingIndex < currentInputArray.length) {

            for (int currentIndex = nextStartingIndex; currentIndex < nextEndingIndex; currentIndex++) {
                stringBuilder.append(currentInputArray[currentIndex]);
            }
            userInputStringList.add(Integer.parseInt(stringBuilder.toString(), 2));
            stringBuilder.delete(0, stringBuilder.length());
            nextStartingIndex = nextEndingIndex;
            nextEndingIndex += 8;
        }

        return userInputStringList;

    }
}
