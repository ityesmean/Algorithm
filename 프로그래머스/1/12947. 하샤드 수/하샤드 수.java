class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        // 1 <= x <= 10000
        
        String str = String.valueOf(x);
        
        int total = 0; // 자릿수의 합
        
        for (int i = 0; i < str.length(); i++) {
            total += Integer.parseInt(str.substring(i, i+1));
        }
        
        if (x % total != 0) {
            answer = false;
        }
        
        return answer;
    }
}