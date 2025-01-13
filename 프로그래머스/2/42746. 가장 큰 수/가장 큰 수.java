import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int n = numbers.length;
        
        String[] stringNumber = new String[n];
        // 문자열로 변환
        for (int i = 0; i < n; i++) {
            stringNumber[i] = Integer.toString(numbers[i]);
        }
        
        // 내림차순 정렬
        Arrays.sort(stringNumber, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        
       	answer = String.join("", stringNumber);
        
        // 모든 숫자가 0인경우
        if (answer.startsWith("0")) {
            return "0";
        }
        
        return answer;
    }
}


