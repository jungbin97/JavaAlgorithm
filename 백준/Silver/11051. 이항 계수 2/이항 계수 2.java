import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        
        // 배열 초기화
        long[][] arr = new long[n+1][n+1];
        
        for(int i = 0; i<=n; i++) {
            arr[i][0] = 1;
            arr[i][i] = 1;
            arr[i][1] = i;
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // 점화식
                arr[i][j] = (arr[i-1][j] + arr[i-1][j-1]) % 10007;
            }
        }

        
        System.out.println(arr[n][k]);
    }
}