class Solution {
    public int solution(String my_string) {
        int answer = 0;
        my_string = my_string.replaceAll("[^0-9]", "-");
        for (String s : my_string.split("-")) {
            if (!s.equals("")) {
                answer += Integer.parseInt(s);
            }
        }
        System.out.println(my_string);
        return answer;
    }
}