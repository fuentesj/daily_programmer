package challenge200;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jon on 2/3/15.
 */
public class Solution {


    public static List<String> borderCharacters = new ArrayList<>();
    public static String targetCharacter = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter border characters separated by spaces:");
        borderCharacters = Arrays.asList(scanner.nextLine().split(" "));

        System.out.print("Please enter a target character:");
        targetCharacter = scanner.nextLine();

        System.out.print("Please enter the filename: ");
        String inputFileName = scanner.nextLine();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("input-files/challenge200/" + inputFileName));
            List<String[]> grid = buildGrid(bufferedReader);
            List<String> floodFillStartingInfo = Arrays.asList(bufferedReader.readLine().split(" "));
            floodFillGrid(grid, Integer.parseInt(floodFillStartingInfo.get(1)), Integer.parseInt(floodFillStartingInfo.get(0)), floodFillStartingInfo.get(2));
            grid.forEach((String[] row) -> System.out.println(Arrays.deepToString(row)));

        } catch (Exception exception) {
            System.out.println(exception.getCause().toString());
        }
    }

    private static void floodFillGrid(List<String[]> grid, Integer yCoordinate, Integer xCoordinate, String newCharacter) {
        if (xCoordinate < 0 || yCoordinate < 0 || yCoordinate >= grid.size() || xCoordinate >= grid.get(yCoordinate).length) {
            return;
        } else {
            String currentCharacter = grid.get(yCoordinate)[xCoordinate];
            if (borderCharacters.contains(currentCharacter) || currentCharacter.equals(newCharacter)) {
                return;
            } else {
                if (currentCharacter.equals(targetCharacter)) {
                    grid.get(yCoordinate)[xCoordinate] = newCharacter;
                }
                floodFillGrid(grid, yCoordinate + 1, xCoordinate, newCharacter);
                floodFillGrid(grid, yCoordinate - 1, xCoordinate, newCharacter);
                floodFillGrid(grid, yCoordinate, xCoordinate + 1, newCharacter);
                floodFillGrid(grid, yCoordinate, xCoordinate - 1, newCharacter);
            }
        }
    }

    private static List<String[]> buildGrid(BufferedReader bufferedReader) throws IOException {
        String[] dimensions = bufferedReader.readLine().split(" ");
        String[][] grid = new String[Integer.parseInt(dimensions[1])][Integer.parseInt(dimensions[0])];
        for (int current = 0; current < grid.length; current++) {
            grid[current] = bufferedReader.readLine().split("");
        }
        return Arrays.asList(grid);
    }

}
