class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : operations) {
            if (s.equals("C")) {
                stack.pop();
            } else if (s.equals("D")) {
                int pre = stack.peek();
                stack.push(2 * pre);
            } else if (s.equals("+")) {
                int pre = stack.pop();
                int prepre = stack.peek();
                stack.push(pre);
                stack.push(pre + prepre);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        int result = 0;
        for (Integer i : stack) {
            result += i;
        }
        return result;
    }
}
