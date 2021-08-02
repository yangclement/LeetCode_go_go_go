class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //从in-degree为0的courser开始找起
        if (numCourses == 0 || prerequisites == null) {
            return true;
        }
        //先construct这个graph用hashmap和indegree的array
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int[] curr = prerequisites[i];
            indegree[curr[0]]++;
            graph.putIfAbsent(curr[1], new ArrayList<Integer>());
            graph.get(curr[1]).add(curr[0]);
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int taken = 0;
        while (!queue.isEmpty()) {
            int currCourse = queue.remove();
            taken++;
            List<Integer> nextCourses = graph.get(currCourse);
            if (nextCourses == null) {
                continue;
            }
            for (int nextCourse : nextCourses) {
                if (--indegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }
        return taken == numCourses;
    }
}