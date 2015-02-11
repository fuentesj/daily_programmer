package challenge197_easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by jon on 2/10/15.
 */
public class Solution {

    public static void main(String[] args) {

        System.out.print("Please enter a ISBN: ");
        Scanner scanner = new Scanner(System.in);
        String[] unvalidatedIsbnStringArray = scanner.nextLine().replace("-", "").split("");
        List<Integer> isbnDigitList = Arrays.stream(unvalidatedIsbnStringArray).map(current -> Integer.parseInt(current)).collect(Collectors.toList());

        int currentMultiplier = 10;
        int sum = 0;

        for (Integer digit : isbnDigitList) {
            sum += digit * currentMultiplier;
            currentMultiplier -= 1;
        }

        if (sum % 11 == 0) {
            System.out.println("Valid ISBN!");
        } else {
            System.out.println("Invalid ISBN!");
        }
    }
}
