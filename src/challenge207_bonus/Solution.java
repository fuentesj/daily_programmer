package challenge207_bonus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Created by jon on 3/26/15.
 */
public class Solution {

    public static void main(String[] args) {


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input-files/challenge207_bonus/input.txt"))) {
            String inputFileInfo = bufferedReader.readLine();
            String[] inputFileInfoArray = inputFileInfo.split("\\s");

            int numOfPaperTitles = Integer.parseInt(inputFileInfoArray[0]);
            int numOfAuthors = Integer.parseInt(inputFileInfoArray[1]);

            List<Set<String>> authorSetList = new ArrayList<>();
            for (int currentPaperTitleNum = 0; currentPaperTitleNum < numOfPaperTitles; currentPaperTitleNum++) {
                String nextLine = bufferedReader.readLine();
                String authorString = nextLine.replaceAll("(&)([\\sa-zA-Z\\.,]+)(.*)", "$2");
                Set<String> authorSet = new HashSet<>(Arrays.asList(authorString.split("(?<=[A-Z].),")));

                Set<String> trimmedAuthorSet = new HashSet<>();
                for (String author : authorSet) {
                    trimmedAuthorSet.add(author.trim());
                }
                authorSetList.add(trimmedAuthorSet);
                authorSet.toString();
            }

            Map<String, Set<String>> authorGraph = new HashMap<>();

            for (int currentAuthorNum = 0; currentAuthorNum < numOfAuthors; currentAuthorNum++) {
                String currentAuthor = bufferedReader.readLine();
                authorGraph.put(currentAuthor, new HashSet<>());
            }

            for (String author : authorGraph.keySet()) {
                for (Set<String> authorSet : authorSetList) {
                    if (authorSet.contains(author)) {
                        Set<String> existingAuthorSet = authorGraph.get(author);
                        existingAuthorSet.addAll(authorSet);
                        authorGraph.put(author, existingAuthorSet);
                    }
                }
            }

        } catch (Exception exception) {
            System.out.println(exception.getStackTrace());
        }
    }
}
