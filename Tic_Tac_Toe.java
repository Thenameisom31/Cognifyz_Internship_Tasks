import java.util.Scanner;

public class Tic_Tac_Toe {
    private char[][] board;

    public Tic_Tac_Toe() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean placeMark(int row, int col, char mark) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            System.out.println("Invalid move. Row and Column should be between 0 and 2.");
            return false;
        }
        if (board[row][col] != ' ') {
            System.out.println("Cell already occupied. Please choose another cell.");
            return false;
        }
        board[row][col] = mark;
        return true;
    }

    public boolean checkWin(char mark) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == mark && board[i][1] == mark && board[i][2] == mark) ||
                (board[0][i] == mark && board[1][i] == mark && board[2][i] == mark)) {
                return true;
            }
        }
        // Check diagonals
        if ((board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) ||
            (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark)) {
            return true;
        }
        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tic_Tac_Toe game = new Tic_Tac_Toe();
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Player X and Player O take turns.");
        System.out.println("Enter your move in the format: row col (e.g., 1 2)");

        char currentPlayer = 'X';
        while (true) {
            printBoard(game.board);
            boolean validMove = false;

            while (!validMove) {
                System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                validMove = game.placeMark(row, col, currentPlayer);

                if (!validMove) {
                    System.out.println("Try again!");
                }
            }

            if (game.checkWin(currentPlayer)) {
                printBoard(game.board);
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            if (game.isBoardFull()) {
                printBoard(game.board);
                System.out.println("It's a draw!");
                break;
            }

            // Switch players
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        scanner.close();
    }
}
