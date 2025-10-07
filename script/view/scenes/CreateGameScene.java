package view;

public class CreateGameScene {

    public CreateGameScene() {
        // Constructor logic
    }

    public int[][] getGrid() {
        // Return the current state of the game board
        return new int[3][3];
    }

    public int getWinCondtion() {
        // Return the win condition (e.g., number of marks in a row needed to win)
        return 3;
    }

    public int getPlayerNb() {
        // Return the name of player 1
        return 1;
    }

    public void lauchGame() {
        // Logic to launch the game
    }

    public void openSettingMenu() {
        // Logic to open the settings scene
    }
}
