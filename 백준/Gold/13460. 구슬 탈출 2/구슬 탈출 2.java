import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    static int redX, redY, blueX, blueY;
    static int holeX, holeY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 세로, 가로
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        visited = new boolean[n][m][n][m];

        // 보드 초기화
        board = new char[n][m];
        for (int i = 0; i < n; i++)  {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
                
                if (board[i][j] == 'R') {
                    redX = i;
                    redY = j;
                } else if (board[i][j] == 'B') {
                    blueX = i;
                    blueY = j;
                } else if  (board[i][j] == 'O') {
                    holeX = i;
                    holeY = j;
                }
            }
        }
        
        int result = bfs();
        
        System.out.println(result);
    }
    
    static int bfs() {
        Queue<int []> q = new ArrayDeque<>();
        q.add(new int[] {redX, redY, blueX, blueY, 0});
        visited[redX][redY][blueX][blueY] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowRedX = now[0];
            int nowRedY = now[1];
            int nowBlueX = now[2];
            int nowBlueY = now[3];
            int nowMoveCount = now[4];
            
            // 10번 초과시 실패
            if (nowMoveCount >= 10) {
                return -1;
            }
            
            // 4방향 탐색
            for (int d = 0; d < 4; d++) {
                int[] redMove = move(nowRedX, nowRedY, dx[d], dy[d]);
                int[] blueMove = move(nowBlueX, nowBlueY, dx[d], dy[d]);
                
                int newRedX = redMove[0], newRedY = redMove[1], redDist = redMove[2];
                int newBlueX = blueMove[0], newBlueY = blueMove[1], blueDist = blueMove[2];

                // 파란 구슬이 빠지면 해당 경로 폐기
                if (newBlueX == holeX && newBlueY == holeY) {
                    continue;
                }
                
                // 빨간 구슬만 구멍에 빠지면 정답   
                if (newRedX == holeX && newRedY == holeY) {
                    return nowMoveCount+1;
                }
                
                // 두 구슬이 같은 위치면? 이동거리가 긴 구슬 뒤로 한칸 이동
                if (newRedX == newBlueX && newRedY == newBlueY) {
                    if (redDist > blueDist) {
                        newRedX -= dx[d];
                        newRedY -= dy[d];
                    } else {
                        newBlueX -= dx[d];
                        newBlueY -= dy[d];
                    }
                }
                

                // 방문하지 않은 상태라면 큐 삽입
                if (!visited[newRedX][newRedY][newBlueX][newBlueY]) {
                    visited[newRedX][newRedY][newBlueX][newBlueY] = true;
                    q.add(new int[] {newRedX, newRedY, newBlueX, newBlueY, nowMoveCount+1});
                }
            }
        }
        return -1;
    }
    
    static int[] move(int x, int y, int dx, int dy) {
        int distance = 0;
        
        while(true) {
            int nx = x + dx;
            int ny = y + dy;
            
            // 벽 만나면 멈춤
            if (board[nx][ny] == '#') {
                break;
            }
            
            // 구멍 만나면
            if (nx == holeX && ny == holeY) {
                return new int[] {nx, ny, distance+1};
            }
            x = nx;
            y = ny;
            distance++;
        }
        
        return new int[] {x, y, distance};
    }
}


// .: 빈칸, #: 벽, 0: 구멍 위치, R: 빨간 구슬 위치, B: 파란 구슬 위치


// 게임 -1 반환 조건
// 파란 구슬이 구멍에 빠지면 실패
// 빨강, 파랑 구슬 동시에 빠져도 실패
// 10이하의 기울기 횟수에 빨간 구슬 못빼면 실패
// 
// 
// 구슬 이동 동작 방식
// 1. BFS로 한방향으로 이동, 벽을 만나면 방향전환, 방향 전환시 기울이기 횟수 +1
// 2. 구멍을 만나면 