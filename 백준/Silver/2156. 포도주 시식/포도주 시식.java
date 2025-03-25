import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 포도주 잔의 개수
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n+1];
        int[] D = new int[n+1];
        
        for (int i = 1; i<=n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        D[1] = arr[1];
        if (n > 1) {
            D[2] = arr[1]+arr[2];
        }
        for (int i = 3; i <= n; i++) {
            D[i] = Math.max(D[i-1], Math.max(D[i-2]+arr[i], D[i-3]+arr[i-1]+arr[i]));
        }
        
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, D[i]);
        }
        System.out.println(result);
    }
}

// 테이블 정의하기
// D[i] i번째일때 포도주 최댓값
// 
// 점화식 구하기
// D[i] = max(D[i-1], D[i-2] + arr[i], D[i-3]+arr[i-1]+arr[i])

// 초기값 구하기
// D[0] = 0;
// D[1] = 6;
// D[2] = 16;