class Solution {
    public int solution(int[] arr) {
        boolean check = false;
        int answer = 0;
        
        while (!check) {
            check = true; // 초기화, 아래 for문에서 false로 안바뀌면 끝남. 바뀌면 계속됨
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 50 && arr[i] % 2 == 0) {
                    arr[i] /= 2;
                    check = false;

                } else if (arr[i] < 50 && arr[i] % 2 != 0) {
                    arr[i] = arr[i] * 2 + 1;
                    check = false;
                }
            }
            answer++;
        }
        
        
        return answer - 1;
    }
}