import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] T = new int[n+1];
        int[] P = new int[n+1];
        int[] D = new int[n+2];
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = n; i >= 1; i--) {
            if (i + T[i] <= n+1) {
                D[i] = Math.max(P[i] + D[i+T[i]], D[i+1]);
            } else {
                D[i] = D[i+1];
            }
        }
        
        System.out.print(D[1]);
    }
}
