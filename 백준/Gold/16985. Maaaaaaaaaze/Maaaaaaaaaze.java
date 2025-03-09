import java.util.*;
import java.io.*;

public class Main {
    static int[][][] maze = new int[5][5][5];
    static int[][][] rotatedMaze = new int[5][5][5];
    static boolean[] used = new boolean[5];

    static int minEscapeCount = 999;
    
    static boolean[][][] visited;
    // 상하좌우, 위, 아래
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; k++) {
                    maze[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        
        buildMaze(0);
        
        // 어떻게 설계해도 탈출할 수 없는 경우
        if (minEscapeCount == 999) {
            System.out.println(-1);
        } else {
            System.out.println(minEscapeCount);
        }
    }
    
    // 판 쌓기(백트래킹)
    static void buildMaze(int depth) {
        if (depth == 5) {
            rotateAndSearch(0);
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            if (!used[i]) {
                used[i] = true;
                rotatedMaze[depth] = maze[i]; // i번째판 detph층 반영
                buildMaze(depth+1);
                used[i] = false;
            }
        } 
        
    }
    

    // 쌓은 판의 모든 층 회전하면서 탐색
    static void rotateAndSearch(int depth) {
        if (depth == 5) {
            // 탈출 경로 시작과 도착지점이 이동 가능해야함.
            if (rotatedMaze[0][0][0] != 0 && rotatedMaze[4][4][4] != 0) {
                minEscapeCount = Math.min(minEscapeCount, bfs(0, 0, 0));
            }
            return;
        }
        
        for (int r = 0; r < 4; r++) {
            rotateLayer(depth);
            rotateAndSearch(depth+1);
        }

    }
    
    // 특정 층 90도 회전하는 함수
    static void rotateLayer(int layer) {
        int[][] newLayer = new int[5][5];
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <5; j++) {
                newLayer[j][4-i] = rotatedMaze[layer][i][j];
            }
        }
        
        rotatedMaze[layer] = newLayer;
    }
    

    // 0,0,0 ~ 4,4,4 BFS 탐색 후 이동 거리 반환
    static int bfs(int x, int y, int z) {
        Queue<int[]> q = new ArrayDeque<>();
        visited = new boolean[5][5][5];

        q.add(new int[] {x, y, z, 0});
        visited[x][y][z] = true;

        while(!q.isEmpty()) {
            int[] now =  q.poll();
            
            int nowX = now[0];
            int nowY = now[1];
            int nowZ = now[2];
            int moveCount = now[3];

            // 탈출조건에 도달
            if (nowX == 4 && nowY == 4 && nowZ == 4) {
                return moveCount;
            }
            
            // 6방향 탐색
            for (int d = 0; d < 6; d++) {
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];
                int nz = nowZ + dz[d];
                
                // 범위 체크
                if (nx < 0 || ny < 0 || nz < 0 || nx >= 5 || ny >= 5 || nz >= 5 || nz >= 5) {
                    continue;
                }
                
                // 방문하지 않고, 1이면 참가자 들어갈 수 있음
                if (!visited[nx][ny][nz] && rotatedMaze[nx][ny][nz] == 1) {
                    visited[nx][ny][nz] = true;
                    q.add(new int[] {nx, ny, nz, moveCount + 1});
                }
            }
        }
        return 999;
    }
    
}

//가장 적은 이동횟수로 탈출한 이동횟수 반환, 탈출할수 없다면 -1

// 5 X 5 크기판 5개
// 각판은 시계방향, 반시게 방향회전 가능
// 회전을 완료한후 참가자는 판 5개를 쌓음
// 

// 1. 판을 회전한다.
// 2. 판을 쌓는다.
// 
// 입구와 출구는 면을 공유하지 않는 꼭지점 위치