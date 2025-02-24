import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    static int[] result = new int[3];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0, 0, n);
        
        for (int i = 1; i <= 2; i++) {
            System.out.println(result[i]);
        }
    }

    static void recursive(int x, int y, int n) {
        if (check(x, y, n)) {
            result[arr[x][y]+1] += 1;
            return;
        }
        
        // 같지않다면 쪼개기
        n /= 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                recursive(x + i * n, y + j * n, n);
            }
        }
        
    }
    
    static boolean check(int x, int y, int n) {
        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if (arr[x][y] != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}


// n = 1,  2 X 2크기
// 모두 같은지 체크
// 같으면 색깔 체크 + 1
// 같지 않다면 쪼개기 n = 0
// n = 0, 1 X 1크기
// 모두 같은지 체크
// 같으면 색깔 체크 + 1...


// base condition
// n = 0 1 X 1크기
// 모두같으면 탈출


// n = 3, 8 x 8
// 모두 같은지 체크
// 같으면 탈출..

// 같잊 않으면
// n/2로 쪼개 재귀
// 
