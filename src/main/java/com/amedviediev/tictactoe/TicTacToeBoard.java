package com.amedviediev.tictactoe;

/**
 * Controller for game board. Keeps track of current game state
 */
public class TicTacToeBoard implements Board {

	private static int[][] boardState = new int[3][3];
	private static boolean playerX = true;
	private static boolean playerO = false;
    private BoardDrawer drawer;

    /**
     * Create a new board
     * @param drawer instance of BoardDrawer, responsible for displaying the board
     */
	public TicTacToeBoard(BoardDrawer drawer) {
        this.drawer = drawer;

		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				boardState[i][j] = 0;
			}
		}

	}

    /**
     * Display board in the current state
     */
	public void displayBoard(){
        drawer.draw(boardState);
    }

    /**
     * Place token on board based on current player input
     * @param playSpace space on board that the current player selected for his turn
     */
	public void turn(int playSpace){
        if(playerX){
            switch (playSpace) {
                case 1: boardState[0][0] = 1; break;
                case 2: boardState[0][1] = 1; break;
                case 3: boardState[0][2] = 1; break;
                case 4: boardState[1][0] = 1; break;
                case 5: boardState[1][1] = 1; break;
                case 6: boardState[1][2] = 1; break;
                case 7: boardState[2][0] = 1; break;
                case 8: boardState[2][1] = 1; break;
                case 9: boardState[2][2] = 1; break;
            }
        }
        
        //player O's boardState
        else{
            switch (playSpace) {
                case 1: boardState[0][0] = 2; break;
                case 2: boardState[0][1] = 2; break;
                case 3: boardState[0][2] = 2; break;
                case 4: boardState[1][0] = 2; break;
                case 5: boardState[1][1] = 2; break;
                case 6: boardState[1][2] = 2; break;
                case 7: boardState[2][0] = 2; break;
                case 8: boardState[2][1] = 2; break;
                case 9: boardState[2][2] = 2; break;
            }
        }
    }

    /**
     * Pass turn to next player
     */
	public void changePlayer(){
        if(playerX){
            playerX = false;
            playerO = true;
        }
        else{
            playerX = true;
            playerO = false;
        }
        
    }    

    /**
     * @return whose turn it is. PlayerO is implicitly false
     */
	public static boolean isPlayerX(){
        return playerX;
    }

    /**
     * Check for win condition for playerX
     * @return true is playerX has won, false otherwise
     */
	public boolean xWins() {
        if(boardState[0][0]==1 && boardState[0][1]==1 && boardState[0][2]==1)
            return true;
        else if(boardState[1][0]==1 && boardState[1][1]==1 && boardState[1][2]==1)
            return true;
        else if(boardState[2][0]==1 && boardState[2][1]==1 && boardState[2][2]==1)
            return true;
        else if(boardState[0][0]==1 && boardState[1][0]==1 && boardState[2][0]==1)
            return true;
        else if(boardState[0][1]==1 && boardState[1][1]==1 && boardState[2][1]==1)
            return true;
        else if(boardState[0][2]==1 && boardState[1][2]==1 && boardState[2][2]==1)
            return true;
        else if(boardState[0][0]==1 && boardState[1][1]==1 && boardState[2][2]==1)
            return true;
        else if(boardState[0][2]==1 && boardState[1][1]==1 && boardState[2][0]==1)
            return true;
        else
            return false;
    }


    /**
     * Check for win condition for playerO
     * @return true is playerO has won, false otherwise
     */
    public boolean oWins() {
        if(boardState[0][0]==2 && boardState[0][1]==2 && boardState[0][2]==2)
            return true;
        else if(boardState[1][0]==2 && boardState[1][1]==2 && boardState[1][2]==2)
            return true;
        else if(boardState[2][0]==2 && boardState[2][1]==2 && boardState[2][2]==2)
            return true;
        else if(boardState[0][0]==2 && boardState[1][0]==2 && boardState[2][0]==2)
            return true;
        else if(boardState[0][1]==2 && boardState[1][1]==2 && boardState[2][1]==2)
            return true;
        else if(boardState[0][2]==2 && boardState[1][2]==2 && boardState[2][2]==2)
            return true;
        else if(boardState[0][0]==2 && boardState[1][1]==2 && boardState[2][2]==2)
            return true;
        else if(boardState[0][2]==2 && boardState[1][1]==2 && boardState[2][0]==2)
            return true;
        else
            return false;
	}

    /**
     * Check for draw
     * @return true if game is a draw, false otherwise
     */
	public boolean isCatGame() {
		for (int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if (boardState[i][j]==0)
					return false;
			}
		}
		return true;
	}

    /**
     * Check whether a move is valid
     * @param input move to check
     * @return true if move can be made, false otherwise
     */
	public static boolean isValidSpace(int input) {
		switch(input) {
			case 1: if (boardState[0][0] != 0) return false; break;
			case 2: if (boardState[0][1] != 0) return false; break;
			case 3: if (boardState[0][2] != 0) return false; break;
			case 4: if (boardState[1][0] != 0) return false; break;
			case 5: if (boardState[1][1] != 0) return false; break;
			case 6: if (boardState[1][2] != 0) return false; break;
			case 7: if (boardState[2][0] != 0) return false; break;
			case 8: if (boardState[2][1] != 0) return false; break;
			case 9: if (boardState[2][2] != 0) return false; break;
		}
		return true;
	}
}
