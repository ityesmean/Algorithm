import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] arr = s.split(" ");
        
        int[] array = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            array[i] = Integer.parseInt(arr[i]);
        }
        
        Arrays.sort(array);
        
        answer = array[0] + " " + array[array.length - 1];
        
        return answer;
    }
}