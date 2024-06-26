class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int result = 0;
        int tempMax;
        for (int i = 0; i < grid[0].length; i++) {
            tempMax = 0;
            for (int[] row : grid) {
                Arrays.sort(row);
                tempMax = Math.max(tempMax, row[row.length - 1]);
                row[row.length - 1] = 0; // 현재 행의 최댓값 제거 -> 다음 반복에서 고려하지 않도록
            }
            result += tempMax;
        }
        return result;
    }
}
