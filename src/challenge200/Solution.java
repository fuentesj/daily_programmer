package challenge200;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jon on 2/3/15.
 */
public class Solution {

    public static void main(String[] args) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("challenge200-input.txt"));
            List<String[]> grid = buildGrid(bufferedReader);
            List<String> floodFillStartingInfo = Arrays.asList(bufferedReader.readLine().split(" "));
            System.out.println(floodFillStartingInfo);
            

        } catch (Exception exception) {
            System.out.println(exception.getCause().toString());
        }
    }

    private static List<String[]> buildGrid(BufferedReader bufferedReader) throws IOException {
        String[] dimensions = bufferedReader.readLine().split(" ");
        String[][] grid = new String[Integer.parseInt(dimensions[1])][Integer.parseInt(dimensions[0])];
        for (int current = 0; current < grid.length; current++){
            grid[current] = bufferedReader.readLine().split("");
        }
        return Arrays.asList(grid);
    }

}
