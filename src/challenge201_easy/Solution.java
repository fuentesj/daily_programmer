package challenge201_easy;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Created by jon on 2/9/15.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.print("Please enter a date with the format yyyy-MM-dd: ");
        Scanner scanner = new Scanner(System.in);
        String dateString = scanner.nextLine();
        String[] dateArray = dateString.split("-");
        LocalDate targetDate = LocalDate.of(Integer.parseInt(dateArray[0]), Integer.parseInt(dateArray[1]), Integer.parseInt(dateArray[2]));
        LocalDate today = LocalDate.now();
        Long numberOfDaysBetween = ChronoUnit.DAYS.between(today, targetDate);
        System.out.println(numberOfDaysBetween + " days from " + today.toString() + " to " + targetDate.toString());
    }
}
