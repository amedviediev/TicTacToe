package com.amedviediev.tictactoe;

/**
 * Abstract controller for a player
 */
public abstract class Player {

    /**
     * Ask player for an input
     */
	public void promptInput() {
        //Check which player's turn it currently is.
		if (TicTacToeBoard.isPlayerX())
			System.out.print("Player X enter an open spot to mark: ");
		else
            System.out.print("Player O enter an open spot to mark: ");
	}

    /**
     * Make decision about next move
     * @return board space where player placed his token
     */
	public abstract int makeMove();
}
