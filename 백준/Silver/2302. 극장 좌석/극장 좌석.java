import java.util.*;
import java.io.*;

public class Main {
    static int[] D = new int[41];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 좌석 개수
        int n = Integer.parseInt(br.readLine());
        // 고정석 개수
        int m = Integer.parseInt(br.readLine());
        // 고정석 위치(작은수부터 큰수)
        int[] vip = new int[m];
        for (int i = 0; i < m; i++) {
            vip[i] = Integer.parseInt(br.readLine());
        }
        D[0] = 1;
        D[1] = 1;
        D[2] = 2;

        for (int i = 3; i <= n; i++) {
            D[i] = D[i-1] + D[i-2];
        }
        
        int answer = 1;
        int preIdx = 0;
        for (int idx : vip) {
            answer *= D[idx - preIdx -1];
            preIdx = idx;
        }
        
        // 마지막 좌석
        answer *= D[n-preIdx];
        System.out.println(answer);
    }
}

// D[i]: 좌석이 i개일때 앉을 수 있는 경우의 수
//
// D[1] = 1;
// D[2] = 2 => (1, 2), (2, 1)
// D[3] = 3 
// D[4] = 5