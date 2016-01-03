package com.amedviediev.tictactoe;

import java.util.Scanner;

/**
 * Main class which controls the game flow
 */
public class TicTacToeGame {

    private static Player playerX;
    private static Player playerO;
    private static TicTacToeBoard board;

	public static void main(String[] args) {
        getGameVariables();
        initGame();
        play();
	}

    /**
     * Get user input about which players will be controller by a human and which will be controller by a computer
     */
    private static void getGameVariables() {
        Scanner keyboard = new Scanner(System.in);

        //set player X
        System.out.print("Will player X be human?(y/n): ");
        String answerX = keyboard.next();
        if (answerX.equalsIgnoreCase("y")) {
            playerX = new HumanPlayer();
        } else if (answerX.equalsIgnoreCase("n")) {
            playerX = new RandomComputerPlayer();
        } else {
            System.out.println("You must enter either y or n");
            System.exit(0);
        }

        //set player O
        System.out.print("Will player O be human?(y/n): ");
        String answerO = keyboard.next();
        if (answerO.equalsIgnoreCase("y")) {
            playerO = new HumanPlayer();
        } else if (answerO.equalsIgnoreCase("n")) {
            playerO = new RandomComputerPlayer();
        } else {
            System.out.println("You must enter either y or n");
            System.exit(0);
        }
    }

    /**
     * Init game board
     */
    private static void initGame() {
        System.out.println("\nTic-Tac-Toe!\n\n"+
                "1|2|3\n"+
                "-----\n"+
                "4|5|6\n"+
                "-----\n"+
                "7|8|9\n");

        BoardDrawer drawer = new BoardDrawer();
        board = new TicTacToeBoard(drawer);
    }

    /**
     * Main game loop which runs until game is over
     */
    private static void play() {
        int compMove;

        while(!(board.xWins() || board.oWins() || board.isCatGame())) {

            //Allow either player X or player O to play
            if(TicTacToeBoard.isPlayerX()) {

                playerX.promptInput();

                //Check if the player is human or computer.
                if (playerX instanceof HumanPlayer) {
                    board.turn(playerX.makeMove());
                } else {
                    compMove = playerX.makeMove();
                    System.out.println(compMove);
                    board.turn(compMove);
                }
            } else {
                playerO.promptInput();
                //Check if the player is human or computer.
                if (playerO instanceof HumanPlayer) {
                    board.turn(playerO.makeMove());
                } else {
                    compMove = playerO.makeMove();
                    System.out.println(compMove);
                    board.turn(compMove);
                }
            }

            board.displayBoard();
            board.changePlayer();
        }
        //Display game results
        if(board.xWins()) {

            board.displayBoard();
            System.out.println("Game Over! Player X wins!\n");
        }
        else if(board.oWins()) {

            board.displayBoard();
            System.out.println("Game Over! Player O wins!\n");
        }
        else {

            board.displayBoard();
            System.out.println("Game Over! Cat game!\n");
        }
    }
}
