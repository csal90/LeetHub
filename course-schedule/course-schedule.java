class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++; // Indegree - how many prerequisites are needed
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        // How many course don't need prerequisites
        int canFinish = queue.size();
        while (!queue.isEmpty()) {
            int prerequisite = queue.remove();
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == prerequisite) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        canFinish++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        
        return (canFinish == numCourses);
    }
}