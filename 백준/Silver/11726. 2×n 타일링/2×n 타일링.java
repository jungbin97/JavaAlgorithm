import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        int[] D = new int[n+1];
        
        D[1] = 1;
        if (n > 1) {
            D[2] = 2;
        }
        
        for (int i = 3; i <= n; i++) {
            D[i] = (D[i-1] + D[i-2])%10007;
        }
        System.out.println(D[n]);
    }
}

// 테이블 정의
// D[n] = 2Xn크기 직사각형 채우는 방법 수

// 점화식 구하기
// D[N] = D[N-1] + D[N-2]

// 초기값 정하기
// D[N-2]이니까 D[2]까지
// D[1] = 1
// D[2] = 2