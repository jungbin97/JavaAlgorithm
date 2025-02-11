import java.util.*;
import java.io.*;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = new int[] {0, 1, -1, 0};
    static int[] dy = new int[] {1, 0, 0, -1};
    static Queue<int[]> q;
    static int N, M;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int result = 0;
        // graph 초기화
        graph = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 방문체크 배열 초기화
        visited = new boolean[M][N];
        
        q = new LinkedList<>();
        // 익은 토마토 찾기
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1) {
                    q.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }
        
        bfs();
        
        // 0이 있는지 탐색
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }
                result = Math.max(result, graph[i][j]);
                
            }
        }
        
        System.out.println(result-1);
    }

    static void bfs() {
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            // 4가지 방향 탐색
            for (int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                // 인덱스 범위 내, 방문하지 않고, graph[nx][ny]가 0인 곳(even하게 익지않은 토마토!)
                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (!visited[nx][ny] && graph[nx][ny] == 0) {
                        q.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                        graph[nx][ny] = graph[now[0]][now[1]] + 1;
                    }
                }
            }

        }
    }
}

// flood fill
// 1은 익은 토마토 0은 익지 않은 토마토, -1은 토마토 없는 칸


// 방문하지 않은, 1인 것을 전부 큐에 넣고, 반복 (x, y, 날짜)
// 0인 것이 있다면 -1 출력
// 0인 것이 없다면 최대 날짜 출력