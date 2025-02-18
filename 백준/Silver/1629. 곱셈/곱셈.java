import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        System.out.println(pow(A, B, C));
        }
        
        private static long pow(long A, long B, long C) {
            // 지수가 0이면 항상 1
            if (B == 0) {
                return 1;
            }
            
            long half = pow(A, B/2, C);
            long result = (half * half % C);
            // B가 홀수일 경우 추가
            if (B%2 == 1) {
                result = (result * A) % C;
            }
            return result;
    }
    

}


// 10^11 % 12
// 10 % 12 = 10

// 10의 1승을 구할 수 있다.
// 10의 K승 10의 2K승도 구할 수 있음.
// (a X b X c) mod 10 = ((a mod 10) X (b mod 10) X (c mod 10)) mod 10


// a^k mod 10 = (a^k/2 mod 10) X (a^k/2 mod 10) X mod 10
// a^k+1 mod 10 = ((a^k/2 mod 10) X (a^k/2 mod 10) X (a mode 10)) mod 10