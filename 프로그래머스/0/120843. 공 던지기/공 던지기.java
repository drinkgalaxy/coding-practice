class Solution {
    public int solution(int[] numbers, int k) {
        int n = numbers.length;
        int index = 0;
        
        // k번째로 던지는 사람의 인덱스를 계산
        index = (2 * (k - 1)) % n;
        
        return numbers[index];
    }
}