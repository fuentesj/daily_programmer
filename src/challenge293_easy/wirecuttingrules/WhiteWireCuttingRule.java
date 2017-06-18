package challenge293_easy.wirecuttingrules;

import challenge293_easy.WireColor;

import java.util.*;

/**
 * Created by Jonathan on 6/15/17.
 */
public class WhiteWireCuttingRule extends WireCuttingRule {

    public WhiteWireCuttingRule() {
        this.setCurrentColor(WireColor.WHITE);
        this.setAllowedWireColors(new HashSet<>(Arrays.asList(WireColor.PURPLE, WireColor.RED, WireColor.GREEN,
                                                                        WireColor.ORANGE)));
        this.setDisallowedColors(new HashSet<>(Arrays.asList(WireColor.WHITE, WireColor.BLACK)));
    }
}
