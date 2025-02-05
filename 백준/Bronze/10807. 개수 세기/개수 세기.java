import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 찾으려는 수
        int v = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (v == arr[i]) {
                result++;
            }
        }
        
        System.out.println(result);
    }
}


