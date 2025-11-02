import java.io.*;
import java.util.*;


public class GameOfLifeMain {
    public static String golPath = "Aflevering 3/Opgave 4/gol/acorn.gol";
    public static GameOfLife gameOfLife;
    

    public static void main(String[] args) {
        // Read data from .gol file specified by golPath
        // Store data in golData array
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
        StdDraw.setXscale(0, gameOfLife.getXSize());
        StdDraw.setYscale(0, gameOfLife.getYSize());
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

    // Draw the current state by drawing black squares where state[i][j] = 1
    public static void drawState() {
        StdDraw.setPenColor(StdDraw.BLACK);

        for (int i = 0; i < gameOfLife.getXSize(); i++) {
            for (int j = 0; j < gameOfLife.getYSize(); j++) {
                if (gameOfLife.getState()[i][j] == 1) {
                    StdDraw.filledSquare(j+0.5, gameOfLife.getYSize()-i-0.5, 0.51);
                }
            }
        }
    }

    // Print the current state in the terminal
    public static void printState() {
        for (int i = 0; i < gameOfLife.getXSize(); i++) {
            String line = "";
            for (int j = 0; j < gameOfLife.getYSize(); j++) {
                if (gameOfLife.getState()[i][j] == 1) {
                    line += "1";
                } else {
                    line += "0";
                }
            }
            System.out.println(line);
        }
    }


}
