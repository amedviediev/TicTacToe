package com.amedviediev.tictactoe;

/**
 * Board interface
 */
public interface Board {
    /**
     * Display current state of the board
     */
    public void displayBoard();

    /**
     * Play the turn
     * @param space space on the board where current player placed his token
     */
	public void turn(int space);

    /**
     * Switch to next player
     */
    public void changePlayer();
}
