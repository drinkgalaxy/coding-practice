class Solution {
    public boolean divisorGame(int n) {
        // 짝수면 Alice가 이기고 홀수면 Bob이 이김
        // if ((n % 2) == 0) {
        //     return true;
        // } else {
        //     return false;
        // }
        return n % 2 == 0;
    }
}
