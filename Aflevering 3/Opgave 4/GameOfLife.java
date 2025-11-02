import java.util.ArrayList;

public class GameOfLife {
    private int xSize, ySize;
    private int[][] state;

    // Setup state dimensions and update the state
    public GameOfLife(ArrayList<String> golData) {
        this.xSize = golData.get(0).length();
        this.ySize = golData.size();
        this.state = golToState(golData);
    }

    // Convert list of strings from gol file to status format
    public int[][] golToState(ArrayList<String> golData) {
        int[][] newState = new int[this.xSize][this.ySize];
        for (int i = 0; i < this.xSize; i++) {
            for (int j = 0; j < this.ySize; j++) {
                if (golData.get(i).charAt(j) == '0') {
                    newState[i][j] = 0;
                } else if (golData.get(i).charAt(j) == '1') {
                    newState[i][j] = 1;
                }
            }
        }
        return newState;
    }

    // Getter for state
    public int[][] getState() {
        return this.state;
    }

    // Getter for xSize
    public int getXSize() {
        return this.xSize;
    }

    // Getter for ySize
    public int getYSize() {
        return this.ySize;
    }

    // Apply game of life rules to all cells and update the state
    public void nextGen() {
        int[][] newState = new int[this.xSize][this.ySize];
        for (int i = 0; i < this.xSize; i++) {
            for (int j = 0; j < this.ySize; j++) {
                int cellState = this.state[i][j];
                int neighbors = 0;
                // Get the sum of neighbors to the current cell
                // If statements prevent index out of bounds
                // 0 is assumed outside the state dimensions
                if (i > 0      ) {neighbors += state[i-1][j];}
                if (i < xSize-1) {neighbors += state[i+1][j];}
                if (j > 0      ) {neighbors += state[i][j-1];}
                if (j < ySize-1) {neighbors += state[i][j+1];}
                if (i > 0       && j > 0      ) {neighbors += state[i-1][j-1];}
                if (i < xSize-1 && j > 0      ) {neighbors += state[i+1][j-1];}
                if (i > 0       && j < ySize-1) {neighbors += state[i-1][j+1];}
                if (i < xSize-1 && j < ySize-1) {neighbors += state[i+1][j+1];}

                // Apply game of life rules to cell
                if (cellState == 1 && neighbors < 2 ) {newState[i][j] = 0;}
                if (cellState == 1 && neighbors > 3 ) {newState[i][j] = 0;}
                if (cellState == 1 && neighbors >= 2 && neighbors <= 3 ) {newState[i][j] = this.state[i][j];}
                if (cellState == 0 && neighbors == 3) {newState[i][j] = 1;}
            }
        }
    this.state = newState;
    }
}
