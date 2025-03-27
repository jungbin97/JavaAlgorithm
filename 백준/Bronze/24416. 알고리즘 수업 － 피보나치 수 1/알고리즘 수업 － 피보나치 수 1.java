import java.util.*;
import java.io.*;

public class Main {
    static int[] D;
    static int count1, count2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        D = new int[n+1];
        
        fib(n);
        fibonacci(n);
        
        System.out.println(count1+" "+count2);

    }
    
    static int fib(int n) {
        if (n == 1 || n == 2) {
            count1++;
            return 1;
        }
        return fib(n-1) + fib(n-2);
    } 
    
    static int fibonacci(int n) {
        D[1] = D[2] = 1;
        for (int i = 3; i <= n; i++) {
            count2++; // 여기가 실제 연산
            D[i] = D[i-1] + D[i-2];
        }
        return D[n];
    }

}
