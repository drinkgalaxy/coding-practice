class Solution {
    public int[] finalPrices(int[] prices) {
        // j > i, 처음 만난  prices[j] <= prices[i] 일 때 원래 가격 - 할인 가격 계산된 값을 배열에 저장
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return prices;
    }
}
