class Solution {
    public int[] solution(String[] wallpaper) {
        // 정답 배열에 시작점, 종료점 값 초기화
        int[] answer = {
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MIN_VALUE,
            Integer.MIN_VALUE
        };
        
         // # 을 탐색하면서 가장 작은 시작점, 가장 큰 종료점 정하기
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    answer[0] = Math.min(i, answer[0]);
                    answer[1] = Math.min(j, answer[1]);
                    answer[2] = Math.max(i+1, answer[2]);
                    answer[3] = Math.max(j+1, answer[3]);
                }
            }
        }
    
        return answer;
    }
}