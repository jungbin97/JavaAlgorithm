import java.util.*;
import java.io.*;

public class Main {
    // 상하좌우 + 앞뒤
    static int[] dx = {0, 1, -1, 0, 0, 0};
    static int[] dy = {1, 0, 0, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int[][][] graph;
    static int m, n, h;
    static Queue<int[]> q;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        

        // 가로 칸수(열), 세로 칸수(행), 쌓아올려지는 상자수(높이)
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        // 3차원 배열 초기화(높이, 행, 열)
        graph = new int[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    graph[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        
        q = new ArrayDeque<>();
        // 익은 토마토 찾기
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (graph[i][j][k] == 1) {
                        q.add(new int[] {i, j, k});
                    }
                }
            }
        }
        
        // 수행
        bfs();

        int result = 0;
        // 최댓 값 구하기
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    // ㅇㅐ익지 않은 토마토 있을 경우, -1
                    if (graph[i][j][k] == 0) {
                        System.out.println("-1");
                        return;
                    }
                    result = Math.max(result, graph[i][j][k]);
                }
            }
        }
        
        System.out.println(result-1);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowH = now[0];
            int nowX = now[1];
            int nowY = now[2];
            // 6방향 탐색
            for (int d = 0; d < 6; d++) {
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];
                int nh = nowH + dh[d];
                
                // 인덱스 체크 && 방문체크, 안익은 토마토
                if (0 <= nx && nx < n && 0 <= ny && ny < m && 0 <= nh && nh < h) {
                    if (graph[nh][nx][ny] == 0) {
                        q.add(new int[] {nh, nx, ny});
                        graph[nh][nx][ny] = graph[nowH][nowX][nowY] + 1;
                    }
                }
            }
        }
    }
}


// 익은 토마토 찾기
// bfs 탐색 후 0이 존재하면, -1 반환
// 0이 없으면, 최댓값 반환