import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[N];
        int max = arr[0];
        dp[0] = arr[0];
        
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}



//     [10 -4 3 1 5 6]
// dp= [10, 6, 9, 10, 15, 21]
// (arr[i], dp[i-1], arr[i])




