import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i])
                min = arr[i];
        }
        
        if (arr.length == 1) {
            answer.add(-1);
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != min) {
                    answer.add(arr[i]);
                }
            }
        }
        
        
        return answer;
    }
}