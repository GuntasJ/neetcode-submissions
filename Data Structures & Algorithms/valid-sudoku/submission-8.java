class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!check(board[i])) {
                return false;
            }
            char[] col = new char[board.length];
            for (int j = 0; j < board.length; j++) {
                col[j] = board[j][i];
            }
            if (!check(col)) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!check(getGrid(i, board))) {
                return false;
            }
        }
        return true;
    }

    private char[] getGrid(int index, char[][] board) {
        char[] arr = {'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        int columnStart = (index % 3) * 3;
        int rowStart = (index / 3) * 3;
        int column = columnStart;
        int row = rowStart;
        for (int i = 0; i < 9; i++) {
            arr[i] = board[row][column];
            column++;
            if (column % 3 == 0) {
                row++;
                column = columnStart;
            }
        }
        return arr;
    }

    private boolean check(char[] arr) {
        Set<Character> charSet = new HashSet<>();
        for (var c : arr) {
            if (charSet.contains(c)) {
                return false;
            }
            if (c != '.') {
                charSet.add(c);
            }
        }
        return true;
    }
}
