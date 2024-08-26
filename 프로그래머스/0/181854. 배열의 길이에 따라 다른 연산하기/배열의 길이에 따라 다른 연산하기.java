class Solution {
    public int[] solution(int[] arr, int n) {
        return sumArr(arr, n, arr.length % 2);
    }
    
    public int[] sumArr(int[] arr, int n, int r) {
        if (r == 1) {
            for (int i = 0; i < arr.length; i += 2) {
                arr[i] += n;
            }
            return arr;
        } else {
            for (int i = 1; i < arr.length; i += 2) {
                arr[i] += n;
            }
            return arr;
        }
    }
}