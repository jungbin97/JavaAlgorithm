import java.util.*;
import java.io.*;

public class Main {
    // 동서남북상하
    static int[] dx = {0, 1, -1, 0, 0, 0};
    static int[] dy = {1, 0, 0, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while (true) {
            st = new StringTokenizer(br.readLine());
            // 층수, 행, 열
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            
            // 0 0 0을 만나면 끝남.
            if (L == 0 & R == 0 && C == 0) {
                break;
            }
            
            Queue<int[]> q = new ArrayDeque<>();
            
            // 거리, 방문 체크 배열
            int dist[][][] = new int[L][R][C];
            for (int h = 0; h < L; h++) {
                for (int i = 0; i < R; i++) {
                    Arrays.fill(dist[h][i], -1);
                } 
            }

            // 그래프 초기화
            char[][][] graph = new char[L][R][C];
            for (int h = 0; h < L; h++) {
                for (int i = 0; i < R; i++) {
                    String line = br.readLine();
                    for (int j = 0; j < C; j++) {
                        graph[h][i][j] = line.charAt(j);
                        // 스타트 지점 찾기
                        if(graph[h][i][j] == 'S') {
                            q.add(new int[] {h, i, j});
                            dist[h][i][j] = 0;
                        }
                    }
                }
                br.readLine();
            }

            int result = 0;
            boolean escapeFlag = false;
            // bfs 수행
            while (!q.isEmpty()) {
                int[] now = q.poll();
                int nowH = now[0];
                int nowX = now[1];
                int nowY = now[2];
                
                // 탈출 조건, E
                if (graph[nowH][nowX][nowY] == 'E') {
                    result = dist[nowH][nowX][nowY];
                    escapeFlag = true;
                    break;
                }

                // 6가지 방향 탐색
                for (int d = 0; d < 6; d++) {
                    int nh = nowH + dh[d];
                    int nx = nowX + dx[d];
                    int ny = nowY + dy[d];
                    
                    // 인덱스 범위 && 갈수 있는 경로(!#) && 방문하지 않은
                    if (nh >= 0 && nx >= 0 && ny >=0 && nh < L && nx < R && ny < C) {
                        if (graph[nh][nx][ny] != '#' && dist[nh][nx][ny] == -1) {
                            dist[nh][nx][ny] = dist[nowH][nowX][nowY]+1;
                            q.add(new int[] {nh, nx, ny});
                        }
                    }
                }
            }
            
            if (escapeFlag) {
                System.out.println("Escaped in " + result + " minute(s).");
            } else {
                System.out.println("Trapped!");
            }


        }
    }
}

// #: 지나갈 수 없는
// .: 비어있는칸
// S: 시작점
// E: 출구