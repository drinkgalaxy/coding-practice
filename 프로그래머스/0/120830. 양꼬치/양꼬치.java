class Solution {
    public int solution(int n, int k) {
        int price = 0;
        price = (n * 12000) + (k * 2000);
        if (n / 10 > 0) {
            price -= (n / 10) * 2000;
        }
        return price;
    }   
}