class Solution {
    public String solution(String s) {
        String answer = "";
        
        if (s.length() % 2 != 0) {
            int i = s.length() / 2;
            answer = s.substring(i, i+1);
        } else {
            int i = s.length() / 2 - 1;
            answer = s.substring(i, i+2);
        }
        
        return answer;
    }
}