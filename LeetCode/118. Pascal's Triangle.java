class Solution {
    public List<List<Integer>> generate(int numRows) {
        // 1. 반환할 list 생성
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }

        // 2. 첫 번째 행 추가
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        // 3. 두 번째 행 부터 반복 추가
        for (int i = 1; i < numRows; i++) {
            List<Integer> preRow = result.get(i-1);
            List<Integer> row = new ArrayList<>();

            // 각 행의 첫 번째 원소는 1
            row.add(1);

            // 이전 행의 값을 이용해 중간 값 계산
            for (int j = 1; j < i; j++) {
                row.add(preRow.get(j-1) + preRow.get(j));
            }

            // 각 행의 마지막 원소는 1
            row.add(1);

            // 4. 모든 row 리스트 result에 추가하기
            result.add(row);
        }
        
        return result;
    }
}
