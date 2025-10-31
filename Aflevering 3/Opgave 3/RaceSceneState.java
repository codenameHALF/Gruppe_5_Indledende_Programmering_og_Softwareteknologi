import java.awt.*;
import java.util.*;

public class RaceSceneState {
    private Player[] players;
    Color[] playerColors = {StdDraw.RED, StdDraw.GREEN, StdDraw.BLUE, StdDraw.YELLOW};
    GameMap gameMap;
    

    public RaceSceneState(int playersNum, GameMap gameMap) {
        this.gameMap = gameMap;
        this.players = new Player[playersNum];
        for (int i = 0; i < playersNum; i++) {
            this.players[i] = new Player(10, 16 + i, i, playerColors[i]);
        }
    }


    public void movePlayer(int playerID, Point dir) {
        this.players[playerID].move(dir);
    }


    public int getPlayersNum() {
        return players.length;
    }


    public ArrayList<Point> getPlayerRoute(int playerID) {
        return players[playerID].getRoute();
    }


    public Color getPlayerColor(int playerID) {
        return players[playerID].getColor();
    }


    public boolean isGameover() {
        return false;
    }
}
