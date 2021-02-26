/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        /*
            Clone as you go
            Global hashtable k,v pair <Node, Node> 
                                        OG , CLONE
            recursion to recursively keep created cloned nodes
            and iterating through them and adding them to the nodes adj. list         
        */
        if (node == null) {
            return node; 
        }
        
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        
        // Main DFS 
        Node clone = new Node(node.val, new ArrayList());
        visited.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        
        return clone;
    }
}