import java.util.InputMismatchException;
import java.util.Scanner;

public class BoardImpl implements Board {
    private final int[][] board = new int[3][3];

    public void setXO(int count) {
        Scanner scanner = new Scanner(System.in);
        int player = count % 2 == 0 ? 2 : 1;

        while (true) {
            System.out.println("Player " + (player == 1 ? "X" : "O"));
            System.out.print("Enter row and column (1-3): ");

            try {
                int row = scanner.nextInt() - 1;
                int col = scanner.nextInt() - 1;

                if (board[row][col] == 0) {
                    board[row][col] = player;
                    break;
                } else {
                    System.out.println("This position is already filled!");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid row or column! Enter numbers from 1 to 3.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Enter numbers.");
                scanner.next();
            }
        }
    }

    public boolean checkWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != 0 && board[0][j] == board[1][j] && board[0][j] == board[2][j]) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return true;
        }

        return board[0][2] != 0 && board[0][2] == board[1][1] && board[0][2] == board[2][0];
    }

    public void showBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                String symbol = " ";
                if (board[i][j] == 1) {
                    symbol = "X";
                } else if (board[i][j] == 2) {
                    symbol = "O";
                }
                System.out.printf("%2s", symbol);

                if (j < board[i].length - 1) {
                    System.out.print(" |");
                }
            }

            System.out.println();
            if (i < board.length - 1) {
                System.out.println("-----------");
            }
        }
    }
}
