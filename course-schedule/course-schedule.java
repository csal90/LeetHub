class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*
             ** TOPOLOGICAL SORTING ** 
            Keep track of nodes indegree
            if at the end all nodes indegree equal 0, then we have a DAG,
            which means the course schedule can be finished.    
        */
        int[] indegree = new int[numCourses];
        
        // Indegree - how many prerequisites are needed
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++; 
        }
                
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        // How many course don't need prerequisites
        int count = queue.size();
        
        // BFS
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == curr) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        count++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        
        return (count == numCourses);
    }
}