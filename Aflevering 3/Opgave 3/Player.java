import java.util.*;
import java.awt.*;

public class Player {
    private int playerID;
    private Point vel = new Point(0, 0);
    private Point pos;
    private ArrayList<Point> route = new ArrayList<>();
    private Color color;


    public Player(int posX, int posY, int playerID, Color color) {
        this.playerID = playerID;
        this.pos = new Point(posX, posY);
        this.route.add(new Point(pos));
        this.color = color;
    }


    public void move(Point dir) {
        this.vel.x += dir.x;
        this.vel.y += dir.y;
        this.pos.x += this.vel.x;
        this.pos.y += this.vel.y;
        this.route.add(new Point(pos));
    }


    public Point getPos() {
        return this.pos;
    }


    public ArrayList<Point> getRoute() {
        return this.route;
    }


    public int getPlayerID() {
        return playerID;
    }
    

    public Color getColor() {
        return color;
    }
}
