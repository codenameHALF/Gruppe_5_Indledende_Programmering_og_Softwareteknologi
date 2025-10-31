public class GameOfLifeMain {
    public static String golPath = "gol/acorn.gol";
    
    public static void main(String[] args) {
        GameOfLife game = new GameOfLife(golPath);
        // game.writeState(read_file(golPath));
    }


}
