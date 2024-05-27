
class Solution {
public:
    unordered_map<Node*, Node*> visited;
    
    Node* cloneGraph(Node* node) {
        if (!node) {
            return nullptr;
        }
        
        // If the node was already cloned, return the cloned node.
        if (visited.find(node) != visited.end()) {
            return visited[node];
        }
        
        // Clone the node.
        Node* cloneNode = new Node(node->val);
        visited[node] = cloneNode;
        
        // Iterate through the neighbors to clone them.
        for (Node* neighbor : node->neighbors) {
            cloneNode->neighbors.push_back(cloneGraph(neighbor));
        }
        
        return cloneNode;
    }
};