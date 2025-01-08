import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        Queue<int[]> q = new LinkedList<int[]>();
        
        
        int n = maps.length;
        int m = maps[0].length;
        
        // 방문 배열 초기화
        int[][] visited = new int[n][m];
        
        // 상하좌우
        int[] dx = new int[] {0, 1, -1, 0};
        int[] dy = new int[] {1, 0, 0, -1};
        
        // 시작 지점 세팅
        q.add(new int[] {0, 0});
        visited[0][0] = 1;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            // 4방향 체크
            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                
                // 배열 범위 체크 && maps == 1인지 체크 && 방문체크
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (maps[nx][ny] == 1 && visited[nx][ny]==0) {
                        visited[nx][ny] = visited[now[0]][now[1]] + 1;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }
        
        if (visited[n-1][m-1] == 0) {
            return -1;
        } else {
            return visited[n-1][m-1];
        }
        
    }
}


// maps가 1이면 이동가능, 0이면 이동불가
// 이동 칸수 별로 1증가
// bfs로 탐색 n-1, m-1에 도달할 수 있으면 이동칸수 출력, 없으면 -1출력