import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int s = 0; s < commands.length; s++) {
            int result = 0;
            int i = commands[s][0];
            int j = commands[s][1];
            int k = commands[s][2];
            
            int[] newArray = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(newArray);
            
            result = newArray[k-1];
            answer[s] = result;
        }
        
        
        return answer;
    }
}


// i ~ j번째 까지 자르고 정렬 했을 떄 k 번쨰 구하기