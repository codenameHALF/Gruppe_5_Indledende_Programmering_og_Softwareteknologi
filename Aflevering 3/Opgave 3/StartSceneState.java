// Class for storing and updating the state of the start scene
public class StartSceneState {
    public static int options = 2;
    public static int[] playerNums = {1, 2, 3, 4};
    public static String[] maps = {"default", "wide", "tight", "extreme"};
    public int selectedPlayerNum = 0;
    public int selectedMap = 0;
    public int selectedOption = 0;

    // Scroll vertical selection up
    public void up() {
        selectedOption += 1;
        if (selectedOption >= options) {selectedOption = 0;}
    }

    // Scroll vertical selection down
    public void down() {
        selectedOption -= 1;
        if (selectedOption < 0) {selectedOption = options - 1;}
    }

    // Scroll horizontal selection right
    public void right() {
        switch (selectedOption) {
            case 0:
                selectedPlayerNum += 1;
                if (selectedPlayerNum >= playerNums.length) {selectedPlayerNum = 0;}
                break;
            case 1:
                selectedMap += 1;
                if (selectedMap >= maps.length) {selectedMap = 0;}
                break;
        }
    }

    // Scroll horizontal selection left
    public void left() {
        switch (selectedOption) {
            case 0:
                selectedPlayerNum -= 1;
                if (selectedPlayerNum < 0) {selectedPlayerNum = playerNums.length-1;}
                break;
            case 1:
                selectedMap -= 1;
                if (selectedMap < 0) {selectedMap = maps.length-1;}
                break;
        }
    }

    // Getter for playerNum
    public int getSelectedPlayerNum() {
        return playerNums[selectedPlayerNum];
    }

    // Getter for selectedMap
    public int getSelectedMap() {
        return selectedMap;
    }

    // Getter for name of selected map
    public String getSelectedMapName() {
        return maps[selectedMap];
    }
}
