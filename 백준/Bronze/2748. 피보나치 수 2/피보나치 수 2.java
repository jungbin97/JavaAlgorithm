import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        long[] D = new long[n+1];
        
        D[0] = 0;
        D[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            D[i] = D[i-1] + D[i-2];
        }
        
        System.out.println(D[n]);
    }
}

// 테이블 정의하기
// D[i]:  i 번쨰 피보나치 수


// 초기값 세팅
// D[0] = 0
// D[1] = 1


// 점화식 구하기
// D[2] = 1
// D[3] = 2
// D[4] = 3
// D[i] =  D[i-1] + D[i-2]