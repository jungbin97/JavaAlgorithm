import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 과일 종류 수, 훔칠 개수
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] D = new int[n+1][m+1];
        
        // 초기값 세팅
        for (int j = 1; j <= m; j++) {
            D[1][j] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= m; j++) {
                for (int k = 1; k <= j; k++) {
                    D[i][j] += D[i-1][j-k];
                }
            }
        }
        System.out.println(D[n][m]);
    }

    
}


// D[i][j] = ?  i개의 과일의 종류 사용해서 j개의 과일을 훔츼는 경우

// 초기값 세팅
// D[1][1] = 1
// D[1][2] = 1

// D[2][3] => (1, 2), (2, 1)  = 2
// D[2][4] => (1, 3), (2, 2), (3, 1) = 3
// D[2][5] => (1, 4), (2, 3), (3, 2), (4, 1) = 4
// 
// D[3][3] => (1, 1, 1) => 1
// D[3][4] => (1, 2, 1), (1, 1, 2), (2, 1, 1) => 3

// D[2][3] => D[1][2] + D[1][1]
// D[2][4] => D[1][3] + D[1][2] + D[1][1]
// D[i][j] => D[i-1][j-1] + D[i-1][j-2] + D[i-1][j-3]