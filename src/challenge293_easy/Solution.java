package challenge293_easy;

import challenge293_easy.wirecuttingrules.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Jonathan on 6/15/17.
 */
public class Solution {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input-files/challenge293/input.txt"))) {
            List<WireCuttingRule> wireCuttingRuleList = buildUpWireColorList(bufferedReader);
            boolean bombExplodes = false;
            ListIterator<WireCuttingRule> iterator = wireCuttingRuleList.listIterator();
            WireCuttingRule currentWireCuttingRule = iterator.next();
            while (iterator.hasNext()) {
                WireCuttingRule nextWireCuttingRule = iterator.next();
                if (currentWireCuttingRule.getDisallowedColors().contains(nextWireCuttingRule.getCurrentColor())) {
                    bombExplodes = true;
                    break;
                }
                currentWireCuttingRule = nextWireCuttingRule;
            }
            if (bombExplodes == true) {
                System.out.println("The bomb exploded.");
            } else {
                System.out.println("The bomb was defused.");
            }
        } catch (IOException exception) {

        } catch (UnknownWireColorException exception) {
            System.out.println("Unknown wire color in instructions.");
        }
    }

    private static List<WireCuttingRule> buildUpWireColorList(BufferedReader bufferedReader) throws IOException {
        List<WireCuttingRule> wireCuttingRuleList = new ArrayList<>();
        String nextLine;
        while ((nextLine = bufferedReader.readLine()) != null ) {
            if ("white".equals(nextLine)) {
                wireCuttingRuleList.add(new WhiteWireCuttingRule());
            } else if ("black".equals(nextLine)) {
                wireCuttingRuleList.add(new BlackWireCuttingRule());
            } else if ("purple".equals(nextLine)) {
                wireCuttingRuleList.add(new PurpleWireCuttingRule());
            } else if ("red".equals(nextLine)) {
                wireCuttingRuleList.add(new RedWireCuttingRule());
            } else if ("green".equals(nextLine)) {
                wireCuttingRuleList.add(new GreenWireCuttingRule());
            } else if ("orange".equals(nextLine)) {
                wireCuttingRuleList.add(new OrangeWireCuttingRule());
            } else {
                throw new UnknownWireColorException();
            }
        }
        return wireCuttingRuleList;
    }
}
