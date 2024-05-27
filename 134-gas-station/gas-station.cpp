class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int totalGas = 0, totalCost = 0, tank = 0, start = 0;
        
        for (int i = 0; i < gas.size(); ++i) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            
            // If tank is negative, it means we cannot reach the next station from the current start.
            if (tank < 0) {
                start = i + 1; // Reset the starting point to the next station.
                tank = 0; // Reset the tank.
            }
        }
        
        // If total gas is greater than or equal to total cost, return start; otherwise, return -1.
        return totalGas >= totalCost ? start : -1;
    }
};