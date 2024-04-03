class Solution {
public:
    string countAndSay(int n) {
        if (n == 1)
            return "1";
        
        string prev = countAndSay(n - 1);
        string result = "";
        
        int count = 1;
        char say = prev[0];
        
        for (int i = 1; i < prev.length(); i++) {
            if (prev[i] == say) {
                count++;
            } else {
                result += to_string(count) + say;
                say = prev[i];
                count = 1;
            }
        }
        
        result += to_string(count) + say;
        
        return result;
    }
};
