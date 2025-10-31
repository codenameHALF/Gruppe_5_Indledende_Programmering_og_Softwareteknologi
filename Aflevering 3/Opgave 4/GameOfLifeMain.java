import java.io.*;
import java.util.*;


public class GameOfLifeMain {
    public static String golPath = "Aflevering 3/Opgave 4/gol/acorn.gol";
    public static GameOfLife gameOfLife;
    
    public static void main(String[] args) {
        ArrayList<String> golData = new ArrayList<>();
        try {
            // Read data from file path
            Scanner scanner = new Scanner(new File(golPath));
            while (scanner.hasNextLine()) {golData.add(scanner.nextLine().replaceAll(" ", ""));}
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found, terminating...");
            System.exit(0);
        }

        gameOfLife = new GameOfLife(golData);
        System.out.println(gameOfLife.getState());

        StdDraw.setXscale(0, gameOfLife.xSize);
        StdDraw.setYscale(0, gameOfLife.ySize);
        updateWindow();
        while(true) {
            try {
                gameOfLife.nextGen();
                updateWindow();
            } catch (Exception e) {
                System.out.println(e);
                System.exit(0);
            }
        }
    }


    public static void updateWindow() {
        StdDraw.show(0);
        StdDraw.clear();
        drawState();
        StdDraw.show();
    }

    public static void drawState() {
        //StdDraw.setPenRadius(1.0/Math.min(gameOfLife.xSize, gameOfLife.ySize));
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < gameOfLife.xSize; i++) {
            for (int j = 0; j < gameOfLife.ySize; j++) {
                if (gameOfLife.state[i][j] == 1) {
                    //StdDraw.point(j+0.5, gameOfLife.ySize-i-1.5);
                    StdDraw.filledSquare(j+0.5, gameOfLife.ySize-i-0.5, 0.51);
                }
            }
        }
    }

    public static void printState() {
        for (int i = 0; i < gameOfLife.xSize; i++) {
            String line = "";
            for (int j = 0; j < gameOfLife.ySize; j++) {
                if (gameOfLife.state[i][j] == 1) {
                    line += "1";
                } else {
                    line += "0";
                }
            }
            System.out.println(line);
        }
    }


}
