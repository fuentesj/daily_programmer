package challenge202_easy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jon on 2/17/15.
 */
public class Solution {

    public static void main(String[] args) {

        try (InputStream inputStream = new FileInputStream("input-files/challenge202/input-1.txt")) {

            byte[] byteArray = new byte[100];

            int isByteSuccessfullyRead = inputStream.read(byteArray);


        } catch (Exception exception) {
            System.out.println(exception.getStackTrace());
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
