import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int Tc = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < Tc; t++) {
            st = new StringTokenizer(br.readLine());
            // 가로, 세로, 배추 위치 개수
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            // 그래프 초기화
            int[][] graph = new int[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[y][x] = 1;
            }
            
            int result = 0;
            boolean[][] visited = new boolean[n][m];
            
            // 배추 위치 찾기
            for (int i = 0; i < n; i++) {
                for (int j =0; j < m; j++) {
                    // 아직 방문하지 않은 && 배추
                    if (!visited[i][j] && graph[i][j] == 1) {
                        bfs(graph, visited, i, j, n, m);
                        result++;
                    }
                }
            }
            
            System.out.println(result);



        }
    }

    public static void bfs(int[][] graph, boolean[][] visited, int x, int y, int n, int m) {
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[] {x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            // 4가지 방향 탐색
            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                
                // 인덱스 범위 && 방문 체크 && 배추
                if (0 <= nx && 0 <= ny && n > nx && m > ny) {
                    if (!visited[nx][ny] && graph[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }
        
    }
}



// 배추지렁이는 해당 배추의 인접한 배추보호 !(유익한 곤충!@)

// 배추 심은땅 : 1
// 배추 안심은땅 : 0

// 배추지렁이가 최소 필요 개수 => 배추의 집합 개수
