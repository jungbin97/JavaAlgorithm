import java.util.*;
import java.io.*;

public class Main {
    static int[][] data = new int[4][8];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                data[i][j] = line.charAt(j) - '0';
            }
        }
        
        StringTokenizer st;
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());
            gearOperate(idx, dir);
        }
        System.out.println(calCount());
        
    }

    static int calCount() {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            // 12시 방향 N극일떄
            if (data[i][0] == 0) {
                continue;
            }

            count += (int) Math.pow(2, i);
        }
        return count;
    }
    
    // 기어 연산
    static void gearOperate(int idx, int dir) {
        // 왼쪽
        left(idx-1, -dir);
        // 오른쪽
        right(idx+1, -dir);
        rotation(idx, dir);
    }

    static void left(int idx, int dir) {
        // base condition
        if (idx < 0) return;
        if (data[idx][2] == data[idx+1][6]) return;
        
        left(idx-1, -dir);
        rotation(idx, dir);
    }
    
    static void right(int idx, int dir) {
        // base condition
        if (idx > 3) return;
        if (data[idx][6] == data[idx-1][2]) return;
        
        right(idx+1, -dir);
        rotation(idx, dir);
    }
    
    // 회전하기
    static void rotation(int idx, int dir) {
        // 시계 방향
        if (dir == 1) {
            int tmp = data[idx][7];
            for (int i = 7; i > 0; i--) {
                data[idx][i] = data[idx][i-1];
            }
            data[idx][0] = tmp;
        // 반시계 방향
        } else {
            int tmp = data[idx][0];
            for (int i = 0; i < 7; i++) {
                data[idx][i] = data[idx][i+1];
            }
            data[idx][7] = tmp;
        }
    }
}



// N극 0, S극 1

// 1.맞닿아 있는 곳이 같은지 체크 (움직이지 않음, 회전 반대방향으로 움직임)
// - 2번 index, 6번 index

// 2.회전하기(시계방향, 반시계 방향)
// - 시계방향 오른쪽으로 한칸 밀기
// - 반시계 방향 왼쪽으로 한칸씩 밀기

// 점수 합산 계산하기
// 