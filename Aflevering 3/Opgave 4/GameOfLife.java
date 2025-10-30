import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class GameOfLife {
    int n;
    int[][] state;

    public GameOfLife(String golFile) {
        try {
            Scanner scanner = new Scanner(new File(golFile));
            ArrayList<String> lines = new ArrayList<>();
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            this.n = lines.get(0).length();
            this.state = new int[n][n];
            
            // fyld  state array (levende celler)
            
            scanner.close();
        } catch (FileNotFoundException e) {
            // ingen fil? 

        }
    }

    public int golToN(String golData) {
        return n;
    }

    public int[][] golToState(String golData) {
        state = new int[n][n];

            }
        }
        return state;
    }

    public int[][] getState() {
        return this.state;
    }

    public void nextGen() {
        // rydder
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                state[i][j] = 0;
            }
        }
    }
}
