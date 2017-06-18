package challenge298_easy;

/**
 * Created by Jonathan on 1/6/17.
 */
public class Solution {

    public static void main(String[] args) {

        String inputString = "(((123)456)789)";
        while (containsOuterMatchingParentheses(inputString)) {
            String substring = inputString.substring(1, inputString.length() - 1);
            if (containsOuterMatchingParentheses(substring)) {
                inputString = substring;
            }
        }

        System.out.println(containsMatchingParentheses(inputString));
    }

    private static boolean containsOuterMatchingParentheses(String inputString) {
        char firstChar = inputString.charAt(0);
        char lastChar = inputString.charAt(inputString.length()-1);

        return (firstChar == '(' && lastChar == ')');
    }

    private static boolean containsMatchingParentheses(String inputString) {
        if (inputString.length() > 0) {
            int numberOfOpeningParentheses = 0;
            int numberOfClosingParentheses = 0;

            for (int index = 0; index < inputString.length(); index++) {
                char currentChar = inputString.charAt(index);
                if (currentChar == '(') {
                    numberOfOpeningParentheses++;
                }
                if (currentChar == ')') {
                    numberOfClosingParentheses++;
                }
            }

            if (numberOfOpeningParentheses == 0 && numberOfClosingParentheses == 0) {
                return false;
            } else {
                return (numberOfOpeningParentheses == numberOfClosingParentheses);

            }
        } else {
            return false;
        }
    }
}
