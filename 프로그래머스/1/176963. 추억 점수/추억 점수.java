import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 1. 이름별 그리움 점수를 저장하는 HashMap 생성
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        // 2. 사진별 추억 점수 계산
        int[] answer = new int[photo.length];

        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (String person : photo[i]) {
                sum += map.getOrDefault(person, 0); // 그리움 점수가 없으면 0
            }
            answer[i] = sum;
        }

        return answer;
    }
}
