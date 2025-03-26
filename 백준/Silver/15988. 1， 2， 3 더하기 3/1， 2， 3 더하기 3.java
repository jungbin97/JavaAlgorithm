import java.util.*;
import java.io.*;

public class Main {
    static long[] D = new long[1_000_001];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 테이블 정의
        D[1] = 1;
        D[2] = 2;
        D[3] = 4;
        

        for (int i = 4; i <= 1_000_000; i++) {
            D[i] = (D[i-1]+D[i-2]+D[i-3]) % 1_000_000_009;
        }
        
        int tc = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            // 정수
            n = Integer.parseInt(br.readLine());
                
            sb.append(D[n] + "\n");
        }
        System.out.println(sb.toString());
    }
}
