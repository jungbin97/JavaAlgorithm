import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        // 시간, 이동 횟수, 나무 번호
        int[][][] D = new int[1001][31][3];
        int[] arr = new int[t+1];
        
        for (int i = 1; i <= t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        
        for (int i = 1; i <= t; i++) {
            for (int j = 0; j <= w; j++) {
                if (j == 0) {
                    // 한번도 이동하지 않을 경우
                    D[i][0][1] = D[i-1][0][1] + (arr[i] == 1 ? 1 : 0);
                } else {
                    D[i][j][1] = Math.max(D[i-1][j-1][2], D[i-1][j][1]) + (arr[i] == 1 ? 1 : 0);
                    D[i][j][2] = Math.max(D[i-1][j-1][1], D[i-1][j][2]) + (arr[i] == 2 ? 1 : 0);
                }
            }
        }
        
        int result = 0;
        for (int j = 0; j <= w; j++) {
            result = Math.max(D[t][j][1],result);
            result = Math.max(D[t][j][2],result);
        }
        
        System.out.println(result);
    }
}

// T, W

// D[i][j][k]: 현재 시간 i에서 j이동 횟수, k나무 번호

// 1초에 0번 이동, 1번 나무
// D[1][0][1] = 0
// 1초에 1번 이동, 2번 나무
// D[1][1][2] = 1
// 
// 2초에 0번 이동, 1번 나무
// D[2][0][1] = D[1][0][1] + if (arr[i] == 1 ? 1 : 0)

// 2초에 1번 이동, 1번 나무이면
// D[2][1][1] = math.max(D[1][0][2], D[1][1][1]) + 1
// D[i][j][1] = math.max(D[i-1][j-1][2], D[i-1][j][1]) + 1
// D[i][j][2] = math.max(D[i-1][j-1][2], D[i-1][j][1])
// 2초에 1번 이동, 2번 나무이면
// D[2][1][2] = math.max(D[1][0][1], D[1][1][2])
// D[i][j][2] = math.max(D[i-1][j-1][1], D[i-1][j][2]) + 1
// D[i][j][1] = math.max(D[i-1][j-1][2], D[i-1][j][1])