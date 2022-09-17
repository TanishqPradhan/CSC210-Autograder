
import java.util.Scanner;

class Project5 {
    
    public static void main(String[] args)
    {
        char[][] board = new char[][]{
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'},
        };
        
        displayBoard(board);
        
        Scanner input = new Scanner(System.in);
        
        while (true) {
            makeMove(board, 'X', input);
            displayBoard(board);
            
            if (hasWon(board, 'X')) {
                System.out.println("X player won");
                return;
            } else if (isDraw(board)) {
                System.out.println("Draw");
                return;
            }
            
            makeMove(board, 'O', input);
            displayBoard(board);
            
            if (hasWon(board, 'O')) {
                System.out.println("O player won");
                return;
            } else if (isDraw(board)) {
                System.out.println("No winner");
                return;
            }
            
        }
        
    }
    
    
    public static boolean hasWon(char[][] board, char player)
    {
        for (int i = 0; i < 3; i++) {
            
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        
        if (board[2][0] == player && board[1][1] == player && board[0][2] == player) {
            return true;
        }
        
        
        return false;
    }
    
    public static boolean isDraw(char[][] board)
    {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    return false;
                }
            }
            
        }
        
        return true;
    }
    
    
    public static void makeMove(char[][] board, char player, Scanner input)
    {
    
    
        int row = -1, col = -1;
        boolean validCell = true;
    
        do {
            System.out.println(player + " turn: ");
        
        
            int cell = input.nextInt();
        
//            if (cell < 1 || cell > 9) {
//                System.out.println("Invalid move\n");
//                validCell = false;
//                continue;
//            }
        
            cell--;
        
            row = cell / 3;
            col = cell % 3;
        
            if (board[row][col] == 'X' || board[row][col] == 'O') {
                System.out.println("Cell is already taken. Please choose another cell.\n");
                validCell = false;
            }
        
        } while (!validCell);
    
        board[row][col] = player;
    
    }
    
    public static void displayBoard(char[][] board)
    {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}