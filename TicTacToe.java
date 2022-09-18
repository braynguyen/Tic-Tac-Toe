public class TicTacToe {
    private String[][] board = {{"0,0", "|", "0,2", "|", "0,4"}, {"---", "---", "---", "-", "-"}, {"2,0", "|", "2,2", "|", "2,4"}, {"---", "---", "---", "-", "-"}, {"4,0", "|", "4,2", "|", "4,4"}};
    private String turn;
    private boolean gameOver;
    private int count;

    public TicTacToe() {
        turn = " X ";
        gameOver = false;
        count = 0;
    }

    public void displayBoard() {
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                System.out.print(board[r][c]);
            }
            System.out.println();
        }
    }

    public boolean getGameOver(){
        return gameOver;
    }

    private boolean spotTaken(int r, int c){
        return board[r][c] == " O " || board[r][c] == " X ";
    }

    public void play(int row, int col){
        if(!spotTaken(row, col)){
            board[row][col] = turn;
            if (turn.equals(" X ")) {
                turn = " O ";
            } else if (turn.equals(" O ")) {
                turn = " X ";
            }
            count++;
            displayBoard();
        }
        else {
            System.out.println("Invalid spot. Try again.");
            displayBoard();
        }
    }

    public void checkWinner(){
        for(int i = 0; i < 8; i++){
            String line = null;
            switch (i) {
                case 0: 
                    line = board[0][0] + board[0][2] + board[0][4];
                    break;
                case 1:
                    line = board[2][0] + board[2][2] + board[2][4];
                    break;
                case 2:
                    line = board[4][0] + board[4][2] + board[4][4];
                    break;
                case 3:
                    line = board[0][0] + board[2][0] + board[4][0];
                    break;
                case 4:
                    line = board[0][2] + board[2][2] + board[4][2];
                    break;
                case 5:
                    line = board[0][4] + board[2][4] + board[4][4];
                    break;
                case 6:
                    line = board[0][0] + board[2][2] + board[4][4];
                    break;
                case 7:
                    line = board[0][4] + board[2][2] + board[4][0];
                    break;
            }
                
            if (line.equals(" X  X  X ")) {    
                gameOver = true;
                System.out.println("Winner: X");
            }

            if (line.equals(" O  O  O ")) {    
                gameOver = true;
                System.out.println("Winner: O");
            }
        }
        
        if(count >= 9 && !gameOver){
            gameOver = true;
            System.out.println("Tie");
        }
        
    }
}

