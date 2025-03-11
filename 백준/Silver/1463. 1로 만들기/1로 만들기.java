import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] DP = new int[n+1];
        
        DP[1] = 0;
        for (int i = 2; i <= n; i++) {
            DP[i] = DP[i-1]+1;
            if (i % 2 == 0) {
                DP[i]=Math.min(DP[i/2]+1, DP[i]);
            }
            if (i % 3 == 0) {
                DP[i]=Math.min(DP[i/3]+1, DP[i]);
            }
        }
        System.out.println(DP[n]);
    }
}

// D[12] = ? 
// D[4] + 1
// D[6] + 1
// D[11] + 1
// D[12] = min(D[4] + 1, D[6] + 1, D[11] + 1)
// 
// 
// 점화식 : D[k] = min(D[k/3]+1, D[k/2]+1, D[k-1]+1)
// 초기값 정의: D[1] = 0
//
// D[2] = min(D[2/3]+1, D[k/2]+1, D[2-1+1]) = (1, 1, 1)
// D[3] = min(D[3/3]+1, D[3/2]+1, D[2]+1) = (2, 2, 2)