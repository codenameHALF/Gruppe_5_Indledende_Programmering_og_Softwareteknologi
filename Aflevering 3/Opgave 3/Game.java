import java.awt.*;
import java.awt.event.*;

// Class for running a game of vector racing
public class Game {
    // The different selectable maps
    public static final GameMap[] gameMaps = {
        new GameMap(20, 20, 10, 10, StdDraw.LIGHT_GRAY, StdDraw.GRAY),
        new GameMap(18, 20, 4, 10, StdDraw.BOOK_LIGHT_BLUE, StdDraw.BLUE),
        new GameMap(18, 20, 12, 10, StdDraw.BOOK_RED, StdDraw.DARK_GRAY),
        new GameMap(18, 20, 14, 10, StdDraw.PINK, StdDraw.MAGENTA)
    };
    // List of directions to be indexed by the key typed
    public static final Point[] directions = {
        new Point(-1, -1),  new Point(0, -1),  new Point(1, -1),
        new Point(-1, 0), new Point(0, 0), new Point(1, 0),
        new Point(-1, 1), new Point(0, 1), new Point(1, 1),
    };
    public Window window;
    public enum Scene {START,RACE,GAMEOVER};
    public StartSceneState startSceneState;
    public RaceSceneState raceSceneState;


    public Game() {
        // Set up window and initialize current scene state
        window = new Window(400, 400);
        Scene currentScene = Scene.START;

        // Outermost loop responsible for overall scene switching
        
        // Scene switch is assumed when a scene method returns

        // Every iteration should do the following:
        // Initialize scene state object
        // Run scene loop until scene switch
        // Switch scene state
        while (true) {
            switch(currentScene) {
                case Scene.START:
                    startSceneState = new StartSceneState();
                    startScene();
                    currentScene = Scene.RACE;
                    break;
                case Scene.RACE:
                    raceSceneState = new RaceSceneState(startSceneState.getSelectedPlayerNum(), gameMaps[startSceneState.getSelectedMap()]);
                    raceScene();
                    currentScene = Scene.GAMEOVER;
                    break;
                case Scene.GAMEOVER:
                    gameoverScene();
                    System.exit(0);
            }
        }
    }

    // Start scene game loop
    public void startScene() {
        // Scene setup
        int waitFor = 0;
        window.updateStartScene(startSceneState); 
        // Update UI when selected keys are pressed
        while(true) {
            if (StdDraw.isKeyPressed(KeyEvent.VK_UP))    {startSceneState.up();    window.updateStartScene(startSceneState); waitFor = KeyEvent.VK_UP;}
            if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN))  {startSceneState.down();  window.updateStartScene(startSceneState); waitFor = KeyEvent.VK_DOWN;}
            if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT))  {startSceneState.left();  window.updateStartScene(startSceneState); waitFor = KeyEvent.VK_LEFT;}
            if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {startSceneState.right(); window.updateStartScene(startSceneState); waitFor = KeyEvent.VK_RIGHT;}
            if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)) {
                while(StdDraw.isKeyPressed(KeyEvent.VK_ENTER)){} 
                while(StdDraw.hasNextKeyTyped()) {StdDraw.nextKeyTyped();}
                return;}
            while(waitFor != 0) {
                if (!StdDraw.isKeyPressed(waitFor)) {
                    waitFor = 0;
                }
            }
        }
    }

    // Race scene game loop
    public void raceScene() {
        // Scene setup
        int currPlayer = 0;
        window.updateRaceScene(raceSceneState);
        // Let each player take turns to press a key
        // Update the game state according to the move
        // Update the window according to the game state
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();

                if ("123456789".indexOf(key) != -1) {
                    raceSceneState.movePlayer(currPlayer, directions[(int) key - '1']);
                } else {
                    raceSceneState.movePlayer(currPlayer, directions[5]);
                }

                currPlayer += 1;
                if (currPlayer == raceSceneState.getPlayersNum()) {currPlayer = 0;}
                if (raceSceneState.isGameover()) {return;}
                window.updateRaceScene(raceSceneState);
            }
        }
    }

    // Gameover scene game loop (not used)
    public void gameoverScene() {
        // Scene setup
        window.updateGameoverScene();
        // Wait until the user presses q, then return and end game
        while(true) {
            if (StdDraw.hasNextKeyTyped()) {
                if (StdDraw.nextKeyTyped() == 'q') {
                    return;
                }
            }
        }
    }
}
