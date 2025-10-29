import java.util.*;

public class Racetrack {
    public static final int trackSize = 20;
    public static final int squareWidth = 25;

    public static void main(String[] args) {
        int velX = 0;
        int velY = 0;
        int posX = 10;
        int posY = 17;
        int pPosX = posX;
        int pPosY = posY;

        StdDraw.setCanvasSize(400, 400);
        StdDraw.setXscale(1,400);
        StdDraw.setYscale(1,400);

        StdDraw.show(20);
        drawMap();
        StdDraw.show();

        StdDraw.setPenRadius(0.016);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.point(posX * 20, posY * 20);

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                switch(StdDraw.nextKeyTyped()) {
                    case '1':
                        velX -= 1;
                        velY -= 1;
                        break;
                    case '2':
                        velY -= 1;
                        break;
                    case '3':
                        velX += 1;
                        velY -=1;
                        break;
                    case '4':
                        velX -= 1;
                        break;
                    case '5':
                        break;
                    case '6':
                        velX += 1;
                        break;
                    case '7':
                        velX -= 1;
                        velY += 1;
                        break;
                    case '8':
                        velY += 1;
                        break;
                    case '9':
                        velX += 1;
                        velY += 1;
                        break;
                    default:
                        break;
                }

                pPosX = posX;
                pPosY = posY;
                posX += velX;
                posY += velY;

                StdDraw.setPenRadius(0.008);
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.line(pPosX * 20, pPosY * 20, posX * 20, posY * 20);
                StdDraw.setPenRadius(0.016);
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.point(posX * 20, posY * 20);
                System.out.println(posX);
                System.out.println(posY);

            }
        }
    }

    public static void drawMap() {
        StdDraw.setPenRadius(0.002);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        for (int i = 0; i < trackSize; i++) {
            for (int j = 0; j < trackSize; j++) {
                if (i < 5 || i > 14 || j < 5 || j > 14) {
                    StdDraw.filledSquare(i*20 + 10.5, j*20 + 9.5, 10);
                }
            }
        }

        StdDraw.setPenRadius(0.002);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < trackSize; i++) {
            for (int j = 0; j < trackSize; j++) {
                if (i < 5 || i > 14 || j < 5 || j > 14) {
                    StdDraw.square(i*20 + 10.5, j*20 + 9.5, 10);
                }
            }
        }
        
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.setPenRadius(0.008);
        StdDraw.line(200, 400, 200, 300);

        StdDraw.setPenRadius(0.004);
        StdDraw.setPenColor(StdDraw.BLACK);
        drawSymSquare(200);

        StdDraw.setPenRadius(0.004);
        StdDraw.setPenColor(StdDraw.BLACK);
        drawSymSquare(100);
    }

    public static void drawSymSquare(int r) {
        int a, b;
        a = 200 - r;
        b = 200 + r;
        StdDraw.line(a, a, a, b);
        StdDraw.line(a, b, b, b);
        StdDraw.line(b, b, b, a);
        StdDraw.line(b, a, a, a);
    }
}
