import java.util.*;

class Solution {
    public int solution(String t, String p) {
        List<String> strList = new ArrayList<>();
        List<Long> longList = new ArrayList<>();
        int pLength = p.length();
        long pLong = Long.valueOf(p);
        
        // t를 String list로 저장
        for (String str : t.split("")) {
            strList.add(str);
        }
        // String list로부터 값을 p.length 만큼씩 가져와서 더하고 Integer list로 새로 저장
        for (int i = 0; i <= strList.size() - pLength; i++) {
            longList.add(Long.valueOf(strJoin(strList, i, pLength)));
        }
        
        int answer = 0;
        // Integer list랑 p랑 비교 후 작거나 같으면 answer++
        for (int i = 0; i < longList.size(); i++) {
            if (longList.get(i) <= pLong) {
                answer++;
            }
        }

        return answer;
    }
    
    public static String strJoin(List<String> strList, int index, int repeat) {
        String newString = "";
        for (int i = 0; i < repeat; i++) {
            newString += strList.get(index+i);
        }

        return newString;
    }
}