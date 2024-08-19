class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        for (int[] querie : queries) {
            int s = querie[0];
            int e = querie[1];
            
            for (int i = s; i <= e; i++) {
                arr[i]++;
            }
        }
        return arr;
    }
}