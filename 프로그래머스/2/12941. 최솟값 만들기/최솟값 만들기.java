import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        
        int num = A.length-1;
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[num];
            num--;
        }

        return answer;
    }
}