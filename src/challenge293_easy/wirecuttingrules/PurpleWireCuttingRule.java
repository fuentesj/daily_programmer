package challenge293_easy.wirecuttingrules;

import challenge293_easy.WireColor;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Jonathan on 6/16/17.
 */
public class PurpleWireCuttingRule extends WireCuttingRule {

    public PurpleWireCuttingRule() {
        this.setCurrentColor(WireColor.PURPLE);
        this.setAllowedWireColors(new HashSet<>(Arrays.asList(WireColor.BLACK, WireColor.RED)));
        this.setDisallowedColors(new HashSet<>(Arrays.asList(WireColor.PURPLE, WireColor.ORANGE, WireColor.GREEN, WireColor.WHITE)));
    }
}
