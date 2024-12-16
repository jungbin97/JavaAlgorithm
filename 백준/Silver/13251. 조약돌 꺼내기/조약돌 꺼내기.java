import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        // 색 종류
        int M = sc.nextInt();
        int[] D = new int[M];
        double[] probability = new double[M];

        int total = 0;
        for (int i = 0; i < M; i++) {
            D[i] = sc.nextInt();
            total += D[i];
        }

        int K = sc.nextInt();

        double answer = 0.0;
        
        for (int i = 0; i < M; i++) {
            if (D[i] >= K) {
                probability[i] = 1.0;
                for (int j = 0; j < K; j++) {
                    probability[i] *= (double) (D[i] - j) / (total - j);
                }
            }
            
            answer += probability[i];
        }

        System.out.println(answer);
    }
}