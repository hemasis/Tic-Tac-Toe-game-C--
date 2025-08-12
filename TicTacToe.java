import java.util.Scanner;

public class TicTacToe {

    // Function to draw the Tic-Tac-Toe board
    public static void drawBoard(char[][] board) {
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

    // Function to check for a win
    public static boolean checkWin(char[][] board, char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
                return true;
        }
        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize the board and players
        char[][] board = {
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' }
        };
        char player = 'X';
        int row, col;
        int turn; // Declare turn here

        System.out.println("Welcome to Tic-Tac-Toe!");

        // Game loop
        for (turn = 0; turn < 9; turn++) {
            // Draw the board
            drawBoard(board);

            // Prompt for valid input
            while (true) {
                System.out.print("Player " + player + ", enter row (0-2) and column (0-2): ");
                row = sc.nextInt();
                col = sc.nextInt();

                if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                    System.out.println("Invalid move. Try again.");
                } else {
                    break; // Valid input, exit the loop
                }
            }

            // Make the move
            board[row][col] = player;

            // Check for a win after making a move
            if (checkWin(board, player)) {
                drawBoard(board);
                System.out.println("Player " + player + " wins!");
                break; // Exit the loop after a win
            }

            // Switch to the other player
            player = (player == 'X') ? 'O' : 'X';
        }

        // End of the game
        drawBoard(board);

        // Check for a draw
        if (turn == 9 && !checkWin(board, 'X') && !checkWin(board, 'O')) {
            System.out.println("It's a draw!");
        }

        sc.close();
    }
}
