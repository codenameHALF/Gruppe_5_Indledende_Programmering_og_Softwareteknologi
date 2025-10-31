public class StartSceneState {
    public static int options = 2;
    public static int[] playerNums = {1, 2, 3, 4};
    public static String[] maps = {"default", "wide", "tight"};
    public int selectedPlayerNum = 0;
    public int selectedMap = 0;

    public int selectedOption = 0;


    public void up() {
        selectedOption += 1;
        if (selectedOption >= options) {selectedOption = 0;}
    }


    public void down() {
        selectedOption -= 1;
        if (selectedOption < 0) {selectedOption = options - 1;}
    }


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

    public int getSelectedPlayerNum() {
        return playerNums[selectedPlayerNum];
    }

    public int getSelectedMap() {
        return selectedMap;
    }

    public String getSelectedMapName() {
        return maps[selectedMap];
    }
}
