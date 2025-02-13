import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 세로, 가로, 좌표 개수
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        int[][] graph = new int[m][n];
        for (int a = 0; a < k; a++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            for (int i = startY; i < endY; i++) {
                for (int j = startX; j < endX; j++) {
                    graph[i][j] = 1;
                }
            }
        }
        
        // 방문 체크 배열
        boolean[][] visited = new boolean[m][n];

        // 결과 리스트
        ArrayList<Integer> result = new ArrayList<>();

        // 전체 집합 개수
        int setCount = 0;

        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || graph[i][j] == 1) {
                    continue;
                }
                q.add(new int[] {i, j});
                visited[i][j] = true;
                setCount++;
                int width = 1;
                //bfs 수행 
                while (!q.isEmpty()) {
                    int[] now = q.poll();
                    int nowY = now[0];
                    int nowX = now[1];
                    
                    for (int d = 0; d < 4; d++) {
                        int nx = nowX + dx[d];
                        int ny = nowY + dy[d];
                        // 인덱스 체크 && 방문 체크 && 영역
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                            if (graph[ny][nx] != 1 && !visited[ny][nx]) {
                                visited[ny][nx] = true;
                                q.add(new int[] {ny, nx});
                                width++;
                            }
                        }
                    }
                }
                result.add(width);
            }
        }
        Collections.sort(result);

        // 출력
        System.out.println(setCount);

        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}


// 분리된 영역 개수
// 각 영역의 넓이 구하기 (오름차순 반환)