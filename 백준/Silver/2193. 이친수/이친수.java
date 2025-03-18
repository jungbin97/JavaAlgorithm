import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        long[][] D = new long[n+1][2];
        
        // 초기값 세팅하기
        D[1][0] = 0;
        D[1][1] = 1;
        
        for (int i = 2; i <=n; i++) {
            D[i][0] = D[i-1][0] + D[i-1][1];
            D[i][1] = D[i-1][0];
        }
        
        System.out.println(D[n][0]+D[n][1]);
    }
}


// 테이블 정의하기
// D[i][j] i자리의 j로 끝날 경우 이친수 개수

// 점화식 구하기
// D[0][0] = 0
// D[0][1] = 0
// D[1] = ? 
// D[1][0] = 0
// D[1][1] = 1


// D[2] = ?
// D[2][0] = 10 => 1가지
// D[2][1] = 0 =
// D[2][0] + D[2][1] => 1가지

// D[3] = ? = 100, 101 => 2가지
// D[3][0] = 100 => 1가지
// D[3][1] = 101 => 1가지
// D[3][0] = D[2][0]+D[2][1] => 1가지
// D[3][1] = D[2][0] => 1가지


// D[4] = 1000, 1001, 1010 => 3가지
// D[4][0] = D[3][0]+D[3][1] = 2가지
// D[4][1] = D[3][0] = 1가지

// D[i][0] = D[i-1][0]+D[i-1][1]
// D[i][1] = D[i-1][0]

// 초기값 세팅하기
// D[1][0] = 0
// D[1][1] = 1