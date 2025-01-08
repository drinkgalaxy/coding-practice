import java.util.*;
class Solution {
    static Map<Character, Integer> map = new HashMap<>();
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        
         // 모든 유형의 키를 미리 초기화 
        char[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        Arrays.sort(types);
        for (char t : types) {
            map.put(t, 0);
        }
        
        for (int i = 0; i < survey.length; i++) {
            saveScore(survey[i].charAt(0), survey[i].charAt(1), choices[i]);
        }
        
        char[][] indicators = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        
        for (char[] pair : indicators) {
            if (compare(map.get(pair[0]), map.get(pair[1]))) {
                sb.append(pair[0]);
            } else {
                sb.append(pair[1]);
            }
        }
        
        return sb.toString();
    }
    
    public static void saveScore(char type1, char type2, Integer score) {
        if (score == 1) {
            saveMap(type1, 3);
        } else if (score == 2) {
            saveMap(type1, 2);
        } else if (score == 3) {
            saveMap(type1, 1);
        } else if (score == 5) {
            saveMap(type2, 1);
        } else if (score == 6) {
            saveMap(type2, 2);
        } else if (score == 7) {
            saveMap(type2, 3);
        }
    }
    
    public static void saveMap(char type, Integer plus) {
        map.put(type, map.get(type) + plus);
    }
    
    public static boolean compare(Integer type1, Integer type2) {
        if (type1 >= type2) {
            return true;
        } else {
            return false;
        }
    }
}