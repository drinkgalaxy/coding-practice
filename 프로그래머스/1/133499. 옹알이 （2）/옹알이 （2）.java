import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        String[] arr = {"aya", "ye", "woo", "ma"};
        int answer = 0;

        for (String word : babbling) {
            boolean isValid = true;
            String prev = "";  // 이전 발음을 저장

            while (isValid && word.length() > 0) {
                boolean matched = false;

                for (String sound : arr) {
                    if (word.startsWith(sound)) {
                        if (sound.equals(prev)) { // 같은 발음이 연속되었는지 확인
                            isValid = false;
                            break;
                        }
                        prev = sound;
                        word = word.substring(sound.length()); // 발음 제거
                        matched = true;
                        break;
                    }
                }

                if (!matched) { // 어떤 발음에도 매칭되지 않으면 종료
                    isValid = false;
                }
            }

            if (isValid && word.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}
