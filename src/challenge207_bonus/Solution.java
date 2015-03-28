package challenge207_bonus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Created by jon on 3/26/15.
 */
public class Solution {


    public static void main(String[] args) {
        Map<String, Set<String>> authorGraph = new HashMap<>();

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


            for (int currentAuthorNum = 0; currentAuthorNum < numOfAuthors; currentAuthorNum++) {
                String currentAuthor = bufferedReader.readLine();
                authorGraph.put(currentAuthor, new HashSet<>());
            }

            for (String author : authorGraph.keySet()) {
                for (Set<String> authorSet : authorSetList) {
                    if (authorSet.contains(author)) {
                        Set<String> existingAuthorSet = authorGraph.get(author);
                        Set<String> newAuthors = new HashSet<>(authorSet);
                        newAuthors.remove(author);
                        existingAuthorSet.addAll(newAuthors);
                        authorGraph.put(author, existingAuthorSet);
                    }
                }
            }
            
            Set<String> visitedAuthors = new HashSet<>();
            for (String author : authorGraph.keySet()){
                Integer currentErdosNumber = findErdos(author, authorGraph, 0, visitedAuthors);
                System.out.println(author + " : " + currentErdosNumber);
                visitedAuthors.clear();
            }

        } catch (Exception exception) {
            System.out.println(exception.getStackTrace());
        }
    }


    private static int findErdos(String currentAuth, Map<String, Set<String>> authorMap, Integer runningErdosNum, Set<String> visitedAuthors) {
        if (visitedAuthors.contains(currentAuth)) {
            return runningErdosNum;
        } else {
            if (authorMap.get(currentAuth) == null) {
                return runningErdosNum;
            } else if (authorMap.get(currentAuth).contains("Erdös, P.")) {
                runningErdosNum += 1;
                return runningErdosNum;
            } else {
                visitedAuthors.add(currentAuth);
                Integer currentErdosNum = 100;
                for (String associatedAuthor : authorMap.get(currentAuth)) {
                    currentErdosNum = findErdos(associatedAuthor, authorMap, 1, visitedAuthors);
                    if (currentErdosNum < runningErdosNum) {
                        runningErdosNum = currentErdosNum;
                    }
                    visitedAuthors.add(associatedAuthor);
                }
                return runningErdosNum;
            }
        }
    }


}
