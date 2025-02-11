import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        // 지훈이, 불 그래프 이동 시간 체크 배열
        int[][] distGH = new int[R][C];
        int[][] distFire = new int[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(distFire[i], -1);
            Arrays.fill(distGH[i], -1);

        }

        Queue<int[]> qGH = new ArrayDeque<>();
        Queue<int[]> qFire = new ArrayDeque<>();

        char[][] graph = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = line.charAt(j);
            }
        }
        
        // 지훈이, 불 위치 찾기, dist 0으로 초기화
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] == 'J') {
                    qGH.add(new int[] {i, j});
                    distGH[i][j] = 0;
                } else if (graph[i][j] == 'F') {
                    qFire.add(new int[] {i, j});
                    distFire[i][j] = 0;
                }
            }
        }
        
        // 불 BFS 수행
        while (!qFire.isEmpty()) {
            int[] now = qFire.poll();
            
            // 4가지 방향 탐색
            for (int k =0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];

                // 인덱스 범위 체크, 벽이 아니고, 방문하지 않았으면
                if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                    if (graph[nx][ny] != '#' && distFire[nx][ny] == -1) {
                        qFire.add(new int[] {nx, ny});
                        distFire[nx][ny] = distFire[now[0]][now[1]] + 1;
                    }
                }
                
            }
        }
        

        // 지훈이 BFS 수행
        while (!qGH.isEmpty()) {
            int[] now = qGH.poll();
            
            // 4가지 방향 탐색
            for (int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                
                // 범위 벗어낫다면 탈출한 것으로 간주
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    System.out.println(distGH[now[0]][now[1]]+1);
                    return;
                }
                
                // 벽이거나, 방문했으면 pass
                if (graph[nx][ny] == '#' || distGH[nx][ny] >= 0) {
                    continue;
                }
                // 불의 시간보다 빨리 오지 못했다면
                if (distFire[nx][ny] != -1 && distFire[nx][ny] <= distGH[now[0]][now[1]]+1) {
                    continue;
                }
                qGH.add(new int[] {nx, ny});
                distGH[nx][ny] = distGH[now[0]][now[1]] + 1;
            }
        }
        System.out.println("IMPOSSIBLE");
        
    }
}


// 지훈
// 불 (4가지 방향으로 확산)


// # 벽
// . 지나갈 수 있는 공간
// J 지훈이 초기 위치
// F 불난 공간

// 미로의 가장 자리에 접하면 탈출가능
// 탈춣할 수 없다면 IMPOSSIBLE 출력


// 불 BFS로 먼저 시간 별로 이동할 수 있는 곳 체크

// 다음 지훈이 BFS로 불 시간 보다 작은 곳 이동 가능