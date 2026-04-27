class Solution {
    public boolean isValidSudoku(char[][] board) {

        boolean[][] rows = new boolean[9][9];

        boolean[][] cols = new boolean[9][9];

        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];


                if (ch == '.') {
                    continue;
                }

                // Convert char '1'..'9' to index 0..8
                int d = ch - '1';
                if (d < 0 || d > 8) {
                    return false;
                }

                int boxIndex = (r / 3) * 3 + (c / 3);

                // Check row
                if (rows[r][d]) {
                    return false;  
                }
                rows[r][d] = true;

                // Check column
                if (cols[c][d]) {
                    return false;  
                }
                cols[c][d] = true;

                // Check 3x3 box
                if (boxes[boxIndex][d]) {
                    return false; 
                }
                boxes[boxIndex][d] = true;
            }
        }

        // No conflicts found
        return true;
    }
}
