import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] graph;
    static int[][] check;
    // 오른쪽, 아래, 왼쪽, 위
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static ArrayList<int[]> listCCTV; 
    static int result = Integer.MAX_VALUE;

    static int[][][] direction = {
        {},
        {{0}, {1}, {2}, {3}},
        {{0, 2}, {1, 3}},
        {{2, 3}, {3, 0}, {0, 1}, {1, 2}}, 
        {{3, 0, 2}, {3, 0, 1}, {0, 1, 2}, {3, 2, 1}},
        {{0, 1, 2, 3}}
    };
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        

        // 세로, 가로
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        graph = new int[n][m];
        check = new int[n][m];
        listCCTV = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                // CCTV 위치 저장
                if (graph[i][j] != 0 && graph[i][j] != 6) {
                    listCCTV.add(new int[] {i, j, graph[i][j]});
                }
            }
        }
        
        dfs(0);
        
        System.out.println(result);

        
    }
    
    static void dfs(int index) {
        // base condition
        if (index == listCCTV.size()) {
            result = Math.min(result, zeroCount());
            return;
        }
        
        int[] cctv = listCCTV.get(index);
        int x = cctv[0], y = cctv[1], type = cctv[2];

        // cctv 종류 별로 가능한 방향 탐색
        for (int[] dirs : direction[type]) {
            for (int d : dirs) {
                markCCTV(x, y, d, true);
            }
            
            dfs(index+1);
            for (int d : dirs) {
                markCCTV(x, y, d, false);
            }
        }

    }
    

    static void markCCTV(int x, int y, int d, boolean isMark) {
        int nx = x, ny = y;
        
        while (true) {
            nx += dx[d];
            ny += dy[d];
            
            // 인덱스 범위, 벽만나면
            if (nx < 0 || ny < 0 || nx >= n || ny >= m || graph[nx][ny] == 6) {
                break;
            }
            
            if (graph[nx][ny] != 6) {
                if (isMark) {
                    check[nx][ny]++;
                } else {
                    check[nx][ny]--;
                }
            }
        }
    }
    
    static int zeroCount() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0 && check[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}


// 모든 CCTV 배치 시(index==list.size()) 0인 개수가 가장 작은지 체크
