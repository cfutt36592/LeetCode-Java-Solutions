class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        
        for(int i = 0; i<numCourses; i++)
            map.put(i, new HashSet<>());
        
        for(int[] pre: prerequisites)
            map.get(pre[0]).add(pre[1]);
        
        int[] visited = new int[numCourses];
        
        for(int i = 0; i<numCourses; i++)
            if(visited[i] == 0 && !dfs(map, visited, i)) return false;
        
        return true;
    }
    
    public boolean dfs(HashMap<Integer, Set<Integer>> map, int[] visited, int v){
        if(visited[v] == 1) return false;
        if(visited[v] == 2) return true;
        
        visited[v] = 1;
        
        for(int ad: map.get(v))
            if(!dfs(map, visited, ad)) return false;
        
        visited[v] = 2; 
        
        return true;
    }
}
