import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        
        // 집 개수
        int n = Integer.parseInt(br.readLine());
        
        // 빨강, 초록, 파랑
        int[][] cost = new int[n+1][3];

        int result = Integer.MAX_VALUE;

        for (int i = 1; i <=n; i++) {
            st= new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        
        for (int firstColor = 0; firstColor < 3; firstColor++) {
            int[][] D = new int[n+1][3];
            
            for (int i = 0; i <= n; i++) {
                Arrays.fill(D[i], 1_000_001);
            }
            
            // 첫번쨰 집 색깔 선택
            D[1][firstColor] = cost[1][firstColor];
            

            for (int i = 2; i <= n; i++) {
                D[i][0] = Math.min(D[i-1][1], D[i-1][2]) + cost[i][0];
                D[i][1] = Math.min(D[i-1][0], D[i-1][2]) + cost[i][1];
                D[i][2] = Math.min(D[i-1][0], D[i-1][1]) + cost[i][2];
            }
            
            // 마지막 집은 첫집과 달라야함.
            for (int lastColor = 0; lastColor < 3; lastColor++) {
                if (lastColor == firstColor) continue;
                
                result = Math.min(result, D[n][lastColor]);
            }
        }
        
        System.out.println(result);
    }
}

// 모든 집 칠하는 비용 최솟값

// 이웃집은 색이달라야함. 

// 테이블 정의
// D[i][0] = i번째 집까지 칠할때 비용 최솟값, i번째집 빨강 
// D[i][1] = i번째 집까지 칠할때 비용 최솟값, i번째집 초록 
// D[i][2] = i번째 집까지 칠할때 비용 최솟값, i번째집 파랑
// 
// 점화식 구하기
// D[k][0] = min(D[k-1][1], D[k-1][2]) + R[k]
// D[k][1] = min(D[k-1][2], D[k-1][2]) + G[k]
// D[k][2] = min(D[k-2][1], D[k-1][1]) + B[k]
// 
// 초기값 정하기
// D[1][0] = R[1]
// D[1][1] = G[1]
// D[1][2] = B[1]
// 


// 26 + 57 + 89 = 172
// 40 + 49 + 99 = 188
// 83 + 49 + 89 = 