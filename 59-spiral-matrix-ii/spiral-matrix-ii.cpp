class Solution {
public:
    std::vector<std::vector<int>> generateMatrix(int n) {
        std::vector<std::vector<int>> matrix(n, std::vector<int>(n, 0));
        int num = 1;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;

        while (num <= n * n) {
            // Fill top row
            for (int i = left; i <= right && num <= n * n; ++i) {
                matrix[top][i] = num++;
            }
            top++;

            // Fill rightmost column
            for (int i = top; i <= bottom && num <= n * n; ++i) {
                matrix[i][right] = num++;
            }
            right--;

            // Fill bottom row
            for (int i = right; i >= left && num <= n * n; --i) {
                matrix[bottom][i] = num++;
            }
            bottom--;

            // Fill leftmost column
            for (int i = bottom; i >= top && num <= n * n; --i) {
                matrix[i][left] = num++;
            }
            left++;
        }

        return matrix;
    }
};