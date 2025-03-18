import java.util.*;
import java.io.*;

public class Main {
    static int n, m, h;
    static boolean[][] board;
    static boolean escape = false;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 세로 선 개수, 놓을수 있는 가로선 개수, 가로 점선 개수(n, m, h)
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        board = new boolean[32][12];


        // 가로선의 정보(a, b)
        // a가로 점선에서 b와 b+1을 가로선 연결
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a][b] = true;
        }
        
        // 0~3개까지 놓아보면서 검사
        for (int i = 0; i <= 3; i++) {
            // 적은값에서 찾으면 그게 최솟값
            makeHorizontalLine(0, i);
            if (result != Integer.MAX_VALUE) {
                break;
            }
        }
        
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    // 추가 가로선 놓기
    static void makeHorizontalLine(int depth, int maxDepth) {
        // base condition
        if (depth == maxDepth) {
            // i => i인지 체크
            if (checkItoI()) {
                result = Math.min(result, depth);
            }
            return;
        }
        
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                // 놓을 수 있는 곳인지 확인
                if (!checkHorizontalLine(i, j)) {
                    continue;
                }

                board[i][j] = true;
                makeHorizontalLine(depth+1, maxDepth);
                board[i][j] = false;
            }
        }
    }
    
    // 놓을 수 있는 곳인지 확인
    static boolean checkHorizontalLine(int x, int y) {
        // 범위 이내인지 체크, 해당위치 이미 방문한곳이지 체크
        if (x < 1 || y < 1 || x > h || y >= n) {
            return false;
        }
        
        // 1) 이미 (x, y)에 존재하면 불가능
        if (board[x][y]) return false;
        
        if (board[x][y-1] || board[x][y+1]) {
            return false;
        }

        return true;
    }
    
    // i => i인지 체크
    static boolean checkItoI() {
        // 세로
        for (int i = 1; i <= n; i++) {
            int position = i; // 현재 세로선 위치
            for (int j = 1; j <= h; j++) {
                // 오른쪽 이동
                if (position < n && board[j][position]) {
                    position++;
                // 왼쪽 이동
                } else if (position > 1 && board[j][position-1]) {
                    position--;
                }
            }
            
            // 최종 위치가 시작 위치랑 다르면
            if (position != i) {
                return false;
            }
        }
        
        return true;
    }
}

// i번의 세로선의 결과가 i번이 나오도록 하기 위한, 추가 가로선 개수 최솟값 출력하기
// 불가능한 경우 -1, 가로선 개수 최솟값이 3보다 큰 경우 -1

// 가로선 긋는 기준
// 1. 초록선과 가로 점선이 교차하는 지점에 가로선 놓을 수 있는 점이 있다.
// 2. 가로선은 인접한 가로선 놓을 수 있는 점을 연결한다.
// 3. 두 가로선이 연속되거나, 서로 접하면 안됨.
// 
//
// 
// 가로, 세로 점선 배열 초기화 boolean[h+1][n+1]
// 가로선 정보 점위치 방문처리, a번째줄, board[a][b] = true, board[a][b+1] = true
// 
// 추가 가로선 놓기(완전 탐색, 백트레킹)
// base codition
// - depth 3이면, return

// 가로선 줄긋기 수행
// i번 -> i인지 체크(ture면 갱신 후, 종료)
// false면 depth 수행
// 