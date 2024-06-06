class Solution {
    public int[] countBits(int n) {
        // 1. 배열 생성하기
        int[] result = new int[n+1];

        // 2. i가 짝수이면 끝에 0이 오기 때문에 result[i/2]로 구함
        // i가 홀수이면 끝에 1이 오기 때문에 result[i] = result[i-1]+1로 구함
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                result[i] = result[i / 2];
            } else {
                result[i] = result[i - 1] + 1;
            }
        }
                                      
        return result;
    }
}
