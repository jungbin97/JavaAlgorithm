import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] graph;
    static int r, c, d;
    
    // 북, 동, 남, 서
    static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // 초기 로봇 청소기 위치, 방향
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
            
        // 그래프 초기화
        graph = new int[n][m];
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        
        while(true) {
            // 아직 청소 되지않은 경우 청소
            if (graph[r][c] == 0) {
                result++;
                graph[r][c] = -1;
            }

            boolean cleaned = false;
            for (int i = 0; i < 4; i++) {
                // 반시계방향 회전(0 -> 3, 1 -> 0)
                d = (d+3)%4;
                int nx = r + direction[d][0];
                int ny = c + direction[d][1];
                
                // 청소 되지 않은 빈칸 있다면
                if (graph[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                    cleaned = true;
                    break;
                }
            }
            
            // 네방향 모두 청소가 되어있다면
            if (!cleaned) {
                int backX = r - direction[d][0];
                int backY = c - direction[d][1];
                
                // 뒤가 벽이라면 후진 작동 중지
                if (graph[backX][backY] == 1) {
                    break;
                }
                // 후진
                r = backX;
                c = backY;
            }
            
        }
        
        System.out.println(result);
    }

}
// 청소하는 칸 개수 구하기

// 청소기 방향
// 0:북쪽, 1:동쪽, 2:남쪽, 3:서쪽
// graph[][] = 0 청소 되지 않은 빈칸
// graph[][] = 1 벽
// graph[][] = -1 청소한 빈칸