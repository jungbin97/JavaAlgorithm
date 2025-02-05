import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[201];
        
        for (int i = 0; i < n; i++) {
            // 음수 저장을 위해 0 => 100, 1 => 101
            int num = Integer.parseInt(st.nextToken());
            arr[num+100]++;
        }
        // 찾으려는 수
        int v = Integer.parseInt(br.readLine());

        int result = arr[v+100];
        
        System.out.println(result);
    }
}


