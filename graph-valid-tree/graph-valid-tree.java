class Solution {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> seen = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false; 
        
        // MAKE ADJACENCY LIST
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        dfs(0);
        
        return seen.size() == n;
    }
    
    public void dfs(int node) {
        if (seen.contains(node)) {
            return;
        } else {
            seen.add(node);
        }
        for (int neighbour : graph.get(node)) {
            dfs(neighbour);
        }
    }
    
}