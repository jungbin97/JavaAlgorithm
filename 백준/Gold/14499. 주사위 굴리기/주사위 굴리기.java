import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int n, m, x, y, k;
    static int[] dice = new int[6];

    // 1:동, 2: 서, 3:북, 4:남
    static int[][] d = {{}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 세로 크기, 가로 크기, 주사위 좌표, 명령개수
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        // 지도 초기화
        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 명령어 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) {
            int command = Integer.parseInt(st.nextToken());
            
            int nx = x + d[command][0];
            int ny = y + d[command][1];
            // 범위 체크
            if (!rangeCheck(nx, ny)) {
                continue;
            }
            x = nx;
            y = ny;


            // 주사위 굴리기
            diceRolling(command);
            
            // 주사위가 이동한 칸이 0이면 주사위 바닥면 수가 지도로 복사
            // 주사위가 이동한 칸이 0이 아닌경우면 지도 칸에 쓰여있는 수가 주사위로 복사, 칸은 0이됨.
            if (map[x][y] == 0) {
                map[x][y] = dice[3];
                
            } else if(map[x][y] != 0) {
                dice[3] = map[x][y];
                map[x][y] = 0;
            }
            
            // top값 출력
            System.out.println(dice[5]);
        }
        
    }

    // 주사위 굴리기
    static void diceRolling(int command) {
        // 왼쪽면, 오른쪽면, 북쪽면, 바닥면, 남쪽면, 윗면
        int left = dice[0];
        int right = dice[1];
        int front = dice[2];
        int bottom = dice[3];
        int back = dice[4];
        int top = dice[5];

        // 1.동쪽으로
        if (command == 1) {
            dice[0] = bottom;
            dice[1] = top;
            dice[2] = front;
            dice[3] = right;
            dice[4] = back;
            dice[5] = left;
        // 2.서쪽으로
        } else if (command == 2) {
            dice[5] = right;
            dice[3] = left;
            dice[2] = front;
            dice[4] = back;
            dice[0] = top;
            dice[1] = bottom; 
        // 3.북
        } else if(command == 3)  {
            dice[0] = left;
            dice[1] = right;
            dice[3] = front;
            dice[4] = bottom;
            dice[5] = back;
            dice[2] = top;
        } else if (command == 4) {
            // 4.남
            dice[0] = left;
            dice[1] = right;
            dice[5] = front;
            dice[2] = bottom;
            dice[3] = back;
            dice[4] = top;
        }
        
    }
    

    // 범위 체크
    static boolean rangeCheck(int x, int y) {
        // 올바른 범위를 넘어서면
        if (x < 0 || y < 0 || x >= n || y >= m) {
            return false;
        }
        return true;
    }

}


// 세로 크기 N, 가로크기 M, 주사위 좌표 X, Y, 명령개수 K

// 지도
// 0 2
// 3 4
// 5 6
// 7 8

// 주사위 좌표: (0, 0) 
// 이동 명령: 8

// 1:동, 2: 서, 3:북, 4:남
// 남남남동북북북서


// 주사위는 모든 면이 처음 0
// 주사위가 이동한 칸이 0이면 주사위 바닥면 수가 지도로 복사
// 주사위가 이동한 칸이 0이 아닌경우면 지도 칸에 쓰여있는 수가 주사위로 복사, 칸은 0이됨.

// 0
