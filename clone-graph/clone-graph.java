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
​
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        // save visited nodes and it's clone
        HashMap<Node, Node> visited = new HashMap();
        
        // put first element into the queue
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        
        // clone the node and put it in the hashmap
        visited.put(node, new Node(node.val, new ArrayList()));
        
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            for (Node neighbor: n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    queue.add(neighbor);
                }
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        
        return visited.get(node);
    }
}
