import java.util.*;
import java.io.*;

public class Main {
    static long[][] D;
    public static void main(String[] args) throws Exception {
        D = new long[31][31];

        for (int i = 0; i <= 30; i++) {
            D[i][0] = 1;
            D[i][1] = i;
            D[i][i] = 1;
        }
        
        for (int i = 2; i <= 30; i++) {
            for (int j = 1; j < i; j++) {
                D[i][j] = D[i-1][j] + D[i-1][j-1];
            }
        }
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            System.out.println(D[m][n]);
        }
    }
}