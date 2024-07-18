class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0, 0};
        int maxWidth = board[0] / 2;
        int maxHeight = board[1] / 2;
        System.out.println("maxWidth = "+ maxWidth);
        System.out.println("maxHeight = "+ maxHeight);
        
        for (String s : keyinput) {
            if (s.equals("up") && answer[1] < maxHeight ) {
                answer[1]++;
            } else if (s.equals("down") && answer[1] > -maxHeight) {
                answer[1]--;
            } else if (s.equals("left") && answer[0] > -maxWidth) {
                answer[0]--;
            } else if (s.equals("right") && answer[0] < maxWidth) {
                answer[0]++;
            }
        }
        return answer;
    }
}