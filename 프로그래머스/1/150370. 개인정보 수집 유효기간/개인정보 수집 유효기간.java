import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        
        // 번호에 맞는 기간 저장
        Map<String, Integer> data = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] arr = new String[terms.length * 2];
            int idx = 0;
            for (String term : terms[i].split(" ")) {
                arr[idx++] = term;
            }
            data.put(arr[0], Integer.parseInt(arr[1]));
        }
        
        // 주어진 날짜들의 번호 구하기
        for (int i = 0; i < privacies.length; i++) {
            String[] parr = new String[privacies.length * 2];
            int idx = 0;
            for (String privacie : privacies[i].split(" ")) {
                parr[idx++] = privacie;
            }
            // 해당 번호에 맞는 개월 수 더하기
            int month = Integer.valueOf(parr[0].substring(5, 7)) + data.get(parr[1]);
            int year = year = Integer.valueOf(parr[0].substring(0, 4));
            if (month >= 13) {
                int time = month / 12;
                month = month % 12;
                year = year + time;
                
                if (month == 0) {
                    month = 12;
                    year -= 1;
                }
            }
            int day = Integer.valueOf(parr[0].substring(8, 10));
            
            int nowYear = Integer.valueOf(today.substring(0, 4));
            int nowMonth = Integer.valueOf(today.substring(5, 7));
            int nowDay = Integer.valueOf(today.substring(8, 10));
            
            // 현재 날짜 이전이면 리스트에 넣기
            if (year < nowYear) {
                list.add(i+1);
                continue;
            } else if (year == nowYear) {
                if (month < nowMonth) {
                    list.add(i+1);
                    continue;
                } else if (month == nowMonth) {
                    if (day < nowDay) {
                        list.add(i+1);
                        continue;
                    } else if (day == nowDay) {
                        list.add(i+1);
                        continue;
                    }
                }
            }

        }
        
        int[] answer = new int[list.size()];
        int index = 0;
        for (Integer i : list) {
            answer[index++] = i;
        }
        return answer;
    }
}