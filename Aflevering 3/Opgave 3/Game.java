import java.awt.*;
import java.awt.event.*;

public class Game {
    public static final int playersNum = 4;
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
        window = new Window(400, 400);
        Scene currentScene = Scene.START;

        while (true) {
            switch(currentScene) {
                case Scene.START:
                    startSceneState = new StartSceneState();
                    startScene();
                    currentScene = Scene.RACE;
                    break;
                case Scene.RACE:
                    raceSceneState = new RaceSceneState(startSceneState.getSelectedPlayerNum());
                    raceScene();
                    currentScene = Scene.GAMEOVER;
                    break;
                case Scene.GAMEOVER:
                    gameoverScene();
                    System.exit(0);
            }
        }
    }


    public void startScene() {
        int waitFor = 0;
        while(true) {
            if (StdDraw.isKeyPressed(KeyEvent.VK_UP))    {startSceneState.up();    waitFor = KeyEvent.VK_UP;}
            if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN))  {startSceneState.down();  waitFor = KeyEvent.VK_DOWN;}
            if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT))  {startSceneState.left();  waitFor = KeyEvent.VK_LEFT;}
            if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {startSceneState.right(); waitFor = KeyEvent.VK_RIGHT;}
            if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)) {
                while(StdDraw.isKeyPressed(KeyEvent.VK_ENTER)){} 
                while(StdDraw.hasNextKeyTyped()) {StdDraw.nextKeyTyped();}
                return;}
            window.updateStartScene(startSceneState);
            while(waitFor != 0) {
                if (!StdDraw.isKeyPressed(waitFor)) {
                    waitFor = 0;
                }
            }
        }
    }


    public void raceScene() {
        int currPlayer = 0;
        while (true) {
            window.updateRaceScene(raceSceneState);

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
            }
        }
    }


    public void gameoverScene() {
        window.updateGameoverScene();
        while(true) {
            if (StdDraw.hasNextKeyTyped()) {
                if (StdDraw.nextKeyTyped() == 'q') {
                    return;
                }
            }
        }
    }
}
