import java.util.*;
import java.io.*;

public class Main {
    // 나이트 8방향 정의
    static int[] dx = new int[] {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = new int[] {1, 2, 2, 1, -1, -2, -2, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            // 체스판 길이
            int n = Integer.parseInt(br.readLine());
            
            st = new StringTokenizer(br.readLine());
            // 나이트 현재 위치
            int[] knight = new int[2];
            knight[0] = Integer.parseInt(st.nextToken());
            knight[1] = Integer.parseInt(st.nextToken());
            

            // 나이트 목표 위치
            st = new StringTokenizer(br.readLine());
            int[] target = new int[2];
            target[0] = Integer.parseInt(st.nextToken());
            target[1] = Integer.parseInt(st.nextToken());

            // 방문체크 배열 초기화
            boolean[][] visited = new boolean[n][n];

            Queue<int[]> q = new ArrayDeque<>();

            q.add(new int[] {knight[0], knight[1], 0});
            visited[knight[0]][knight[1]] = true;

            int result = 0;
            while(!q.isEmpty()) {
                int[] now = q.poll();
                int nowX = now[0];
                int nowY = now[1];
                int count = now[2];

                // 탈출 조건 도착위치 도달
                if (nowX == target[0] && nowY == target[1]) {
                    result = count;
                    break;
                }

                for (int d = 0; d < 8; d++) {
                    int nx = nowX + dx[d];
                    int ny = nowY + dy[d];

                    // 인덱스 범위 체크 && 방문체크
                    if (0 <= nx && 0 <= ny && n > nx && n > ny) {
                        if (!visited[nx][ny]) {
                            q.add(new int[] {nx, ny, count+1});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }

            System.out.println(result);
        }
    }
}

// 나이트 최소 이동 거리 출력하기