package com.amedviediev.tictactoe;

import java.util.Random;

/**
 * Controller class for computer-controller players. Places a token on a random available space
 */
public class RandomComputerPlayer extends Player {

    /**
     * Make decision about next move
     * @return board space where the player placed his token
     */
	public int makeMove() {
		Random generator = new Random();
		int randomInt;

		randomInt = generator.nextInt(9) + 1;

        //Generate an number until we get a valid move
		while(!(TicTacToeBoard.isValidSpace(randomInt) && randomInt <= 9 && randomInt >= 1)) {
            randomInt = generator.nextInt(9) + 1;
        }
        
		return randomInt;
	}
}
