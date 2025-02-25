import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int count;
    static int[] arr;
    
    static boolean[] isUsed1 = new boolean[40];
    static boolean[] isUsed2 = new boolean[40];
    static boolean[] isUsed3 = new boolean[40];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        
        func(0);
        System.out.println(count);
    }
    
    static void func(int index) {
        if (index == n) {
            count++;
            return;
        }
        

        // 열에 둘곳 찾기
        for (int i = 0; i < n; i++) {
            if (isUsed1[i] || isUsed2[i+index] || isUsed3[index-i+n-1]) {
                continue;
            }
            isUsed1[i] = true;
            isUsed2[i+index] = true;
            isUsed3[index-i+n-1] = true;
            func(index+1);
            isUsed1[i] = false;
            isUsed2[i+index] = false;
            isUsed3[index-i+n-1] = false;
        }
        
    }
}


// Q 이동 경로: 상하좌우, 대각선