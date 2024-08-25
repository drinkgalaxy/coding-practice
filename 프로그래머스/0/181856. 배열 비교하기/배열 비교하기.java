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
            int as = sumArr(a);
            int bs = sumArr(b);
            return (as < bs) ? -1 : (as > bs) ? 1 : 0;
        }
    }
    
    public int sumArr (int[] n) {
        int s = 0;
        for (int i : n) {
            s += i;
        }
        return s;
    }
}