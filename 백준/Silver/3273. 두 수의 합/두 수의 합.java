import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        boolean[] check = new boolean[2000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int target = Integer.parseInt(br.readLine());
        int result = 0;
        
        // 투포인터 없이, 공간복잡도 활용
        for (int i = 0; i < n; i++) {
            if (target-arr[i] > 0 && check[target-arr[i]]) {
                result++;
            }
            check[arr[i]] = true;
        }

        
        System.out.println(result);
    }
}


// 정렬?
// 1 2 3 5 7 9 10 11 12
// target = 13

// 정렬 없이
// 5 12 7 10 9 1 2 3 11
// target = 13
// 13 - 5 => 7 => 아직체크안함 pass => check[5] = true
// ... 
// 13 - 7 = 5 => 있음 => count++