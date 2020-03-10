import java.util.Arrays;
import java.util.Scanner;

public class Connect4 {
    private static char TIE = 0;
    char[][] board;
    int row;
    int col;
    int[] curPos;
    int[] potentiality;
    int steps = 0;
    int[][] rows;
    int[][] cols;
    int[][] diags;
    int[][] opdiags;
    char aiPlayer = 'b';
    public Connect4() {
        this.row = 6;
        this.col = 7;
        board = new char[row][col];
        rows = new int[row][col];
        cols = new int[row][col];
        diags = new int[row][col];
        opdiags = new int[row][col];

        curPos = new int[col];
        Arrays.fill(curPos, row - 1);
        potentiality = new int[col];
    }

    public boolean tryDropPiece(char[][] board, int col, char player) {
        if (col < 0 || col >= board[0].length) {
            return false;
        }
        if (curPos[col] < 0) {
            return false;
        } else {
            steps++;
            board[curPos[col]][col] = player;
            curPos[col] --;
            return true;
        }
    }

    public boolean aiGo() {
        if (steps >= row * col) {
            return false;
        }
        int maxP = -1;
        int nextMove = -1;
        for (int i = 0; i < col; i++) {
            int curR = curPos[i];
            if (curR < 0) {
                continue;
            }
            if (maxP < 0) {
                maxP = 0;
                nextMove = i;
            }
            // col
            int newR = curR - 1;
            if (newR >= 0) {
                if (cols[newR][i] + 1 > maxP) {
                    maxP = cols[newR][i] + 1;
                    nextMove = i;
                } else if (cols[newR][i] == maxP && board[newR][i] == aiPlayer) {
                    nextMove = i;
                }
            }
            // rows
            if (i - 1 >= 0 && i + 1 < col && board[curR][i + 1] == board[curR][i - 1]) {
                int newP = rows[curR][i + 1] + rows[curR][i - 1];
                if (newP > maxP) {
                    maxP = newP;
                    nextMove = i;
                } else if (newP == maxP && board[curR][i + 1] == aiPlayer) {
                    nextMove = i;
                }
            } else {
                if (i - 1 >= 0) {
                    if (rows[curR][i - 1] > maxP) {
                        maxP = rows[curR][i - 1];
                        nextMove = i;
                    } else if (rows[curR][i - 1] == maxP && board[curR][i - 1] == aiPlayer) {
                        nextMove = i;
                    }
                }
                if (i + 1 < col) {
                    if (rows[curR][i + 1] > maxP) {
                        maxP = rows[curR][i + 1];
                        nextMove = i;
                    } else if (rows[curR][i + 1] == maxP && board[curR][i + 1] == aiPlayer) {
                        nextMove = i;
                    }
                }
            }
            // diagonal
            if (i - 1 >=0 && curR + 1 < row && i + 1 < col && curR - 1 >=0 && board[curR + 1][i - 1] == board[curR - 1][i + 1]) {
                int newP = diags[curR + 1][i - 1] + diags[curR - 1][i + 1];
                if (newP > maxP || (newP == maxP && board[curR - 1][i + 1] == aiPlayer)) {
                    maxP = newP;
                    nextMove = i;
                }
            } else {
                if (i - 1 >=0 && curR + 1 < row) {
                    if (diags[curR + 1][i - 1] > maxP || (diags[curR + 1][i-1] == maxP && board[curR + 1][i - 1] == aiPlayer)) {
                        maxP = diags[curR + 1][i - 1];
                        nextMove = i;
                    }
                }
                if (i + 1 < col && curR - 1 >=0) {
                    if (diags[curR - 1][i + 1] > maxP || (diags[curR - 1][i + 1] == maxP && board[curR - 1][i + 1] == aiPlayer)) {
                        maxP = diags[curR - 1][i + 1];
                        nextMove = i;
                    }
                }
            }
            // opposite diagonal
            if (i - 1 >=0 && curR - 1 >=0 && i + 1 < col &&  curR + 1 < row && board[curR + 1][i + 1] == board[curR - 1][i - 1]) {
                int newP = opdiags[curR + 1][i + 1] + opdiags[curR - 1][i - 1];
                if (newP > maxP || (newP == maxP && board[curR - 1][i - 1] == aiPlayer)) {
                    maxP = newP;
                    nextMove = i;
                }
            } else {
                if (i - 1 >=0 && curR - 1 >=0) {
                    if (opdiags[curR - 1][i - 1] > maxP || (opdiags[curR - 1][i-1] == maxP && board[curR - 1][i - 1] == aiPlayer)) {
                        maxP = opdiags[curR - 1][i - 1];
                        nextMove = i;
                    }
                }
                if (i + 1 < col &&  curR + 1 < row) {
                    if (opdiags[curR + 1][i + 1] > maxP || (opdiags[curR + 1][i + 1] == maxP && board[curR + 1][i + 1] == aiPlayer)) {
                        maxP = opdiags[curR + 1][i + 1];
                        nextMove = i;
                    }
                }
            }
        }
        // move

        tryDropPiece(board, nextMove, aiPlayer);

        return true;
    }
    public char checkForWin(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    rows[i][j] = 0;
                    cols[i][j] = 0;
                    diags[i][j] = 0;
                    opdiags[i][j] = 0;
                    continue;
                } else {
                    rows[i][j] = 1;
                    cols[i][j] = 1;
                    diags[i][j] = 1;
                    opdiags[i][j] = 1;
                }
                // rows
                if (j > 0) {
                    if (board[i][j] == board[i][j - 1]) {
                        rows[i][j] = rows[i][j-1] + 1;
                        rows[i][j - rows[i][j - 1]] = rows[i][j];
                        if (rows[i][j] >= 4) {
                            return board[i][j];
                        }
                    }
                }
                // cols
                if (i > 0 && board[i][j] == board[i-1][j]) {
                    cols[i][j] = cols[i - 1][j];
                    cols[i - cols[i-1][j]][j] = cols[i][j];
                    if (cols[i][j] >= 4) {
                        return board[i][j];
                    }
                }
                // opposite diagonal
                if (i>0 && j > 0 && board[i - 1][j - 1] == board[i][j]) {
                    opdiags[i][j] = opdiags[i - 1][j - 1] + 1;
                    opdiags[i - opdiags[i - 1][j - 1]][j - opdiags[i-1][j-1]] = opdiags[i][j];
                    if (opdiags[i][j] >= 4) {
                        return board[i][j];
                    }
                }
                // diagonal
                if (i > 0 && j < board[0].length - 1 && board[i - 1][j + 1] == board[i][j]) {
                    diags[i][j] = diags[i - 1][j + 1];
                    diags[i - diags[i-1][j+1]][j + diags[i - 1][j+1]] = diags[i][j];
                    if (diags[i][j] >= 4) {
                        return board[i][j];
                    }
                }
            }
        }

        return TIE;
    }

    public char checkForWinV1(char[][] board) {
        // check row and diagonal
        char pre = 0;
        int curLen = 0;
        int[][] preRow = new int[2][board[0].length];
        int[] preRow2 = new int[board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // row
                if (pre == 0 || pre != board[i][j]) {
                    curLen = 0;
                    pre = board[i][j];
                } else if (pre == board[i][j]) {
                    if (++curLen >= 3) {
                        return board[i][j];
                    }
                }

                // \ opposite diagonal
                if (i>0 && j > 0) {
                    if (board[i][j] != 0 && board[i - 1][j - 1] == board[i][j]) {
                        preRow[i % 2][j] = preRow[(i - 1) % 2][j - 1] + 1;
                        if (preRow[i % 2][j] >= 3) {
                            return board[i][j];
                        }
                    } else {
                        preRow[i % 2][j] = 0;
                    }
                }
                // diagonal
                if (i > 0 && j < board[0].length - 1) {
                    if (board[i][j] != 0 && board[i - 1][j + 1] == board[i][j]) {
                        preRow2[j] = preRow2[j + 1] + 1;
                        if (preRow2[j] >= 3) {
                            return board[i][j];
                        }
                    } else {
                        preRow2[j] = 0;
                    }
                }
            }
        }
        // check col;
        pre = 0;
        for (int c = 0; c < board[0].length; c++) {
            for (int r = 0; r < board.length; r ++) {
                if (pre == 0 || pre != board[r][c]) {
                    curLen = 0;
                    pre = board[r][c];
                } else if (pre == board[r][c]) {
                    if (++curLen >= 3) {
                        return board[r][c];
                    }
                }
            }
        }

        return TIE;
    }

    void printBoard() {
        for (int r = 0; r < row; r++) {
            System.out.print('|');
            for (int c = 0; c < col; c++) {
                if (board[r][c] == 0) {
                    System.out.print(' ');
                } else {
                    System.out.print(board[r][c]);
                }
                System.out.print('|');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {'r', 0, 0, 0, 0, 0, 0},
                {0, 'r', 0, 0, 0, 0, 0},
                {0, 0, 'r', 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
        };
        Connect4 instance = new Connect4();

//        System.out.println(instance.checkForWin(board));
//        System.out.println(instance.tryDropPiece(board, 3, 'r'));
//        System.out.println(instance.checkForWin(board));
        instance.printBoard();
        Scanner you = new Scanner(System.in);

        while (true) {
            System.out.println("It is your turn:");
            int next = you.nextInt();
            boolean moved = instance.tryDropPiece(instance.board, next, 'r');
            if (!moved) {
                System.out.println("Invalid move, try again~");
                continue;
            }
            instance.printBoard();
            System.out.println("============================");
            char winner = instance.checkForWin(instance.board);
            if (winner != 0) {
                System.out.println("Congratulation! you win - " + winner);
                break;
            }
            boolean canGo = instance.aiGo();
            if (!canGo) {
                System.out.println("end game!");
                break;
            }
            instance.printBoard();
            winner = instance.checkForWin(instance.board);
            if (winner != 0) {
                System.out.println("Ai win - " + winner);
                break;
            }
            System.out.println("============================");
        }
    }
}
