import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            // n 크기
            int n = Integer.parseInt(br.readLine());
            int[][] D = new int[n+1][3];
            int[][] arr = new int[n+1][3];
            
            // 스티커 입력
            for (int i = 1; i <= 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    arr[j][i] = Integer.parseInt(st.nextToken());
                }
            }
            
            // 열 
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= 2; j++) {
                    int v = 0;
                    if (i > 1) {
                        v = Math.max(D[i-2][1], D[i-2][2]);
                    }
                    v = Math.max(v, D[i-1][3-j]);
                        
                    D[i][j] = v + arr[i][j];
                }
            }
            
            System.out.println(Math.max(D[n][1], D[n][2]));
        }
    }
}



// 100 + 60 + 50+ 50 = 260
// 
// 테이블 정의하기
// D[i][j]: i번쨰 열 정수 최댓값, j행 i열의 스티커 선택할 경우

// 이전에 i-1번째 스티커를 선택할 경우
// D[i][j] = D[i-1][3-j] + arr[i][j]

// 이전에 i-2번째 스티커를 선택할 경우
// D[i][j] = max(D[i-2][1], D[i-2][2]) + arr[i][j]