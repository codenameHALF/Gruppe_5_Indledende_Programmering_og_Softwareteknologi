import java.awt.*;
import java.util.*;

// Class for storing and updating the state of the racing scene
public class RaceSceneState {
    private Player[] players;
    Color[] playerColors = {StdDraw.RED, StdDraw.GREEN, StdDraw.BLUE, StdDraw.YELLOW};
    GameMap gameMap;
    
    // Initialize variables
    public RaceSceneState(int playersNum, GameMap gameMap) {
        this.gameMap = gameMap;
        // Add playersNum amount of players
        this.players = new Player[playersNum];
        for (int i = 0; i < playersNum; i++) {
            this.players[i] = new Player(new Point(10, 16 + i), i, playerColors[i]);
        }
    }

    // Update position of specific player
    public void movePlayer(int playerID, Point dir) {
        this.players[playerID].move(dir);
    }

    // Getter for playersNum
    public int getPlayersNum() {
        return players.length;
    }

    // Getter for route of specific player
    public ArrayList<Point> getPlayerRoute(int playerID) {
        return players[playerID].getRoute();
    }

    // Getter for color of specific player
    public Color getPlayerColor(int playerID) {
        return players[playerID].getColor();
    }

    // Check if game is over (not implemented)
    public boolean isGameover() {
        return false;
    }
}
