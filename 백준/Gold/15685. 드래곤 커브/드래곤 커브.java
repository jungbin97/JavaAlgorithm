import java.util.*;
import java.io.*;

public class Main {
    static int n;
    // 오른쪽, 위쪽, 왼쪽, 아래쪽
    static int[] dx = {1, 0, -1, 0};  // x 좌표 변화 (열)
    static int[] dy = {0, -1, 0, 1};  // y 좌표 변화 (행)
    static int[][] board = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()); // 시작점 x
            int y = Integer.parseInt(st.nextToken()); // 시작점 y
            int d = Integer.parseInt(st.nextToken()); // 초기 방향
            int g = Integer.parseInt(st.nextToken()); // 세대

            drawDragonCurve(x, y, d, g);
        }

        int result = countDragonCurveSquares();
        System.out.println(result);
    }

    static void drawDragonCurve(int x, int y, int d, int g) {
        List<Integer> arrowList = new ArrayList<>(); // 방향 리스트
        board[y][x] = 1;

        // 0세대: 초기 이동 방향
        int endX = x + dx[d];
        int endY = y + dy[d];
        board[endY][endX] = 1;
        arrowList.add(d);

        // 세대별 드래곤 커브 생성
        for (int i = 0; i < g; i++) {
            int size = arrowList.size();
            for (int j = size - 1; j >= 0; j--) {
                int newD = (arrowList.get(j) + 1) % 4; // 90도 회전
                endX += dx[newD];
                endY += dy[newD];

                // 드래곤 커브 위치 업데이트
                board[endY][endX] = 1;
                arrowList.add(newD);
            }
        }
    }

    // 드래곤 커브 포함된 사각형 개수 구하기
    static int countDragonCurveSquares() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (board[i][j] == 1 && board[i + 1][j] == 1 &&
                    board[i][j + 1] == 1 && board[i + 1][j + 1] == 1) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
