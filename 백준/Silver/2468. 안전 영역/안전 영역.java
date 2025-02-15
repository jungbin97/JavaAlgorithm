import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int n;
    static int[][] graph; 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        // 그래프 초기화
        graph = new int[n][n];
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                maxValue = Math.max(maxValue, graph[i][j]);
            }
        }
        int result = 0;
        // 물 높이
        for (int h = 0; h <= maxValue; h++) {
            int count = 0;
            boolean[][] visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 방문 하지 않고 && 높이보다 큰 곳
                    if (!visited[i][j] && graph[i][j] > h) {
                        bfs(visited, i, j, h);
                        count++;
                    }
                }
            }
            result = Math.max(result, count);
        }
        
        System.out.println(result);
    }
    
    public static void bfs(boolean[][] visited, int x, int y, int h) {
        Queue<int[]> q = new ArrayDeque<>();
        
        q.add(new int[] {x, y});
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            
            // 4가지 방향 탐색
            for (int d = 0; d < 4; d++) {
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];
                
                // 인덱스 범위 이내 && 높이 보다 크고 && 방문하지 않은
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (!visited[nx][ny] && graph[nx][ny] > h) {
                        visited[nx][ny] = true;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }
    }
}

// 0 ~ 가장 큰 값까지
// 물에 잠기지 않는 지역 탐색, 그 집합 반환
// 물 높이에따른 가장큰 집합 개수 반환