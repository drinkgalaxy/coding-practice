import java.util.*;
class Solution {
    static Map<Character, Integer> map = new HashMap<>();
    public String solution(String[] survey, int[] choices) {
        
        char[] types = {'R', 'T', 'C', 'F', 'J', 'F', 'J', 'M', 'A', 'N'};
        for (char t : types) {
            map.put(t, 0);
        }
        
        for (int i = 0; i < survey.length; i++) {
            saveScore(survey[i].charAt(0), survey[i].charAt(1), choices[i]);
        }
        
        char[][] arr = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            result.append(compare(arr[i][0], arr[i][1]));
        }
    
        return result.toString();
    }
    
    private static Character compare(char type1, char type2) {
        if (map.get(type1) < map.get(type2)) {
            return type2;
        } else if (map.get(type1) > map.get(type2)) {
            return type1;
        } else {
            return type1;
        }
    }
    
    private static void saveScore(char type1, char type2, int choice) {
        if (choice == 1) {
            saveMap(type1, 3);
        } else if (choice == 2) {
            saveMap(type1, 2);
        } else if (choice == 3) {
            saveMap(type1, 1);
        } else if (choice == 5) {
            saveMap(type2, 1);
        } else if (choice == 6) {
            saveMap(type2, 2);
        } else if (choice == 7) {
            saveMap(type2, 3);
        }
    }
    
    private static void saveMap(char type, int score) {
        map.put(type, map.get(type) + score);
    }
}