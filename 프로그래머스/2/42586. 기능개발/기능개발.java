import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        int[] answer = new int[speeds.length];
        
        for (int i = 0; i < progresses.length; i++) {
            answer[i] = (100 - progresses[i]) / speeds[i];
            
            if (((100 - progresses[i]) % speeds[i]) > 0) {
                answer[i] += 1;
            }
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        int cnt = 1;
        int total = answer[0];
        for (int i = 0; i < answer.length-1; i++) {
            if (total >= answer[i+1]) {
                cnt++;
            } else {
                total = answer[i+1];
                list.add(cnt);
                cnt = 1;
            }
        }
        list.add(cnt);
        
        
        return list;
    }
}