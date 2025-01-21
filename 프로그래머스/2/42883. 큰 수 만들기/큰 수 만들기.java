import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        char[] array = number.toCharArray();
        
        // 구해야하는 문자 길이
        int len = array.length - k;
        
        int start = 0;
        for (int i = 0; i < len; i++) {
            char max = '0';
            
            for (int j = start; j <= i + k; j++) {
                // 가장 큰수 고르기, 그 다음 인덱스 시작 인덱스
                if (array[j] > max) {
                    max = array[j];
                    start = j+1;
                }
            }
            sb.append(max);
        }
        
        return sb.toString();
    }
}

// 그리디 하기 풀기