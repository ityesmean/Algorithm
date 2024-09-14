class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (array[i] == numbers[j]) {
                    array[i] = 0;
                    break;
                }
            }
        }
        
         for (int i = 0; i < array.length; i++) {
            answer += array[i];   
         }
        
        return answer;
    }
}