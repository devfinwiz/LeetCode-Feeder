class Solution {
public:
    void solve(vector<vector<char>>& board) {
        int m = board.size();
        if (m == 0) return;
        int n = board[0].size();

        // Lambda function for DFS
        auto dfs = [&](int i, int j, auto&& dfs) -> void {
            if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') return;
            board[i][j] = 'E'; // Mark as escaped
            dfs(i+1, j, dfs);
            dfs(i-1, j, dfs);
            dfs(i, j+1, dfs);
            dfs(i, j-1, dfs);
        };

        // Run DFS on all border 'O's
        for (int i = 0; i < m; ++i) {
            if (board[i][0] == 'O') dfs(i, 0, dfs);
            if (board[i][n-1] == 'O') dfs(i, n-1, dfs);
        }
        for (int j = 0; j < n; ++j) {
            if (board[0][j] == 'O') dfs(0, j, dfs);
            if (board[m-1][j] == 'O') dfs(m-1, j, dfs);
        }

        // Flip all remaining 'O' to 'X' and 'E' back to 'O'
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'E') board[i][j] = 'O';
            }
        }
    }
};