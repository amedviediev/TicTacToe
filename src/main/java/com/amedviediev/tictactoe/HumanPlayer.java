package com.amedviediev.tictactoe;

import java.util.*;

/**
 * Controller class for human players
 */
public class HumanPlayer extends Player {
    
	Scanner keyboard = new Scanner(System.in);
	private int inputVal;

    /**
     * Get input from player and make move
     * @return board space where player placed his token
     */
	public int makeMove() {
		try {
			inputVal = keyboard.nextInt();
			// check for valid space between 1 and 9
			if (inputVal < 1 || inputVal > 9 || !TicTacToeBoard.isValidSpace(inputVal)) {
                
				System.out.println("Please enter an open spot between 1 and 9.");
				promptInput();
				makeMove();
			}
		} catch (InputMismatchException e) {
			System.out.println("Integers between 1 and 9 only... Try again!");
            keyboard = new Scanner(System.in);
            promptInput();
            makeMove();
		} catch (IllegalStateException e) {
			System.out.println("Scanner is closed. Exiting.");
			System.exit(1);
		}
        
		return inputVal;
	}
}
