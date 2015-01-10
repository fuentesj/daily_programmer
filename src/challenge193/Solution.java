package challenge193;

import java.util.*;

/**
 * Created by Jonathan on 1/10/15.
 */
public class Solution {

    public static void main(String[] args) {

        Map<String, String> acronymMap = new HashMap<String, String>();
        acronymMap.put("lol", "laugh out loud");
        acronymMap.put("dw", "don't worry");
        acronymMap.put("hf", "have fun");
        acronymMap.put("gg", "good game");
        acronymMap.put("brb", "be right back");
        acronymMap.put("g2g", "got to go");
        acronymMap.put("wtf", "what the fuck");
        acronymMap.put("wp", "well played");
        acronymMap.put("gl", "good luck");
        acronymMap.put("imo", "in my opinion");

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] tokenArray = userInput.split(" ");
        List<String> tokenList = new ArrayList<String>(Arrays.asList(tokenArray));
        StringBuilder outputBuilder = new StringBuilder();
        for (String token : tokenList) {
            String processedToken = token.replaceAll("[.!?\\-]", "");
            if (acronymMap.containsKey(processedToken)) {
                outputBuilder.append(acronymMap.get(processedToken) + " ");
            } else {
                outputBuilder.append(token + " ");
            }
        }

        System.out.println(outputBuilder.toString());
    }
}


