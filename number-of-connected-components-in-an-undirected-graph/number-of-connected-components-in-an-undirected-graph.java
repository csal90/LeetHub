class Solution {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    public int countComponents(int n, int[][] edges) {
        // BUILD ADJACENCY GRAPH 
        int components = 0;
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(visited.add(i)){
                components++;
                dfs(i, visited);
            }
        }
        return components;
    }
    private void dfs(int index, Set<Integer> visited) {
        for(Integer node: graph.get(index))
            if(visited.add(node)) dfs(node, visited);
    }
}