package challenge293_easy.wirecuttingrules;

import challenge293_easy.WireColor;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Jonathan on 6/16/17.
 */
public class GreenWireCuttingRule extends WireCuttingRule {

    public GreenWireCuttingRule() {
        this.setCurrentColor(WireColor.GREEN);
        this.setAllowedWireColors(new HashSet<>(Arrays.asList(WireColor.ORANGE, WireColor.WHITE)));
        this.setDisallowedColors(new HashSet<>(Arrays.asList(WireColor.BLACK, WireColor.PURPLE, WireColor.GREEN, WireColor.RED)));
    }
}
