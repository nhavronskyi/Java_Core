public class Main {
    public static void main(String[] args) {
        Board board = new BoardImpl();
        board.showBoard();

        for (int count = 1; count <= 9; count++) {
            board.setXO(count);
            System.out.println();
            board.showBoard();

            if (board.checkWin()) {
                System.out.println("Player " + (count % 2 == 0 ? "O" : "X") + " wins!");
                break;
            }

            if (count == 9) {
                System.out.println("Game Draw!");
            }
        }
    }
}