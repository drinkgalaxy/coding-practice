class Solution {
    public int solution(int chicken) {
        int service = 0;
        
        while (chicken >= 10) {
            int newService = chicken / 10;
            service += newService;
            chicken = chicken % 10 + newService;
        }
        
        return service;
    }
}
