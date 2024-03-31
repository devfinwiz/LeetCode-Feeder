class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        // Check rows
        for (int i = 0; i < 9; ++i) {
            unordered_set<char> rowSet;
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.' && !rowSet.insert(board[i][j]).second) {
                    return false; // Duplicate found
                }
            }
        }
        
        // Check columns
        for (int j = 0; j < 9; ++j) {
            unordered_set<char> colSet;
            for (int i = 0; i < 9; ++i) {
                if (board[i][j] != '.' && !colSet.insert(board[i][j]).second) {
                    return false; // Duplicate found
                }
            }
        }
        
        // Check sub-grids
        for (int block = 0; block < 9; ++block) {
            unordered_set<char> blockSet;
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; ++i) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; ++j) {
                    if (board[i][j] != '.' && !blockSet.insert(board[i][j]).second) {
                        return false; // Duplicate found
                    }
                }
            }
        }
        
        return true;
    }
};