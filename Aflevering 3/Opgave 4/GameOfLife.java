import java.util.*;
public class GameOfLife {
    int n;
    int[][] state;

    public GameOfLife(String golData) {
        // Læs fra data og find ud af dimensionerne
        // Skriv data til state
        this.n = golToN(golData);
        this.state = golToState(golData);
    }

    public int golToN(String golData) {
        return 10; // Default size 10x10
    }

    public int[][] golToState(String golData) {
        state = new int[n][n];
        // Initialize with random cells
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                state[i][j] = Math.random() < 0.5 ? 0 : 1;
            }
        }
        return state;
    }

    public int[][] getState() {
        return this.state;
    }

    public void nextGen() {
        // Simple implementation that just clears the board
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                state[i][j] = 0;
            }
        }
    }
}
