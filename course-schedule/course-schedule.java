class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++) {
            int src = prerequisites[i][1];
            int dest = prerequisites[i][0];
            
            List<Integer> lst = graph.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            
            graph.put(src, lst);
            indegree[dest]++; // increase the indegree for dest. node 
        }
                
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            numCourses--;
            if (graph.containsKey(node)) {
                for (Integer neighbor : graph.get(node)) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        
        return numCourses == 0;
    }
}