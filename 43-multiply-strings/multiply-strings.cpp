class Solution {
public:
    string multiply(string num1, string num2) {
        int m = num1.size();
        int n = num2.size();
        vector<int> result(m + n, 0);

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1[i] - '0') * (num2[j] - '0');
                int sum = mul + result[i + j + 1];
                result[i + j] += sum / 10;
                result[i + j + 1] = sum % 10;
            }
        }

        // Find the first non-zero digit in the result
        int start = 0;
        while (start < m + n && result[start] == 0) {
            start++;
        }

        // Convert the result to string
        string res;
        for (int i = start; i < m + n; i++) {
            res.push_back(result[i] + '0');
        }

        return res.empty() ? "0" : res;
    }
};