import java.util.*;
import java.awt.*;

public class Window {
    public Window(int xScale, int yScale) {
        StdDraw.setXscale(1,xScale);
        StdDraw.setYscale(1,yScale);
    }


    public void updateStartScene(StartSceneState startSceneState) {
        StdDraw.show(20);
        StdDraw.clear();
        StdDraw.text(200, 210, "Vector Racing");
        StdDraw.text(200, 190, "Press enter to start!");
        StdDraw.textLeft(50, 90, "Change settings with arrow keys");
        String playerNumDescription = "Players:";
        String playerNumValue = Integer.toString(startSceneState.getSelectedPlayerNum());
        if (startSceneState.selectedOption == 0) {playerNumValue = "<" + playerNumValue + ">";}
        StdDraw.textLeft(50, 70, playerNumDescription + playerNumValue);
        String mapDescription = "Map:";
        String mapValue = startSceneState.getSelectedMap();
        if (startSceneState.selectedOption == 1) {mapValue = "<" + mapValue + ">";}
        StdDraw.textLeft(50, 50, mapDescription + mapValue);
        StdDraw.show();
    }


    public void updateRaceScene(RaceSceneState raceSceneState) {
        StdDraw.show(20);
        StdDraw.clear();
        drawBackground();

        for(int i = 0; i < raceSceneState.getPlayersNum(); i++) {
            ArrayList<Point> route = raceSceneState.getPlayerRoute(i);
            Color color = raceSceneState.getPlayerColor(i);
            for (int j = 0; j < route.size()-1; j++) {
                drawLine(route.get(j), route.get(j+1), color);
            }
        }
        for(int i = 0; i < raceSceneState.getPlayersNum(); i++) {
            ArrayList<Point> route = raceSceneState.getPlayerRoute(i);
            for (Point pos : route) {
                drawPoint(pos);
            }
        }   

        StdDraw.show();
    }


    public void updateGameoverScene() {
        StdDraw.show(20);
        StdDraw.clear();
        StdDraw.text(200, 210, "Game Finished");
        StdDraw.text(200, 190, "Press q to quit");
        StdDraw.show();
    }


    public void drawPoint(Point p) {
        StdDraw.setPenRadius(0.016);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.point(p.x * 20, p.y * 20);
    }

    
    public void drawLine(Point pos1, Point pos2, Color color) {
        StdDraw.setPenRadius(0.008);
        StdDraw.setPenColor(color);
        StdDraw.line(pos1.x * 20, pos1.y * 20, pos2.x * 20, pos2.y * 20);
    }


    public void drawBackground() {
        StdDraw.setPenRadius(0.002);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (i < 5 || i > 14 || j < 5 || j > 14) {
                    StdDraw.filledSquare(i*20 + 10.5, j*20 + 9.5, 10);
                }
            }
        }

        StdDraw.setPenRadius(0.002);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
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


    public void drawSymSquare(int r) {
        int a, b;
        a = 200 - r;
        b = 200 + r;
        StdDraw.line(a, a, a, b);
        StdDraw.line(a, b, b, b);
        StdDraw.line(b, b, b, a);
        StdDraw.line(b, a, a, a);
    }
}
