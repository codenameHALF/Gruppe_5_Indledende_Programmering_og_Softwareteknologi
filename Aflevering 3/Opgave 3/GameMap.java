import java.awt.*;

public class GameMap {
    private Point[] outerCornerPoints = new Point[4];
    private Point[] innerCornerPoints = new Point[4];

    public GameMap(int outWidth, int outHeight, int inWidth, int inHeight) {
        this.outerCornerPoints[0] = new Point(    (400-outWidth)/2,     (400-outHeight)/2);
        this.outerCornerPoints[1] = new Point(    (400-outWidth)/2, 400-(400-outHeight)/2);
        this.outerCornerPoints[2] = new Point(400-(400-outWidth)/2,     (400-outHeight)/2);
        this.outerCornerPoints[3] = new Point(400-(400-outWidth)/2, 400-(400-outHeight)/2);
        this.innerCornerPoints[0] = new Point(    (400-inWidth)/2,      (400-inHeight)/2);
        this.innerCornerPoints[1] = new Point(    (400-inWidth)/2,  400-(400-inHeight)/2);
        this.innerCornerPoints[2] = new Point(400-(400-inWidth)/2,      (400-inHeight)/2);
        this.innerCornerPoints[3] = new Point(400-(400-inWidth)/2,  400-(400-inHeight)/2);
    }
}
