import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt();
        int n = sc.nextInt();
        
        int[] A = new int[n+1];
        for (int i = 2; i <= n; i++) {
            A[i] = i;
        }
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (A[i] == 0) {
                continue;
            }
            for (int j = i+i; j <= n; j = j+i) {
                A[j] = 0;
            }
        }
        
        for (int i = m; i <= n; i++) {
            if (A[i] != 0) {
                System.out.println(A[i]);
            } 
        }
    }
}