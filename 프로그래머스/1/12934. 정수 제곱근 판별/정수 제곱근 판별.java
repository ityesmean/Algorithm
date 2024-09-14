class Solution {
    public long solution(long n) {
        long answer = 0;
        
        double sqrt = (double) Math.sqrt(n);
        
         if (sqrt % 1 != 0) {
            answer = -1;
        } else { 
            answer = (long) Math.pow((sqrt+1), 2);
        }
        
        return answer;
    }
}