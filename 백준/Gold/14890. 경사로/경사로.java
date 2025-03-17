import java.util.*;
import java.io.*;

public class Main {
    static int n, l;
    
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        // 맵 초기화
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        
        int result1 = countPassablePath();
        int result2 = rotationAndcountPassablePath();
        System.out.println(result1+result2);
    }

    static int rotationAndcountPassablePath() {
        int[][] copyMap = new int[n][n];
        int result = 0;
        
        // 맵 복사
        for (int i = 0; i < n; i++) {
            copyMap[i] = map[i].clone();
        }
        
        // 회전 로직(시계 방향 90도)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copyMap[j][n-1-i] = map[i][j];
            }
        }
        
        map = copyMap;
        result = countPassablePath();
        return result;
    }
    

    // 지나갈수 있는 길 구하기 
    static int countPassablePath() {
        int result = 0;
        for (int i = 0; i<n; i++) {
            if (checkRow(map[i])) {
                result++;
            }
        }
        return result;
    };
    
    static boolean checkRow(int[] row) {
        boolean[] checkIncline = new boolean[n];

        for (int j = 0; j < n-1; j++) {
            // 현재 보다 1개 큰게 나온 경우
            if (row[j] < row[j+1] && row[j+1]-row[j] == 1) {
                for (int k = 0; k < l; k++) {
                    int index = j - k;
                    // 범위 넘어가면 해당 행 종료, 칸 높이가 다를 경우도 종료, 이미 경사로여도 종료
                    if (index < 0 || row[index] != row[j] || checkIncline[index]) {
                        return false;
                    }
                    
                }
                // 경사로 설치
                for (int k = 0; k < l; k++) {
                    checkIncline[j-k] = true;
                }
                
            // 현재 보다 1개 작은게 나온 경우
            } else if (row[j] > row[j+1] && row[j]-row[j+1] == 1) {
                for(int k = 1; k <= l; k++) {
                    int index = j + k;
                    // 범위 넘어가면 해당 행 종료, 칸 높이가 다를 경우도 종료, 이미 경사로여도 종료
                    if (index >= n || row[j+1] != row[index] || checkIncline[index]) {
                        return false;
                    }
                }
                
                for (int k = 1; k <= l; k++) {
                    checkIncline[j+k] = true;
                }
                j += (l-1);
            // 높이차가 2이상
            } else if (Math.abs(row[j+1] - row[j]) >= 2) {
                return false;
            }
        }
        return true;
    }
}

// 지나 갈 수 있는 길
// 1. 길을 지나갈려면 모든 칸의 높이가 같아야함(하나의 행, 하나의 열)
// 2. 경사로를 놓아 지나갈 수 있는 길을 만들 수 있음. 길이는 L(낮은 칸과 높은 칸을 연결함.)
// - 경사로는 낮은 칸에 놓음. 낮은 칸은 높이가 모두 같아야함.
// - 낮은 칸과 높은 칸의 높이차 1이여야함.
// - 경사로 끼리 겹처서는 안됨.



// 구현
// 1. 맵 한줄씩 체크, 맵 회전 열 -> 행으로
// 2. 경사로 구현
// - 1개 큰게 나온  경우, L 만큼 이전 길이 체크, 범위 넘는지 체크, 경사로 방문체크
// - 1개 작은게 나온 경우, L 만큼 뒤 길이 체크, 범위 넘는지 체크, 경사로 체크 => 체크
// 
// - 경사로가 세워진다면, 작은 부분 방문처리