import java.util.*;

class Solution {
    public String solution(String s) {
        List<Character> charList = new ArrayList<>();
        
        // 문자열 s를 리스트에 저장
        for (int i = 0; i < s.length(); i++) {
            charList.add(s.charAt(i));
        }
        
        // 리스트를 정렬 (기본적으로 사전순 정렬됨)
        Collections.sort(charList, Collections.reverseOrder());
        
        // 정렬된 문자들을 하나의 문자열로 만듦
        StringBuilder sb = new StringBuilder();
        for (char ch : charList) {
            sb.append(ch);
        }
        
        // 문자열로 변환하여 반환
        return sb.toString();
    }
}