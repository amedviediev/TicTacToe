package com.amedviediev.tictactoe;

/**
 * Class possible for displaying current state of the board
 */
public class BoardDrawer {

    /**
     * Draws the game board in its current state
     *
     * @param state two-dimensional array with information about the current game state
     */
    public void draw(int[][] state) {
        System.out.print("\n");
        for (int i = 0; i <= 2; i++) {
            //Draw empty board
            for (int j = 0; j <= 2; j++) {
                if (state[i][j] == 0 && j < 2) {
                    System.out.print(" |");
                } else if (state[i][j] == 0 && j == 2 && i < 2) {
                    System.out.print(" \n-----\n");
                } else if (state[i][j] == 0 && j == 2 && i == 2) {
                    System.out.println(" \n");
                }
                //Draw board with any X's in the relevant place
                else if (state[i][j] == 1 && j < 2) {
                    System.out.print("X|");
                } else if (state[i][j] == 1 && j == 2 && i < 2) {
                    System.out.print("X\n-----\n");
                } else if (state[i][j] == 1 && j == 2 && i == 2) {
                    System.out.println("X\n");
                }
                //Draw board with any O's in the relevant place
                else if (state[i][j] == 2 && j < 2) {
                    System.out.print("O|");
                } else if (state[i][j] == 2 && j == 2 && i < 2) {
                    System.out.print("O\n-----\n");
                } else if (state[i][j] == 2 && j == 2 && i == 2) {
                    System.out.println("O\n");
                }
            }
        }
    }
}
