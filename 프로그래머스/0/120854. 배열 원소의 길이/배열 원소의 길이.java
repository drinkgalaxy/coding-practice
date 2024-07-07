class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        int index = 0;
        for (String s : strlist) {
            answer[index] = s.length();
            index++;
        }
        return answer;
    }
}