import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            // 국가 수, 비행기 종류
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
            }
            
            System.out.println(n-1);
        }

    }
}