import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 상하좌우 이동
        int[] dx = new int[] {0, 1, -1, 0};
        int[] dy = new int[] {1, 0, 0, -1};

        Queue<int[]> q = new LinkedList<>();

        // 그래프 초기화
        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }
        
        // 방문 배열 초기화
        visited = new boolean[n][m];

        // 거리 초기화

        visited[0][0]= true;
        q.add(new int[] {0, 0});
        
        // bfs 수행
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            // 4방향 탐색
            for (int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                
                // 방문하지 않고, 1이고, 인덱스 범위 이내
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && graph[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        q.add(new int[] {nx, ny});
                        graph[nx][ny] = graph[now[0]][now[1]]+1;
                    }
                }
            }
        }
        
        System.out.println(graph[n-1][m-1]);

    }
}

// 이동할 수 있는 칸 1
// (1,1) 출발하여 (n, m) 최소 칸 수
// bfs