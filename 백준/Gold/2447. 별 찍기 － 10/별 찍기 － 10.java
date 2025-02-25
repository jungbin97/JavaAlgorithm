import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static char[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = '*';
            }
        }
        
        func(0, 0, n);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        
        System.out.println(sb.toString());
    }
    
    static void func(int x, int y, int n) {
        if (n == 1) {
            return;
        }
        
        n= n/3;
    
        // 공백 처리
        for (int i = x+n; i < x+2*n; i++) {
            for (int j = y+n; j < y+2*n; j++) {
                arr[i][j] = ' ';
            }
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                func(x+i*n, y+j*n, n);
            }
        }
        
    }
}


// n = 3^k

// n = 3^1
// 중간 공백 처리
// x = (int)n/3 ~ (int) n/3 + (n/3)
// y = (int)n/3 ~ (int) n/3 + (n/3)
// 쪼개지면
// 재귀


// base condition
// n = 1
// return;


// n = 9, 3^2
// x = 0, y = 0

// n = n/3
// 중간 공백 처리
// x+n ~ x+2n
// y+n ~ y+2n
// 재귀 3분할
// func(x+i*n, y+j*n, n)