class Solution {
    public int solution(String message) {
        int count = 0;
        for (String s : message.split("")) {
            count += 2;
        }
        return count;
    }
}