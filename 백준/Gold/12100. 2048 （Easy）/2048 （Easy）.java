import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    static int maxBlock;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 보드 크기
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n][n];
        for (int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        maxBlock = 0;
        dfs(0);
        System.out.println(maxBlock);

    }
    
    // DFS 백트래킹
    static void dfs(int depth) {
        if (depth == 5) {
            maxBlock = Math.max(maxBlock, getMaxBlock());
            return;
        }
        
        int[][] original = copyBoard(); // 원본 저장
        
        for (int dir = 0; dir < 4; dir++) {
            tilt(dir); // 보드 기울이기
            dfs(depth+1);
            restoreBoard(original);
        }
    }
    
    // 기울이기 (dir: 0왼쪽, 1위쪽, 2오른쪽, 3아래쪽)
    static void tilt(int dir) {
        for (int d = 0; d < dir; d++) {
            rotate();
        }
        
        for (int i = 0; i < n; i++) {
            int[] tilted = new int[n];
            boolean[] merged = new boolean[n];
            int insertPos = 0;

            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) continue;

                if (insertPos > 0 && tilted[insertPos-1] == arr[i][j] && !merged[insertPos-1]) {
                    // 이전 숫자와 같고, 아직 합쳐지지 않은 경우
                    tilted[insertPos-1] *= 2;
                    merged[insertPos-1] = true;
                } else {
                    tilted[insertPos++] = arr[i][j];
                }
            }
            
            // 보드 갱신
            for (int j = 0; j < n; j++) {
                arr[i][j] = tilted[j];
            }
        }
        
        // 원래 방향으로 복구
        for (int i = 0; i < (4-dir) % 4; i++) {
            rotate();
        }
    }
    
    // 시계방향 90도 회전
    static void rotate() {
        int[][] tmp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[j][n-1-i] = arr[i][j];
            }
        }
        
        arr = tmp;
    }
    
    // 보드에서 가장 큰 블록 찾기
    static int getMaxBlock() {
        int maxVal = 0;
        for (int[] row : arr) {
            for (int num : row) {
                maxVal = Math.max(num, maxVal);
            }
        }
        return maxVal;
    }
    
    // 보드 복사 (깊은 복사)
    static int[][] copyBoard() {
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            copy[i] = arr[i].clone();
        }
        return copy;
    }

    
    // 보드 복구
    static void restoreBoard(int[][] original) {
        for (int i = 0; i < n; i++) {
            arr[i] = original[i].clone();
        }
    }
    
}

// 5번 이동해서 만들 수 있는 가장 큰 블록 값 구하기
// 같은 값을 가진 블럭은 합쳐진다.



// 1. 게임판을 상하좌우로 기울여서 합치기
// 2. 5번 기울이는 방향 정하기


// 왼쪽으로 기울이기
// [0,2,0,2,8,8,0,16] -> [4,16,16,0,0,0,0,0]
// 이미합쳐진 불록은 다시 합쳐질수 없음.
// 회전으로 처리
// 왼쪽으로 기울이기 -> 0도 회전 -> 0번
// 아래쪽으로 기울이기 -> 90도 회전 -> 1번
// 오른쪽 기울이기 -> 180도 회전 -> 2번
// 위쪽으로 기울이기 -> 270도 회전 -> 3번