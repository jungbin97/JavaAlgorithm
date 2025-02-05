import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] numCount = new int[10];
        
        // 다솜이 방번호
        int N = sc.nextInt();
        
        while (N > 0) {
            // 뒷번호부터 탐색
            
            // 9또는 6이면
            if (N%10 == 6 || N%10 == 9) {
                // 숫자 작은 쪽에 넣기
                if (numCount[9] <= numCount[6]) {
                    numCount[9]++;
                } else {
                    numCount[6]++;
                }
            } else {
                numCount[N%10]++;
            }
            N = N/10;
        }
        

        // 최댓값이 세트 수
        int maxCount = 0;
        for (int count : numCount) {
            if (count > maxCount) {
                maxCount = count;
            }
        }
        
        System.out.println(maxCount);
    }
}


