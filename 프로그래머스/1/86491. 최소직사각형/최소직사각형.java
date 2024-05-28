import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            // 명함의 가로 길이와 세로 길이를 비교하고, 더 큰 값을 가로길이로, 더 작은 값을 세로길이로 선택
            int width = Math.max(sizes[i][0], sizes[i][1]);
            int height = Math.min(sizes[i][0], sizes[i][1]);
            
            if (width > maxWidth) {
                maxWidth = width;
            }
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        return maxWidth * maxHeight;
        
    }
}