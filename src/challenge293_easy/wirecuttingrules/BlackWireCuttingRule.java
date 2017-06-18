package challenge293_easy.wirecuttingrules;

import challenge293_easy.WireColor;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Jonathan on 6/16/17.
 */
public class BlackWireCuttingRule extends WireCuttingRule {

    public BlackWireCuttingRule() {
        this.setCurrentColor(WireColor.BLACK);
        this.setAllowedWireColors(new HashSet<>(Arrays.asList(WireColor.PURPLE, WireColor.RED, WireColor.BLACK)));
        this.setDisallowedColors(new HashSet<>(Arrays.asList(WireColor.WHITE, WireColor.GREEN, WireColor.ORANGE)));
    }
}
