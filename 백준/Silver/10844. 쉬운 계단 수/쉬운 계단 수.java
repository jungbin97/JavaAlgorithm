import java.util.*;
import java.io.*;

public class Main {
    static final int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] D = new int[101][10];
        

        // 초기값 설정
        for (int i = 1; i <= 9; i++) {
            D[1][i] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j > 0) {
                    D[i][j] = (D[i][j] + D[i-1][j-1]) % MOD;
                }
                if (j < 9) {
                    D[i][j] = (D[i][j] + D[i-1][j+1]) % MOD;
                }
            }
        }
        
        int result = 0;
        for (int i = 0; i <= 9; i++) {
            result = (result + D[n][i]) % MOD;
        }

        System.out.println(result);
    }
}


// 계단수
// 0으로는 시작안함.
// 45656


// D[i][j]: ? 길이가 i개인 계단에서, j로 끝나는것 개수
// 
// D[1] = 9
// 1, 2, 3, 4, 5, 6, 7, 8, 9
// D[1][1] = 1 ~ D[1][9] = 1
//
//
// D[2] = 2 * 10 -3 = 17
// D[2][0] = D[1][1]
// D[2][1] = D[1][2]
// D[2][2] = D[1][1] + D[1][3]
// D[2][3] = D[1][2] + D[2][4]
// D[2][4] = D[1][3] + D[1][5]
// 
// 점화식 구하기
// D[i][j] = D[i-1][j-1] + D[i-1][j+1]
// 1: 10, 12
// 2: 21, 23
// 3: 32, 34
// 4: 43, 45
// 5: 54, 56
// 6: 65, 67
// 7: 76, 78
// 9: 98
// 
// D[3] = ?
// 101