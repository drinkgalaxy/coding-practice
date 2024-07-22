class Solution {
    public int solution(int a, int b) {
        int findB = b / GCD(a, b);
        
        while (findB != 1) {
            if (findB % 2 == 0) {
                findB /= 2;
            } else if (findB % 5 == 0) {
                findB /= 5;
            } else {
                return 2;
            }
        }
        return 1;
    }
    
    int GCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }
}