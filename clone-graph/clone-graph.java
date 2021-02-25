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
    /*
        - Use a global hashmap
        - Iterate over each node 
        - Clone each node (aka create a new Node variable with it's value)
        - Add visited.add(Node, ClonedNode)
        - Iterate over Node's neighbors
        - Recursively add it's neighbors. (All which will be cloned)
        
    */
    private HashMap <Node, Node> visited = new HashMap <> ();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        
        // Node has been visisted before. Return the clone from visited
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        
        // Create clone for given node, add it to visited (KEY (OG GRAPH), VALUE (CLONED GRAPH))
        Node clonedNode = new Node(node.val, new ArrayList());
        visited.put(node, clonedNode);
        
        // Iterate through neighbors of node and generate their clones 
        for (Node neighbor : node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(neighbor));
        }
        
        return clonedNode;
    }
}