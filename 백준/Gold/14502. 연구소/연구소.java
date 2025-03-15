import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] map;

    static Queue<int []> q;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 세로, 가로 크기
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        
        // 맵 초기화
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 1. 벽 세우기
        makeWallAndBFS(0);

        System.out.println(result);
    }
    
    // 1. 벽세우기
    static void makeWallAndBFS(int depth) {
        // base conditon
        if (depth == 3) {
            // 바이러스 BFS 탐색 
            bfs();
            return;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    makeWallAndBFS(depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }
    
    static void bfs() {
        q = new ArrayDeque<>();
        
        // 맵 복사
        int[][] tempMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            tempMap[i] = map[i].clone(); 
        }

        // 바이러스 위치 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempMap[i][j] == 2) {
                    q.add(new int[] {i, j});
                }
            }
        }
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            
            for(int d = 0; d < 4; d++) {
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];
                
                
                // 범위 체크
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                
                // 빈칸이면
                if (tempMap[nx][ny] == 0) {
                    tempMap[nx][ny] = 2;
                    q.add(new int[] {nx, ny});
                }
            }
        }
        
        result = Math.max(result, findSafety(tempMap));
    }

    static int findSafety(int[][] tempMap) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempMap[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
    
}

// 안전영역 크기 구하기

// 바이러스는 상하좌우 인접공간 퍼짐.
// 벽은 3개 세울수 있음.(꼭 3개)

// 0: 빈 칸, 1: 벽, 2: 바이러스
// 


// 1. 빈칸에 벽 세우기(완전 탐색)
// 2. 바이러스 BFS 수행
// 3. 빈 공간 개수 찾기 