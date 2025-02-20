import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // n크기, 행, 열
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int result = func(n,r,c);
        System.out.println(result);
        
    }

    static int func(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }
        // 절반 (2^{n-1})
        int half = (1<<(n-1));
        // 1번 사각형
        if (r < half && c < half) {
            return func(n-1, r, c);
        }
        // 2번 사각형
        if (r < half && c >= half) {
            return half*half + func(n-1, r, c-half);
        }
        // 3번 사각형
        if (r >= half && c < half) {
            return 2*(half * half) + func(n-1, r-half, c);
        }
        return 3*(half * half) + func(n-1, r-half, c-half);
    }
}


// 2^n X 2^n 배열에서 (r,c)를 방문하는 순서를 반환하는 함수
// int func(int n, int r, int c) 


// n = k
// half = 2^k-1 
// r = 5, c = 2 (3번 사각형)
// 16 + 16 + 6 = 32 + 6 = 38

// 1번 사각형
// func(n-1, r, c)
// 
// 2번 사각형
// half + func(n-1, r, c-half)

// 3번 사각형
// 2 * (half * half) + func(n-1, r-half, c)

// base condition
// n = 0일때 return 0;
//
// (r, c) 1번 return func(n-1, r, c);
