import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] D = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < n; i++) {
            D[i] = arr[i];
        }
        
        // 시간복잡도 O(1_000_000)보단 작음.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    D[i] = Math.max(D[i], D[j] + arr[i]);
                }
            }
        }

        
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, D[i]);
        }
        System.out.println(result);
    }
}



// 증가 하는 부분 수열 중 합이 가장 큰것 구하기


// 테이블 정의하기
// D[i]: i번째 값이 포함되는 크기가 증가하는 부분수열의 가장 큰값

// 점화식
// if (arr[j] < arr[i]) {
//  arr[i] = max(D[j]+arr[i], D[i]);
// }


// 초기값
// D[i] = arr[i];