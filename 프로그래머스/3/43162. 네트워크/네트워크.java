class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];
        
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                answer++; // 연결 안 한 노드가 더 있다는 것이므로 answer 개수 ++
                dfs(i, computers, visited);
            }
        }
        return answer;
    }
    
    public static void dfs(int node, int[][] computers, boolean[] visited) {
        visited[node] = true;
        for (int i = 0; i < computers.length; i++) {
            if (visited[i] == false && computers[node][i] == 1) {
                // 방문하지 않았고, 1로 표현된 연결된 노드가 있다면 탐색
                dfs(i, computers, visited);
            }
        }
    }
}