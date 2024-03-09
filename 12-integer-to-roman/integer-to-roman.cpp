class Solution {
public:
    string intToRoman(int num) {
        string result = "";

        // Arrays to store the symbols and their corresponding values
        int values[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        string symbols[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        // Iterate through the values and subtract them while appending the corresponding symbol
        for (int i = 0; i < 13; ++i) {
            while (num >= values[i]) {
                result += symbols[i];
                num -= values[i];
            }
        }

        return result;
    }
};