import java.util.*;
import java.awt.*;

// Class for storing and updating player data
public class Player {
    private int playerID;
    private Point vel = new Point(0, 0);
    private Point pos;
    private ArrayList<Point> route = new ArrayList<>();
    private Color color;

    // Initialize variables
    public Player(Point pos, int playerID, Color color) {
        this.playerID = playerID;
        this.pos = pos;
        this.route.add(new Point(pos));
        this.color = color;
    }

    // Update position and velocity according to input direction
    // Finally add position to total route
    public void move(Point dir) {
        this.vel.x += dir.x;
        this.vel.y += dir.y;
        this.pos.x += this.vel.x;
        this.pos.y += this.vel.y;
        this.route.add(new Point(pos));
    }

    // Getter for pos
    public Point getPos() {
        return this.pos;
    }

    // Getter for route
    public ArrayList<Point> getRoute() {
        return this.route;
    }

    // Getter for playerID
    public int getPlayerID() {
        return playerID;
    }
    
    // Getter for color
    public Color getColor() {
        return color;
    }
}
