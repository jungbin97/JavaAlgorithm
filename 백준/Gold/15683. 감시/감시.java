import java.util.*;
import java.io.*;

public class Main {
    static int[][] graph;
    static int[][] coverage;
    static ArrayList<int []> cctvList;
    static int result = Integer.MAX_VALUE;
    static int n, m;
    

    static int[][][] direction = {
        {},
        {{0}, {1}, {2}, {3}},
        {{0, 2}, {1, 3}},
        {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
        {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
        {{0, 1, 2, 3}}
    };

    // 오른쪽, 아래, 왼쪽, 위
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 세로, 가로
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        graph = new int[n][m];
        coverage = new int[n][m];
        cctvList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                
                // cctv위치 저장
                if (graph[i][j] != 0 && graph[i][j] != 6) {
                    cctvList.add(new int[] {i, j, graph[i][j]});
                }
            }
        }
        
        dfs(0);
        

        System.out.println(result);
    }



    static void dfs(int depth) {
        // 모든 cctv 배치
        if (depth == cctvList.size()) {
            result = Math.min(result, countBlindSpot());
            return;
        }
        
        int[] cctv = cctvList.get(depth);
        int x = cctv[0], y = cctv[1], type = cctv[2];
        
        // cctv 종류 별로 가능한 방향 탐색
        for (int[] dirs : direction[type]) {
            for (int d : dirs) {
                markCCTV(x, y, d, true);
            }
            dfs(depth+1);
            for (int d : dirs) {
                markCCTV(x, y, d, false);
            }
        }
    }
    
    static void markCCTV (int x, int y, int dir, boolean isMark) {
        int nx = x, ny = y;
        while (true) {
            nx += dx[dir];
            ny += dy[dir];
            
            if (nx < 0 || ny < 0 || nx >= n || ny >= m || graph[nx][ny] == 6) {
                break;
            }

            if (graph[nx][ny] != 6) {
                if (isMark) {
                    coverage[nx][ny]++;
                } else {
                    coverage[nx][ny]--;
                }
            }

        }
    }
    

    static int countBlindSpot() {
        int count = 0;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j]==0) {
                    if (coverage[i][j] == 0) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}


// cctv는 90도 방향으로 회전가능, 벽(6)은 통과 불가, cctv는 통과 가능
// 사각지대 0인곳 개수 구하기
// 
// 
// cctv1=> 4방향 조합
// cctv2=> 2방향 조합
// cctv3=> 4방향 조합
// cctv4=> 1방향 조합 <-, ->, ^, v
