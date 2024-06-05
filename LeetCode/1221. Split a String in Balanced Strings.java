class Solution {
    public int balancedStringSplit(String s) {
        // 1. result 배열 생성. 크기는 2. R = result[0], L = result[0] 의 숫자 각각 카운트 해주는 용도
        int[] result = new int[2];
        int count = 0;
        // 2. result 배열에 String split해서 개수 세주기
        for (String str : s.split("")) {
            if (str.equals("R")) {
                result[0]++;
            } else {
                result[1]++;
            }

        // 3. 근데 이때 R과 L의 배열의 값이 같아지는 순간 count++하고 다시 둘 다 0으로 초기화
            if (result[0] == result[1]) {
                count++;
                result[0] = 0;
                result[1] = 0;
            }
        }
        return count;
    }
}
