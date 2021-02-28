class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        
        
        for (int i = 0; i < numCourses; i++) { // add an empty arraylist for each numCourses
            graph[i] = new ArrayList();
        }
        
        for (int[] e : prerequisites) {
            int a = e[0];
            int b = e[1];
            graph[a].add(b); // build our graph 
            indegree[b]++; // calculate the indegree of b since we are adding a link to it 
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result.add(course);
            numCourses--;
            for (int c : graph[course]) {
                indegree[c]--;
                if (indegree[c] == 0) {
                    queue.add(c);
                }
            }
        }
        
        Collections.reverse(result);
        int[] arr = result.stream().mapToInt(i -> i).toArray();
        return (numCourses == 0) ? arr : new int[]{};
    }
}