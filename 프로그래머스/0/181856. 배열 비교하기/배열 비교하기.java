class Solution {
    public int solution(int[] arr1, int[] arr2) {
        
        return compare(arr1, arr2);
    }
    
    public int compare(int[] a, int[] b) {
        int al = a.length;
        int bl = b.length;

        if (al != bl) {
            return (al < bl) ? -1 : 1;
        } else {
            int as = 0;
            int bs = 0;
            for (int i : a) {
                as += i;
            }
            for (int i : b) {
                bs += i;
            }
            if (as < bs) {
                return -1;
            } else if (as > bs) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}