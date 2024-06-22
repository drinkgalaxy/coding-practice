class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int answer = 0;
        Queue<Integer> stQueue = new ArrayDeque<>();
        // 학생을 큐에 넣기
        for (Integer st : students) {
            stQueue.offer(st);
        }
        Queue<Integer> swQueue = new ArrayDeque<>();
        // 샌드위치를 큐에 넣기
        for (Integer sw : sandwiches) {
            swQueue.offer(sw);
        }

        while (!stQueue.isEmpty()) {
            // 종료조건
            if (!stQueue.contains(swQueue.peek())) {
                return stQueue.size();
            }
            if (stQueue.peek() == swQueue.peek()) {
                stQueue.poll();
                swQueue.poll();
            } else {
                int poll = stQueue.poll();
                stQueue.offer(poll);
            }
        }
        return answer;
    }
}
