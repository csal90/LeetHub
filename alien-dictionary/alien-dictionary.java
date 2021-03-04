class Solution {
    public String alienOrder(String[] words) {
        int[] indegree = new int[26];
        Map<Character, List<Character>> graph = new HashMap<>();
        
        // Build our graph (each node is a char w/ an empty array list)
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.put(c, new ArrayList());
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String start = words[i];
            String end = words[i + 1];
            if (start.length() > end.length() && start.startsWith(end)) {
                return "";
            }
            int len = Math.min(start.length(), end.length());
            for (int j = 0; j < len; j++) {
                char out = start.charAt(j);
                char in = end.charAt(j);
                if (out != in)  {
                    graph.get(out).add(in);
                    indegree[(int) in - 'a']++; 
                    break;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for (char c : graph.keySet()) {
            if (indegree[c - 'a'] == 0) {
                q.add(c);
            }
        }
        
        while (!q.isEmpty()) {
            char out = q.poll();
            sb.append(out);
            for (char c : graph.get(out)) {
                indegree[c - 'a']--;
                if (indegree[c - 'a'] == 0) {
                    q.add(c);
                }
            }
        }
        
        return sb.length() == graph.size() ? sb.toString() : "";
    }
}