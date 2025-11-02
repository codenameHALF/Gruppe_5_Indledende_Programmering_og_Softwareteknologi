import java.awt.*;

// Class for storing map data
public class GameMap {
    public int outWidth;
    public int outHeight;
    public int inWidth;
    public int inHeight;
    public Color tileColor;
    public Color edgeColor;

    // Initialize variables
    public GameMap(int outWidth, int outHeight, int inWidth, int inHeight, Color tileColor, Color edgeColor) {
        this.outWidth = outWidth;
        this.outHeight = outHeight;
        this.inWidth = inWidth;
        this.inHeight = inHeight;
        this.tileColor = tileColor;
        this.edgeColor = edgeColor;
    }
}
