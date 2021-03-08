class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] edge : prerequisites) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            indegree[b]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        while (!q.isEmpty()) {
            int course = q.poll();
            numCourses--;
            for (Integer c : graph.get(course)) {
                indegree[c]--;
                if (indegree[c] == 0) {
                    q.add(c);
                }
            }
        }
        
        return numCourses == 0;
    }
}