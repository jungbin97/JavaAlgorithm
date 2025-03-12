import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 개단 개수
        int n = Integer.parseInt(br.readLine());

        int[] S = new int[n+1];
        int[][] D = new int[n+1][3];
        for (int i = 1; i <= n; i++) {
            S[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(S[1]);
            return;
        }
        
        // 초기값 세팅
        D[1][1] = S[1];
        D[1][2] = 0;
        

        D[2][1] = S[2];
        D[2][2] = S[1]+S[2];
        
        // DP 테이블 세팅
        for (int i = 3; i <= n; i++) {
            D[i][1] = Math.max(D[i-2][2], D[i-2][1]) + S[i];
            D[i][2] = D[i-1][1] + S[i];
        }
        
        System.out.println(Math.max(D[n][1],D[n][2]));
    }
}

// 점화식구하기
// D[k][] = ?
// D[k][1] = max(D[k-2][2], D[k-2][1]) + S[k]
// D[k][2] = D[k-1][1] + S[k]
// 초기값 세팅
// D[2][2] = S[1]+S[2]
// D[2][1] = S[2]
// D[1][1] = S[1]
// D[1][2] = 0