class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);
            
            maxWidth = Math.max(max, maxWidth);
            maxHeight = Math.max(min, maxHeight);
        }
        
        
        return maxWidth * maxHeight;
    }
}