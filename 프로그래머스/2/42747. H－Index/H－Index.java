class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        // 정렬된 배열을 순회하면서, 각 논문의 인용 횟수와 해당 인용 횟수보다 많은 논문의 수를 비교합니다.
    
        for(int i=0; i<citations.length; i++){
            int smaller = Math.min(citations[i], citations.length-i);
            answer = Math.max(answer, smaller);
        }
        return answer;
    }
}
