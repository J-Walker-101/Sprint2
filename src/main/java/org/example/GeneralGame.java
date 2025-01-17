package org.example;

public class GeneralGame extends SOSGame {
    private int redPlayerScore = 0;
    private int bluePlayerScore = 0;

    public GeneralGame(int boardSize) {
        super(boardSize);
        this.gameMode = GameMode.GENERAL;
    }

    @Override
    public void placeLetter(int row, int col, char letter) {
        if (board.isValidMove(row, col)) {
            board.setCell(row, col, letter);
            if (hasSOS(row, col)) {
                if (currentPlayer == redPlayer) {
                    redPlayerScore++;
                    System.out.println("Red scores! Total Red score: " + redPlayerScore);
                } else {
                    bluePlayerScore++;
                    System.out.println("Blue scores! Total Blue score: " + bluePlayerScore);
                }
            }
            if (board.isFull()) {
                System.out.println("The board is full. " + getWinner());
                board.printBoard();
                System.exit(0);
            }
        } else {
            System.out.println("Invalid move. Cell is already occupied.");
        }
    }

    public String getWinner() {
        if (redPlayerScore > bluePlayerScore) return "Red wins with score: " + redPlayerScore;
        else if (bluePlayerScore > redPlayerScore) return "Blue wins with score: " + bluePlayerScore;
        else return "It's a tie!";
    }
}