import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        Arrays.sort(array);
        // 배열의 최대 값 구하기
        int topValue = array[array.length - 1];
        int[] visited = new int[topValue + 1];
        
        // 배열을 돌면서 방문 배열에 값 ++
        for (int i = 0; i < array.length; i++) {
            visited[array[i]] ++;
        }
        
        // 배열의 최대값 구하기. 만약 최대값이 여러 개면 -1
        int top = visited[0];
        for (int i = 1; i < visited.length; i++) {
            if (top < visited[i]) {
                top = visited[i];
                answer = i;
            } else if (top == visited[i]) {
                answer = -1;
            }
        }
        return answer;
    }
}