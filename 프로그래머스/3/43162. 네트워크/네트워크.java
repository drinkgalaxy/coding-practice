class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];
        
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                answer++; // 아직 방문하지 않은 노드가 있으므로 네트워크 개수를 증가시킴
                dfs(i, computers, visited);
            }
        }
        return answer;
    }
    
    public static void dfs(int node, int[][] computers, boolean[] visited) {
        visited[node] = true; // 현재 노드를 방문 처리
        for (int i = 0; i < computers.length; i++) {
            if (visited[i] == false && computers[node][i] == 1) {
                // 방문하지 않았고, 현재 노드와 연결된 노드가 있다면 DFS 탐색
                dfs(i, computers, visited);
            }
        }
    }
}