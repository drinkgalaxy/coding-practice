import java.util.*;

class Solution {
    public String solution(String letter) {
        Map<String, String> map = new HashMap<>();
    
        // Morse Code 데이터를 배열로 정의
        String[][] morseArray = {
            {".-", "a"}, {"-...", "b"}, {"-.-.", "c"}, {"-..", "d"}, {".", "e"}, {"..-.", "f"},
            {"--.", "g"}, {"....", "h"}, {"..", "i"}, {".---", "j"}, {"-.-", "k"}, {".-..", "l"},
            {"--", "m"}, {"-.", "n"}, {"---", "o"}, {".--.", "p"}, {"--.-", "q"}, {".-.", "r"},
            {"...", "s"}, {"-", "t"}, {"..-", "u"}, {"...-", "v"}, {".--", "w"}, {"-..-", "x"},
            {"-.--", "y"}, {"--..", "z"}
        };
        
        for (String[] morse : morseArray) {
            map.put(morse[0], morse[1]);
        }
        
        String answer ="";
        for (String s : letter.split(" ")) {
            answer += map.get(s);
        }
        return answer;
    }
}