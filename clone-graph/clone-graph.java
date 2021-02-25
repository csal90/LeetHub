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
        Algorithm idea:
        - Clone as we go
        - Use a hashmap that will contain a key for our original graph 
          and a value for our cloned graph 
        - Create a copy for the given node we are on and clone all of it's neighbors 
        - Append the neighbors to our clonedNode ArrayList 
        - return clonedNode 
        
    */
    HashMap<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        
        Node clonedNode = new Node(node.val, new ArrayList());
        
        visited.put(node, clonedNode);
        for (Node neighbor : node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(neighbor));
        }
        
        return clonedNode;
    }
}