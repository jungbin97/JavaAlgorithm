import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        // 0 | 1 2 3 4 5 6 7 | 8
        int[] D = new int[N+2];
        
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        
        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        
        for (int i = N; i > 0; i--) {
            if (i + T[i] > N+1) {
                D[i] = D[i+1];
            } else {
                D[i] = Math.max(D[i+1], P[i] + D[i+T[i]]);
            }
        }
        System.out.println(D[1]);
    }
}