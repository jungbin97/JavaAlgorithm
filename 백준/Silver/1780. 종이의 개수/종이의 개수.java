import java.util.*;
import java.io.*;

public class Main {
    static int[][] paper;
    static int[] count = new int[3];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        paper = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        recursive(0, 0, n);
        
        for (int i = 0; i < 3; i++) {
            System.out.println(count[i]);
        }

    }

    static void recursive(int x, int y, int z) {
        // base condition
        if (check(x, y, z)) {
            count[paper[x][y]+1] += 1;
            return;
        }
        
        int n = z / 3;
        // 삼분할
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                recursive(x+i*n, y+j*n, n);
            }
        }

    }

    static boolean check(int x, int y, int n) {
        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if (paper[x][y] != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

// 모두 같은 수인지 체크
// 9 = 3^k