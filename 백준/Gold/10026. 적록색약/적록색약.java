import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static char[][] graph;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(br.readLine());

        // 그래프 초기화
        graph = new char[n][n];
        for (int i = 0; i< n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = line.charAt(j);
            }
        }
        
        // 일반인
        boolean[][] visited = new boolean[n][n];
        int resultNomal = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 방문하지 않은곳
                if (!visited[i][j]) {
                    bfs(visited, n, i, j, graph[i][j]);
                    resultNomal++;
                }
            }
        }

        // 적록색약
        visited = new boolean[n][n];
        int resultRG = 0;
        
        // 초록색도 빨간색으로 변경
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 'G') {
                    graph[i][j] = 'R';
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 방문하지 않은곳
                if (!visited[i][j]) {
                    bfs(visited, n, i, j, graph[i][j]);
                    resultRG++;
                }
            }
        }

        System.out.println(resultNomal+ " "+ resultRG);
    }
    
    public static void bfs(boolean[][] visited, int n, int x, int y, int targetColor) {
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[] {x, y});
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            

            // 4방향 탐색
            for (int d = 0; d < 4; d++) {
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];
                
                // 인덱스 범위 && 방문하지 않은 && targetColor와 같은
                if (0 <= nx && 0 <= ny && nx < n && ny < n) {
                    if (!visited[nx][ny] && targetColor == graph[nx][ny]) {
                        q.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

}


// 적록색약 : R G를 구분 못함.
// 일반인이 보는 구역, 적록색약이 보는 구역 개수 출력하기