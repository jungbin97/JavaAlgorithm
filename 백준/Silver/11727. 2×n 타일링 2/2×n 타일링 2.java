import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        long[] D = new long[1001];
        
        // 초기값 세팅
        D[0] = 0;
        D[1] = 1;
        D[2] = 3;
        
        for (int i = 3; i <= n; i++) {
            D[i] = ((2*D[i-2]) + D[i-1]) % 10007;
        }
        
        System.out.println(D[n]);
    }
}


// 테이블 정의하기
// D[n]: 길이가 n일떄 타일 채우는 경우의 수

// 점화식
// D[n] = (2*D[n-2]) + D[n-1]

// 초기값 세팅
// D[0] = 0
// D[1] = 1
// D[2] = 3

