import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n+1];
        int[] D = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i= 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1; i <=n; i++) {
            D[i] = Math.max(arr[i], D[i-1]+arr[i]);
        }

        int result = -1000;
        for (int i = 1; i <= n; i++) {
            result = Math.max(D[i], result);
        }
        
        System.out.println(result);
    }
}



// 테이블 정의하기 
// D[i] i번째로 끝나는 연속항 최대 값

// 점화식 구하기
// D[i] = max(0, D[i-1]) + arr[i]
// 
// 초기값 세팅
// 시작 1부터