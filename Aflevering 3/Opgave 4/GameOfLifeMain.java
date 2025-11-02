import java.io.*;
import java.util.*;


public class GameOfLifeMain {
    public static String golPath = "Aflevering 3/Opgave 4/gol/glider_gun.gol";
    public static GameOfLife gameOfLife;
    

    public static void main(String[] args) {
        // Read data from .gol file specified by golPath
        ArrayList<String> golData = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(golPath));
            while (scanner.hasNextLine()) {golData.add(scanner.nextLine().replaceAll(" ", ""));}
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found, terminating...");
            System.exit(0);
        }

        // Add a new gameOfLife object and insert the .gol data
        gameOfLife = new GameOfLife(golData);
        System.out.println(gameOfLife.getState());

        // Setup StdDraw window
        StdDraw.setXscale(0, gameOfLife.xSize);
        StdDraw.setYscale(0, gameOfLife.ySize);
        updateWindow();
        
        // Main infinite loop for the simulation
        while(true) {
            gameOfLife.nextGen();
            updateWindow();
        }
    }

    // Clear the screen and display the game state
    public static void updateWindow() {
        StdDraw.show(10);
        StdDraw.clear();
        drawState();
        StdDraw.show();
    }

    // Display the game state
    public static void drawState() {
        StdDraw.setPenColor(StdDraw.BLACK);

        // Go though
        for (int i = 0; i < gameOfLife.xSize; i++) {
            for (int j = 0; j < gameOfLife.ySize; j++) {
                if (gameOfLife.state[i][j] == 1) {
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
