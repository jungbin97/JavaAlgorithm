import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static boolean[][] visited;
    static int[][] graph;
    static int n;
    
    static ArrayList<Integer> result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        // 그래프 초기화
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }
        
        // 방문체크 배열 초기화
        visited = new boolean[n][n];
        
        result = new ArrayList<>();
        int setCount = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 아직 방문하지 않고, graph가 1인곳
                if (!visited[i][j] && graph[i][j] == 1) {
                    bfs(i, j);
                    setCount++;
                }
            }
        }
        // 오름차순 정렬
        Collections.sort(result);

        // 출력
        System.out.println(setCount);
        
        for (int r : result) {
            System.out.println(r);
        }
    }
    
    public static void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        
        q.add(new int[] {x, y});
        visited[x][y] = true;
        int nodeCount = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            
            // 4가지 방향 탐색
            for (int d = 0; d < 4; d++) {
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];
                
                // 인덱스 체크 && 방문하지 않은 곳 && graph == 1인곳
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (!visited[nx][ny] && graph[nx][ny] == 1) {
                        visited[nx][ny]= true;
                        q.add(new int[] {nx, ny});
                        nodeCount++;
                    }
                }
            }
        }
        result.add(nodeCount);
    }
}

// 집합 개수
// 각 집합의 노드 개수(오름차순 출력)