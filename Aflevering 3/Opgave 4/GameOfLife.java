import java.util.ArrayList;

public class GameOfLife {
    int xSize, ySize;
    int[][] state;

    public GameOfLife(ArrayList<String> golData) {
        this.xSize = golData.get(0).length();
        this.ySize = golData.size();
        this.state = golToState(golData);
    }

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

    public int[][] getState() {
        return this.state;
    }

    public void nextGen() {
        int[][] newState = new int[this.xSize][this.ySize];
        for (int i = 0; i < this.xSize; i++) {
            for (int j = 0; j < this.ySize; j++) {
                int cellState = this.state[i][j];
                int neighbors = 0;
                if (i > 0      ) {neighbors += state[i-1][j];}
                if (i < xSize-1) {neighbors += state[i+1][j];}
                if (j > 0      ) {neighbors += state[i][j-1];}
                if (j < ySize-1) {neighbors += state[i][j+1];}
                if (i > 0       && j > 0      ) {neighbors += state[i-1][j-1];}
                if (i < xSize-1 && j > 0      ) {neighbors += state[i+1][j-1];}
                if (i > 0       && j < ySize-1) {neighbors += state[i-1][j+1];}
                if (i < xSize-1 && j < ySize-1) {neighbors += state[i+1][j+1];}

                if (cellState == 1 && neighbors < 2 ) {newState[i][j] = 0;}
                if (cellState == 1 && neighbors > 3 ) {newState[i][j] = 0;}
                if (cellState == 1 && neighbors >= 2 && neighbors <= 3 ) {newState[i][j] = this.state[i][j];}
                if (cellState == 0 && neighbors == 3) {newState[i][j] = 1;}
            }
        }
    this.state = newState;
    }
}
