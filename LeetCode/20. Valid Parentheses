class Solution {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for (String str : s.split("")) {
            if (str.equals("(") | str.equals("{") | str.equals("[")) {
                stack.push(str);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (str.equals(")")) {
                    if (stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        stack.push(str);
                    }
                } else if (str.equals("}")) {
                    if (stack.peek().equals("{")) {
                        stack.pop();
                    } else {
                        stack.push(str);
                    }
                } else if (str.equals("]")) {
                    if (stack.peek().equals("[")) {
                        stack.pop();
                    } else {
                        stack.push(str);
                    }
                }
            } 
        }
        if (stack.isEmpty()) {
                return true;
            } else {
                return false;
            }
    }
}
