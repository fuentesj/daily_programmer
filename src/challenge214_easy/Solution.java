package challenge214_easy;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by jon on 6/17/15.
 */
public class Solution {

    public static void main(String[] args) {

        System.out.print("Please enter numbers separated by spaces: ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        /*
        Not sure using Java 8 streams is the best idea here. Creating a new List and iterating through the array
        seems much more readable.

        List<Integer> integerList = new ArrayList<>();
        for (String integerString : inputString.split(" ")) {
            integerList.add(Integer.parseInt(inputString));
        }
        */

        // Not sure what the stream implications are for memory usage
        List<Integer> integerList = Arrays.stream(inputString.split(" ")).map(currentIntString -> Integer.parseInt(currentIntString)).collect(Collectors.toList());

        Integer sum = integerList.stream().reduce(0, (a,b) -> a+b);

        Integer mean = sum / integerList.size();

        Double variance = 0.0;
        for (Integer currentInt : integerList) {
            variance += Math.pow((double) currentInt - mean, (double) 2);
        }

        variance = variance / integerList.size();

        DecimalFormat decimalFormat = new DecimalFormat("#.0000");
        System.out.println("The population standard deviation is: " + decimalFormat.format(Math.sqrt(variance)));
    }
}
