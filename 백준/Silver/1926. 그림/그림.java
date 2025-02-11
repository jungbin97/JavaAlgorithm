import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int[][] graph;
    static boolean[][] visited;
    static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        // 그림 개수
        int count = 0;
        // 가장 넓은 그림 넓이
        int maxValue = 0;

        // 방문 배열 초기화
        visited = new boolean[n][m];
        
        // 그래프 초기화
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 아직 방문하지 않았으면 bfs 수행
                if (!visited[i][j] && graph[i][j] == 1) {
                    maxValue = Math.max(maxValue, bfs(i ,j));
                    count++;
                }
            }
        }
        
        System.out.println(count);
        System.out.println(maxValue);

    }
    
    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        
        int result = 1;
        visited[x][y] = true;
        q.add(new int[] {x, y});
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            // 4방향 탐색
            for (int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];

                // 아직 방문하지 않았고, 1이고, 인덱스 범위 넘지 않는지 체크
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && graph[nx][ny] == 1) {
                        q.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                        result++;
                    }
                }
            }
        }
        
        return result;
    }
    
}