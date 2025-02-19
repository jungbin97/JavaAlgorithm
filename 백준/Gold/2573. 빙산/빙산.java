import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int[][] graph;
    static int[][] visited;
    static int n ,m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 행,열
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        // 그래프 초기화
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        
        int year = 0;
        while (true) {
            year++;
            
            // 얼음 녹는 연산
            melting();
            // BFS 수행
            int result = bfs();
            
            if (result == 0) {
                System.out.println("0");
                return;
            } else if (result==1) {
                continue;
            } else {
                System.out.println(year);
                return;
            }
        }
        
    }
    // 얼음 녹는 연산 수행
    static void melting() {
        int[][] meltCountArr = new int[n][m];

        // 0 개수 카운트 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m; j++) {
                // 0이 아닌 것
                if (graph[i][j] != 0) {
                    int count = 0;
                    // 상하좌우 0인 곳 찾기
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                            if (graph[nx][ny] == 0) {
                                count++;
                            }
                        }
                    }
                    
                    meltCountArr[i][j] = count;
                }
            }
        }
        
        // 녹이기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] != 0) {
                    graph[i][j] = Math.max(0, graph[i][j] - meltCountArr[i][j]);
                }
            }
        }
        
        
    } 
    
    static int bfs() {
        int nonZeroCount = 0;
        int x = -1;
        int y = -1;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                if (graph[i][j] != 0) {
                    nonZeroCount++;
                    x = i;
                    y = j;
                } 
            }
        }
        
        if (nonZeroCount == 0) {
            return 0;
        }

        int count = 1;
        Queue<int[]> q = new ArrayDeque<>();
        visited = new int[n][m];
        q.add(new int[] {x, y});
        visited[x][y] = 1;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            
            for (int d = 0; d < 4; d++) {
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];
                
                // 인덱스 범위 체크 && 방문 체크 && 빙산인지 체크 
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (visited[nx][ny] == 0 && graph[nx][ny] != 0) {
                        count++;
                        visited[nx][ny] = 1;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }
        // 한덩어리
        if (nonZeroCount == count) {
            return 1;
        }
        return 2;
    }
    
}


// 바다: 0
// 동서남북 0의 개수 만큼 높이 감소(0보다 더 줄진 않음)
// 방금 사라진건 영향 받지 않음.

// 빙하가 두덩이 이상 분리되는 최소 시간을 구하라(BFS)

// while 
// 탈출조건: 전부 0이면 
// 1년 마다 빙하 감소 처리
// BFS로 2덩이 이상인지 확인, 이상이면 현재 년 반환
// 아니면 반복

// 시간 복잡도 90_000 O(NM) 시간 복잡도 