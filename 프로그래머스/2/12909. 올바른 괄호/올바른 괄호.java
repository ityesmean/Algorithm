import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Queue<String> q = new LinkedList<String>();

        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i+1).equals("(")) {
                q.add("(");
            } else {
                if (q.size() == 0) {
                    return false;
                }
                
                q.poll();
            }
        }
        
        if (q.isEmpty()) {
            return true;
        } else {
            return false;
        }
        
    }
}