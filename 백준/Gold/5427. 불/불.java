import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            // 가로, 세로
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            
            // 상근이 큐, 불 큐
            Queue<int[]> qSG = new ArrayDeque<>();
            Queue<int[]> qFire = new ArrayDeque<>();

            // 이동 시간 체크 배열 상근이, 불
            int[][] distSG = new int[n][m];
            int[][] distFire = new int[n][m];
            
            for (int i = 0; i < n; i++) {
                Arrays.fill(distSG[i], -1);
                Arrays.fill(distFire[i], -1);
            }

            // 그래프 초기화, 상근이, 불 위치 찾기 dist 0 초기화
            char[][] graph = new char[n][m];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < m; j++) {
                    graph[i][j] = line.charAt(j);

                    if (graph[i][j] == '@') {
                        qSG.add(new int[] {i, j});
                        distSG[i][j] = 0;
                    } else if (graph[i][j] == '*') {
                        qFire.add(new int[] {i, j});
                        distFire[i][j] = 0;
                    }
                }
            }
            
            // 불 BFS 수행
            while (!qFire.isEmpty()) {
                int[] now = qFire.poll();
                int nowX = now[0];
                int nowY = now[1];
                
                // 4가지 방향 탐색
                for(int d = 0; d < 4; d++) {
                    int nx = nowX + dx[d];
                    int ny = nowY + dy[d];
                    // 인덱스 체크 && 벽 체크 && 방문 체크
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                        if (graph[nx][ny] != '#' && distFire[nx][ny] == -1) {
                            qFire.add(new int[] {nx, ny});
                            distFire[nx][ny] = distFire[nowX][nowY] + 1;
                        }
                    }
                }
            }
            
            boolean escapeFlag = false;
            // 상근이 BFS 수행
            while (!qSG.isEmpty()) {
                int[] now = qSG.poll();
                int nowX = now[0];
                int nowY = now[1];
                
                for(int d = 0; d < 4; d++) {
                    int nx = nowX + dx[d];
                    int ny = nowY + dy[d];
                    
                    // 인덱스 범위 넘어가면 탈출
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        System.out.println(distSG[nowX][nowY]+1);
                        escapeFlag = true;
                        break;
                    }
                    
                    // 벽 체크 || 방문 체크
                    if (graph[nx][ny] == '#' || distSG[nx][ny] >= 0) {
                        continue;
                    }
                    
                    // 불 시간 체크
                    if (distFire[nx][ny] != -1 && distFire[nx][ny] <= distSG[nowX][nowY] + 1) {
                        continue;
                    }
                    qSG.add(new int[] {nx, ny});
                    distSG[nx][ny] = distSG[nowX][nowY] + 1;
                }
                
                if (escapeFlag) {
                    break;
                }
            }
            
            if (!escapeFlag) {
                System.out.println("IMPOSSIBLE");
            }
        }

    }
}
