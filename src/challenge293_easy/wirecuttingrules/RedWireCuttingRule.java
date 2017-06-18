package challenge293_easy.wirecuttingrules;

import challenge293_easy.WireColor;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Jonathan on 6/16/17.
 */
public class RedWireCuttingRule extends WireCuttingRule {

    public RedWireCuttingRule() {
        this.setCurrentColor(WireColor.RED);
        this.setAllowedWireColors(new HashSet<>(Arrays.asList(WireColor.GREEN)));
        this.setDisallowedColors(new HashSet<>(Arrays.asList(WireColor.BLACK, WireColor.RED, WireColor.ORANGE,
                                                            WireColor.PURPLE, WireColor.WHITE)));
    }
}
