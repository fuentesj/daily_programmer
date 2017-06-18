package challenge275_easy;

/**
 * Created by Jonathan on 8/31/16.
 */
public class Solution {


    public static void main(String[] args) {

        System.out.println(isSymbolValid("Spenglerium", "Ee"));
        System.out.println(isSymbolValid("Zeddemorium", "Zr"));
        System.out.println(isSymbolValid("Venkmine", "Kn"));
        System.out.println(isSymbolValid("Stantzon", "Zt"));
        System.out.println(isSymbolValid("Melintzum", "Nn"));
        System.out.println(isSymbolValid("Tullium", "Ty"));

        /*
            Spenglerium, Ee -> true
            Zeddemorium, Zr -> true
            Venkmine, Kn -> true
            Stantzon, Zt -> false
            Melintzum, Nn -> false
            Tullium, Ty -> false
         */
    }

    private static boolean isSymbolValid(String elementName, String proposedSymbol) {
        if (proposedSymbol.length() != 2) {
            return false;
        } else if (!elementName.matches("[A-Za-z]+") || !proposedSymbol.matches("[A-Za-z]{2}")) {
            return false;
        } else if (!areSymbolLettersPresentInElementName(elementName, proposedSymbol) ||
                        !areSymbolLettersInValidOrder(elementName, proposedSymbol)) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean areSymbolLettersPresentInElementName(String elementName, String proposedSymbol) {
        String[] proposedSymbolArray = proposedSymbol.toLowerCase().split("");
        for (String character : proposedSymbolArray) {
            if (elementName.toLowerCase().indexOf(character) < 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean areSymbolLettersInValidOrder(String elementName, String proposedSymbol) {
        String[] proposedSymbolArray = proposedSymbol.toLowerCase().split("");
        int firstIndex = elementName.toLowerCase().indexOf(proposedSymbolArray[0]);
        int secondIndex = elementName.toLowerCase().indexOf(proposedSymbolArray[1]);
        return firstIndex < secondIndex;
    }
}
