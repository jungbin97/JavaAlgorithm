import java.util.*;
import java.io.*;

public class Main {
    // 위,오른쪽, 아래쪽, 왼쪽
    static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 보드크기
        int n = Integer.parseInt(br.readLine());
        // 사과 개수
        int k = Integer.parseInt(br.readLine());
        
        // 보드 초기화 및 사과 위치 입력
        StringTokenizer st;
        int[][] board = new int[n+1][n+1];
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = 1;
        }
        
        // 뱀 방향 변환 개수
        int l = Integer.parseInt(br.readLine());
        int[] time = new int[l];
        char[] d = new char[l];
        
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            d[i] = st.nextToken().charAt(0);
        }
        
        // 뱀 정보(좌표, 몸길이)
        int snakeX = 1;
        int snakeY = 1;
        board[snakeX][snakeY] = -1;

        // 스네이크 좌표
        Queue<int[]> snakeQ = new ArrayDeque<>();
        snakeQ.add(new int[] {snakeX, snakeY});

        int snakeDirection = 1; // 1: 오른쪽
        int dIndex = 0;
        int nowTime = 0;
        // 시뮬레이션 시작
        while(true) {
            nowTime++;

            // 위치 이동
            int nx = snakeX + direction[snakeDirection][0];
            int ny = snakeY + direction[snakeDirection][1];

            // 범위 체크 및 자기 몸톰인지 체크
            if (nx < 1 || ny < 1 || nx > n || ny > n || board[nx][ny] == -1) {
                break;
            }

            // 사과가 없다면, 꼬리칸 비워줌
            if (board[nx][ny] != 1) {
                int[] tail = snakeQ.poll();
                board[tail[0]][tail[1]] = 0;
            // 사과면 사과 제거
            } else {
                board[nx][ny] = 0;
            }

            snakeX = nx;
            snakeY = ny;
            board[snakeX][snakeY] = -1;
            snakeQ.add(new int[] {snakeX, snakeY});

            // 방향 변경하는지 체크
            if (dIndex < l && time[dIndex] == nowTime) {
                // 왼쪽 회전(0 -> 3, 1 -> 0, 2 -> 1)
                if (d[dIndex] == 'L') {
                    snakeDirection = (snakeDirection + 3)%4;
                // 오른쪽 회전(0->1, 1->2, 3->0)
                } else {
                    snakeDirection = (snakeDirection+1)%4;
                }
                dIndex++;
            }
        }
        
        System.out.println(nowTime);
    }
}

// L: 왼쪽으로 90도 회전, D: 오른쪽으로 90도 회전

// 뱀 초기위치: 맨위 왼쪽, 길이: 1
// 사과 1, 뱀: -1

// 게임이 끝나는 초를 구할 것.
// 1. 매초 뱀은 몸길이를 늘려 머리를 다음칸 위치
// 2. 벽이나 자기 자신 몸만나면 게임 끝날 것.
// 3. 이동칸에 사과가 있다면, 사과는 제거, 꼬리는 움직이지 않음(몸이 늘어난다?)
// 4. 이동칸에 사과가 없다면, 몸길이를 줄여 꼬리칸 비워줌(몸 길이는 같다)