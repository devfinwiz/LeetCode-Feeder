class Solution {
public:
    vector<int> grayCode(int n) {
        vector<int> result;
        int num_elements = 1 << n; // 2^n elements
        result.reserve(num_elements);
        
        for (int i = 0; i < num_elements; ++i) {
            result.push_back(i ^ (i >> 1));
        }
        
        return result;
    }
};