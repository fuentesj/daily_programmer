package challenge293_easy.wirecuttingrules;

import challenge293_easy.WireColor;

import java.util.Set;

/**
 * Created by Jonathan on 6/15/17.
 */
public abstract class WireCuttingRule {
    private WireColor currentColor;
    private Set<WireColor> allowedWireColors;
    private Set<WireColor> disallowedColors;

    public WireColor getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(WireColor currentColor) {
        this.currentColor = currentColor;
    }

    public Set<WireColor> getAllowedWireColors() {
        return allowedWireColors;
    }

    public void setAllowedWireColors(Set<WireColor> allowedWireColors) {
        this.allowedWireColors = allowedWireColors;
    }

    public Set<WireColor> getDisallowedColors() {
        return disallowedColors;
    }

    public void setDisallowedColors(Set<WireColor> disallowedColors) {
        this.disallowedColors = disallowedColors;
    }
}
