import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] answer) {
        
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int total1 = 0;
        int total2 = 0;
        int total3 = 0;
        
        for (int i = 0; i < answer.length; i++) {
            // 1번
            int num1 = (i+1) % arr1.length -1;
            if (num1 < 0) {
                num1 = arr1.length - 1;
            }
            if (answer[i] == arr1[num1]) {
                total1++;
            }
            
            // 2번
            int num2 = (i+1) % arr2.length -1;
            if (num2 < 0) {
                num2 = arr2.length - 1;
            }
            if (answer[i] == arr2[num2]) {
                total2++;
            }
            
            // 3번
            int num3 = (i+1) % arr3.length -1;
            if (num3 < 0) {
                num3 = arr3.length - 1;
            }
            if (answer[i] == arr3[num3]) {
                total3++;
            }
        }
        
        // 오름차순
        int max = 0;
        max = Math.max(total1, total2);
        max = Math.max(max, total3);
        
        //int[] answers = new int[3];
        ArrayList<Integer> answers = new ArrayList<Integer>();
        
        //int count = 0;
        if (max == total1) {
            answers.add(1);
        } 
        if (max == total2) {
            answers.add(2);
        } 
        if (max == total3) {
            answers.add(3);
        }
        
        return answers;
    }
}