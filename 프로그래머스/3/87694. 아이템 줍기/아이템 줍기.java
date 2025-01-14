import java.util.*;

class Solution {
    static int[][] map;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int answer = 0;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 맵 초기화 (2배)
        map = new int[101][101];
        
        // 직사각형 맵에 초기화(x1, y1, x2, y2)
        for (int i = 0; i < rectangle.length; i++) {
            fill(2*rectangle[i][0], 2*rectangle[i][1], 2*rectangle[i][2], 2*rectangle[i][3]);
        }
        
        // bfs 수행(캐릭터 좌표, 아이템 좌표)
        bfs(2*characterX, 2*characterY, 2*itemX, 2*itemY);
        
        
        return answer;
    }
    
    // 맵에 직사가가형 그리기
    public static void fill(int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (map[i][j] == 2) {
                    continue;
                }
                // 테두리는 1로 초기화
                if (i==x1||j==y1||i==x2||j==y2) {
                    map[i][j] = 1;
                } else {
                    // 직사각형 내부 2로 초기화
                    map[i][j] = 2;
                }
            }
        }
    }
    
    // bfs 수행
    public static void bfs(int characterX, int characterY, int itemX, int itemY) {
        int[][] visited = new int[101][101];
        Queue<int[]> q = new LinkedList<>();
        
        // 시작 위치 설정
        visited[characterX][characterY] = 1;
        int[] startNode = new int[] {characterX, characterY, 0};
        q.add(startNode);
        
        
        while (!q.isEmpty()) {
            int[] nowNode = q.poll(); 
            int nowNodeX = nowNode[0];
            int nowNodeY = nowNode[1];
            int nowCount = nowNode[2];
            
            // 탈출 조건(아이템 위치인 경우)
            if (nowNodeX == itemX && nowNodeY == itemY) {
                answer = (nowCount+1)/2;
                System.out.println("최종 결과 값 : " + answer);
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = nowNodeX + dx[i];
                int ny = nowNodeY + dy[i];
                
                // 범위 체크
                if (nx >= 0 && ny >= 0 && nx < 101 && ny < 101) {
                    // 방문 체크 && 직사각형 테두리(1) 인지
                    if (visited[nx][ny] == 0 && map[nx][ny] == 1) {
                        visited[nx][ny] = 1;
                        q.add(new int[] {nx, ny, nowCount+1});
                    }
                }
            }
        }
    }
    
}
