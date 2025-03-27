import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] D = new int[n+1];

        if (n == 1 || n == 3) {
            System.out.println(-1);
            return;
        }
        
        D[1] = 100_001;
        D[2] = 1;
        if (n>2) D[3] = 100_001;
        if (n > 3) D[4] = 2;
        if (n > 4) D[5] = 1;
        
        for (int i = 6; i <= n; i++) {
            D[i] = Math.min(D[i-2], D[i-5])+1;
        }

        System.out.println(D[n]);
    }
}


// 15 = 5 * 3
// 14 = 5 * 2 + 2 * 2 = 4
// 13 = 5 * 1 + 2 * 4 = 5
// 

// 테이블 정의하기
// D[i] i원일때 동전 개수 최소

// D[1] = 100_001
// D[2] = 1
// D[3] = 100_001
// D[4] = 2 * 2 = 2
// D[5] = 5 * 1 = 1
// D[6] = 2 * 4 = 4


// D[6] = min(D[4],D[1]) + 1 = 3

// D[7] = min(D[5], D[2])+1 = 2


// D[8] = min(D[6], D[3])+1 = 5
