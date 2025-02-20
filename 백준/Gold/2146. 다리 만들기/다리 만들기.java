import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] dx = new int[] {0, 1, -1, 0};
    static int[] dy = new int[] {1, 0, 0, -1};
    static int[][] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());

        // 그래프 초기화
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        
        // 1. 섬 라벨링(2, 3, 4...)한 그래프로 변경
        boolean[][] visited = new boolean[n][n];
        
        int labelNum = 2;
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                // 육지면
                if (graph[i][j] == 1) {
                    bfs(i , j, labelNum, visited);
                    labelNum++;
                }
            }
        }
        
        // 2. 섬에서 다른 섬으로 가는 짧은 경로 찾기
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 바다(0)이 아니면
                if (graph[i][j] != 0) {
                    int bridgeSize = createBridge(i, j);
                    result = Math.min(result, bridgeSize);
                }
            }
        }
        
        System.out.println(result);

    }
    
    // 출발점의 섬 라벨링이랑 다르면 다른 섬
    static int createBridge(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        int nowlabelNum = graph[x][y];
        boolean[][] visited = new boolean[n][n];
        
        q.add(new int[] {x, y, 0});    
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            int dist = now[2];

            for(int d = 0; d < 4; d++) {
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];
                
                // 인덱스 범위 체크
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                
                // 같은 섬이면 무시
                if (graph[nx][ny] == nowlabelNum) {
                    continue;
                }
                
                // 다른섬을 만나면 현재 거리 반환
                if (graph[nx][ny] != nowlabelNum && graph[nx][ny] != 0) {
                    return dist;
                }

                // 바다이고 방문하지 않았다면 BFS 진행
                if (graph[nx][ny] == 0 && !visited[nx][ny]) { 
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny, dist+1});
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    static void bfs(int x, int y, int labelNum, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        graph[x][y] = labelNum;
        q.add(new int[] {x, y});
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            
            for(int d = 0; d < 4; d++) {
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];
                
                // 인덱스범위 체크
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                // 방문하지 않고 && graph[][] == 1
                if (!visited[nx][ny] && graph[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    graph[nx][ny] = labelNum;
                    q.add(new int[] {nx, ny});
                }
            }
            
        }
    }
    
}

// 0: 바다
// 1: 육지

// BFS로 육지 찾고 라벨링
// 섬에서 다른 섬 가는 짧은 경로 찾기(BFS)

// O(NN) = 10_000