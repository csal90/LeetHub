class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        
        int[] indegree = new int[numCourses];
        for(int[] edge : prerequisites) {
            int a = edge[0];
            int b = edge[1];
            graph[a].add(b);
            indegree[b]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int c : graph[current]) {
                indegree[c]--;
                if (indegree[c] == 0) {
                    queue.add(c);
                }
            }
            numCourses--;
        }
        
        return numCourses == 0;
    }
}