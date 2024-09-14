class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        int x = 0;
        int y = 0;
        
        if (a > b) {
            x = a;
            y = b;
        } else if (a < b) {
            x = b;
            y = a;
        } else if (a == b) {
            answer = a;
            return answer;
        }
        
        for (int i = y; i <= x; i++) {
            answer += i;
        }
        
        return answer;
    }
}