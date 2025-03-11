import java.util.*;
import java.io.*;

public class Main {
    static int result = 0;
    static int[] D = new int[12];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int tc = Integer.parseInt(br.readLine());
        
        D[1] = 1;
        D[2] = 2;
        D[3] = 4;
        for (int i = 4; i <= 11; i++) {
            D[i] = D[i-1] + D[i-2] + D[i-3];
        }
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(D[n]);
        }
        
    }
}

// 점화식 구하기
// D[4] = ?
// 1+1+1+1, 3+1, 2+1+1, 1+2+1 => D[3] +1
// 1+1+2, 2+2 => D[2]+1
// 1+3 => D[1]+1

// D[4] = D[3]+D[2]+D[1]
// D[i] = D[i-1] + D[i-2] + D[i-3]

// 초기값
// D[1] = 1
// D[2] = 2
// D[3] = 4