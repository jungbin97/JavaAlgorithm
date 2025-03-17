import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[][] S = new int[n+1][n+1];
        int[][] D = new int[n+1][n+1];
        
        for(int i = n; i > 0; i--) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n+1-i; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        
        for(int i = 1; i <= n; i++) {
            for (int j = 0; j < n+1-i; j++) {
                D[i][j] = Math.max(D[i-1][j], D[i-1][j+1]) + S[i][j];
            }
        }
        
        System.out.println(D[n][0]);
    }
}


// 테이블 정의하기
// D[i][1] = i번째 줄에 첫번쨰가 합이 최대가 되는 수

// 반복문 -> 1번째(5)

// 점화식 구하기
// D[2][0] = ?
// Math.max(D[1][0] D[1][1]) + S[2][2]
// D[2][2] = ?
// Math.max(D[1][2], D[1][3]) + S[2][2]

// D[2][3] =?
// Math.max(D[1][3], D[1][4]) + S[2][3]


// D[i][j]
// Math.max(D[i-1][j], D[i-1][j+1]) + S[i][j]


// 초기값 세팅하기
// D[1][0] = 0 + S[1][0]
// ~
// D[1][n-1] = 0 + S[1][n-1]