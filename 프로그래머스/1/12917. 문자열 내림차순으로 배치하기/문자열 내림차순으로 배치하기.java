import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] arr = new String[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.substring(i, i+1);
        }
        
        Arrays.sort(arr, Collections.reverseOrder());
        
        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }
        
        return answer;
    }
}