import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = new int[] {0, 1, -1, 0};
    static int[] dy = new int[] {1, 0, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 행, 열
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 그래프 초기화
        int[][] graph = new int[N][M];
        for (int i = 0; i < N; i++){
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }
        
        // 거리 배열 초기화(방문), 벽 상태
        int[][][] dist = new int[N][M][2];

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0, 0});
        dist[0][0][0] = 1;
        dist[0][0][1] = 1;

        int result = -1;
        // bfs 수행
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            int wallUsed = now[2];
            
            // 갱신 조건
            if (nowX == N-1 && nowY == M-1) {
                if (result == -1) {
                    result = dist[nowX][nowY][wallUsed]; // 최초 도착 시 초기화
                } else {
                    result = Math.min(result, dist[nowX][nowY][wallUsed]); // 최단 거리 선택
                }
            }
            
            // 4가지 방향 탐색
            for (int d = 0; d < 4; d++) {
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];
                
                // 인덱스 체크
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                // 벽이 아니고 && 방문하지 않은 경우(벽을 부순 여부 고려)
                if (graph[nx][ny] == 0 && dist[nx][ny][wallUsed] == 0){
                    dist[nx][ny][wallUsed] = dist[nowX][nowY][wallUsed] + 1;
                    q.add(new int[] {nx, ny, wallUsed});
                }
                
                // 벽을 부순적 없고 && 벽이 있는 경우 && 방문하지 않은 경우
                if (wallUsed == 0 && graph[nx][ny] == 1 && dist[nx][ny][1] == 0) {
                    dist[nx][ny][1] = dist[nowX][nowY][0] + 1;
                    q.add(new int[] {nx, ny, 1});
                }
            }
        }
        
        System.out.println(result);
    }
}

// {x, y, 벽뿌수기count}
// 2 3
// 011
// 010

// 핵심 - 벽 상태를 구분해야함.
// 벽을 하나도 뿌시지 않고, x,y 도달 비용
// 벽을 부수고 (x,y) 도달 비용 

