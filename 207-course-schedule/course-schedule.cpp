class Solution {
public:
    bool canFinish(int numCourses, std::vector<std::vector<int>>& prerequisites) {
        // Create an adjacency list for the graph
        std::vector<std::vector<int>> adjList(numCourses);
        // Create a vector to track the in-degree (number of incoming edges) for each node
        std::vector<int> inDegree(numCourses, 0);
        
        // Build the graph
        for (const auto& pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            adjList[prereq].push_back(course);
            inDegree[course]++;
        }
        
        // Create a queue and enqueue all nodes with in-degree 0
        std::queue<int> q;
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0) {
                q.push(i);
            }
        }
        
        // Count of courses that can be taken
        int count = 0;
        
        // Process nodes with in-degree 0
        while (!q.empty()) {
            int curr = q.front();
            q.pop();
            ++count;
            
            // Reduce the in-degree of neighboring nodes
            for (int neighbor : adjList[curr]) {
                if (--inDegree[neighbor] == 0) {
                    q.push(neighbor);
                }
            }
        }
        
        // If count of courses taken is equal to numCourses, return true
        return count == numCourses;
    }
};