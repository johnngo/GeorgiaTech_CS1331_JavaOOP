import java.util.*;
import java.io.*;

public class Battleship {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char p1Board[][] = new char[5][5];
        char p2Board[][] = new char[5][5];
        char p1BoardTrack[][] = new char[5][5];
        char p2BoardTrack[][] = new char[5][5];

        startGameboard(p1Board);
        startGameboard(p2Board);
        startGameboard(p1BoardTrack);
        startGameboard(p2BoardTrack);

        System.out.println("Welcome to Battleship!\n");
        //player 1 user input
        System.out.println("PLAYER 1, ENTER YOUR SHIPS COORDINATES.");
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter ship " + (i + 1) + " location");
            int p1row = sc.nextInt();
            int p1col = sc.nextInt();
            if (!checkCoordinates(p1row, p1col)) {
                System.out.println("Invalid Cordinates. choose different Coordinates.");
                i--;
            } else {
                if (p1Board[p1row][p1col] != '-') {
                    System.out.println("You already have a ship there. Choose different Coordinates.");
                    i--;
                } else {
                    p1Board[p1row][p1col] = '@';
                }
            }
        }
        printBattleShip(p1Board);
        spaces();

        //player 2 user input
        System.out.println("PLAYER 2, ENTER YOUR SHIPS COORDINATES");
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter ship " + (i + 1) + " location");
            int p2row = sc.nextInt();
            int p2col = sc.nextInt();
            if (!checkCoordinates(p2row, p2col)) {
                System.out.println("Invalid Coordinates. Choose different coordinates.");
                i--;
            } else {
                if (p2Board[p2row][p2col] != '-') {
                    System.out.println("you already have a ship there. Choose different Coordinates.");
                    i--;
                } else {
                    p2Board[p2row][p2col] = '@';
                }
            }
        }
        printBattleShip(p2Board);
        spaces();

        // Alternate between players to enter their target coordinates
        boolean winner = false;
        while (!winner) {
            boolean invalid = false;
            boolean player1 = true;
            boolean player2 = false;
            while (player1) {
                System.out.println("Player 1, enter hit row/column: ");
                int p1rowTarget = sc.nextInt();
                int p1colTarget = sc.nextInt();
                if (!checkCoordinates(p1rowTarget, p1colTarget)) {
                    System.out.println("Invalid Coordinates. Choose different coordinates.");
                } else {
                    if (p1BoardTrack[p1rowTarget][p1colTarget] == 'O') {
                        invalid = true;
                        while (invalid) {
                            System.out.println("Already fired on this spot");
                            if (checkCoordinates(p1rowTarget, p1colTarget)) {
                                invalid = false;
                            }
                        }
                    } else if (p1BoardTrack[p1rowTarget][p1colTarget] == 'X') {
                        invalid = true;
                        System.out.println("Already fired on this spot");
                        if (checkCoordinates(p1rowTarget, p1colTarget)) {
                            invalid = false;
                        }
                    } else if (p2Board[p1rowTarget][p1colTarget] != '@') {
                        System.out.println("Player 1 missed");
                        p1BoardTrack[p1rowTarget][p1colTarget] = 'O';
                        p2Board[p1rowTarget][p1colTarget] = 'O';
                        printBattleShip(p1BoardTrack);
                        System.out.println("\n");
                        player1 = false;
                        player2 = true;
                    } else if (p2Board[p1rowTarget][p1colTarget] == '@') {
                        System.out.println("Player 1 Hit player 2's SHIP");
                        p1BoardTrack[p1rowTarget][p1colTarget] = 'X';
                        p2Board[p1rowTarget][p1colTarget] = 'X';
                        printBattleShip(p1BoardTrack);
                        if (!checkBoard(p2Board)) {
                            winningPlayer(1, p1Board, p2Board);
                            winner = true;
                        }
                        player1 = false;
                        player2 = true;
                    } else {
                        System.out.println("Player 1 Wins! You sunk all of your opponents Ships!");
                        winner = true;
                    }
                }
                while (player2) {
                    System.out.println("Player 2, enter hit row/column: ");
                    int p2rowTarget = sc.nextInt();
                    int p2colTarget = sc.nextInt();
                    if (!checkCoordinates(p2rowTarget, p2colTarget)) {
                        System.out.println("Invalid coordinates. Choose different coordinates.");
                    } else {
                        if (p2BoardTrack[p2rowTarget][p2colTarget] == 'O') {
                            invalid = true;
                            while (invalid) {
                                System.out.println("Already fired on this spot");
                                if (checkCoordinates(p2rowTarget, p2colTarget)) {
                                    invalid = false;
                                }
                            }
                        } else if (p2BoardTrack[p2rowTarget][p2colTarget] == 'X') {
                            invalid = true;
                            System.out.println("Already fired on this spot");
                            if (checkCoordinates(p2rowTarget, p2colTarget)) {
                                invalid = false;
                            }
                        } else if (p1Board[p2rowTarget][p2colTarget] != '@') {
                            System.out.println("Player 2 missed");
                            p2BoardTrack[p2rowTarget][p2colTarget] = 'O';
                            p1Board[p2rowTarget][p2colTarget] = 'O';
                            printBattleShip(p2BoardTrack);
                            player2 = false;
                            player1 = true;
                        } else if (p1Board[p2rowTarget][p2colTarget] == '@') {
                            System.out.println("player 2 hit player 1 Ship!");
                            p2BoardTrack[p2rowTarget][p2colTarget] = 'X';
                            p1Board[p2rowTarget][p2colTarget] = 'X';
                            printBattleShip(p2BoardTrack);
                            if (!checkBoard(p1Board)) {
                                winningPlayer(2, p1Board, p2Board);
                                winner = true;
                            }
                            player2 = false;
                            player1 = true;
                        }
                    }
                }
            }
        }
    }
    public static void winningPlayer(int winner, char[][] p1Board, char[][] p2Board) {
        System.out.println("Player " + winner + " Wins! You Sunk all of your Opponent's Ship!");
        System.out.println("Final Boards: ");
        printBattleShip(p1Board);
        System.out.println();
        printBattleShip(p2Board);
    }

    public static boolean checkBoard(char[][] board) {
        boolean result = false;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '@') {
                    result = true;
                }
            }
        }
        return result;
    }

    public static boolean checkCoordinates(int row, int col) {
        boolean valid = false;
        if (((row > 4) || (row < 0) || ((col > 4) || (col < 0)))) {
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }

    public static void spaces() {
        int counter = 1;
        do {
            System.out.println();
            counter++;
        } while (counter <= 5);
    }

    private static char[][] startGameboard(char[][] gameBoard) {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int column = 0; column < gameBoard.length; column++) {
                gameBoard[row][column] = '-';
            }
        }
        return gameBoard;
    }

    private static void printBattleShip(char[][] player) {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                if (row == -1) {
                    System.out.print(column + " ");
                } else {
                    System.out.print(player[row][column] + " ");
                }
            }
            System.out.println("");
        }
    }
}