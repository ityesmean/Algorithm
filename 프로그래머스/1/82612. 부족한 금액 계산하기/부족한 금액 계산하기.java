class Solution {
    public long solution(int price, int money, int count) {
        long answer = money;
        
        int m = price;
        
        for (int i = 0; i < count; i++) {
            answer -= m;
            
            m += price;
        }
        
        if (answer >= 0) {
            answer = 0;
        } else {
            answer = -1 * answer;
        }

        return answer;
    }
}