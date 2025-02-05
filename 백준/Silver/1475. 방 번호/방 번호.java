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
            numCount[N%10]++;
            N = N/10;
        }
        

        // 최댓값이 세트 수
        int maxCount = 0;
        for (int i = 0; i < numCount.length; i++)  {
            if (i == 6 || i == 9) continue;
            maxCount = Math.max(maxCount, numCount[i]);
            
        }
        
        // (numCount[6]+numCount[9])/2를 올림한 값이 6, 9에 대한 세트 수=> (numCount[6]+numCount[9]+1) / 2 
        maxCount = Math.max(maxCount, (numCount[6]+numCount[9]+1)/2);
        System.out.println(maxCount);
    }
}


