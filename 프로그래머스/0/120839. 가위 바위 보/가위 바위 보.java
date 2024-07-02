class Solution {
    public String solution(String rsp) {
        String answer = "";
        // 가위 2, 바위 0, 보 5
        for (String s : rsp.split("")) {
            if (s.equals("2")) { // 가위이면 바위가 이김
                answer += "0";
            } else if (s.equals("0")) { // 바위이면 보가 이김
                answer += "5";
            } else { // 보면 가위가 이김
                answer += "2";                
            }
        }
        return answer;
    }
}