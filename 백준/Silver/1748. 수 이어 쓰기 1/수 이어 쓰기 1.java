import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();

        // 자리수 구하기
        int len = String.valueOf(N).length();
        int result = 0;

        
        while (len > 1) {
            int start = Integer.parseInt("9".repeat(len-1));
            result += (N-start) *len;
            N = start;
            len--;
        }
        
        // len이 1일 때
        result += N; // 1의 자리수 더하기

        System.out.println(result);

    }
}



// 1~9 
// => 자리수와 동일

// 10 ~ 99
// => 2개씩 늘어남

// 예) 15면 = 1234....9 + (6 * 2) = 9+12 = 21자리


// 예)120면

// 3자리 수
// 120 - 99 = 21

// 2자리 수
// 99 - 9 = 90

// 1자리수
// 9


// 21 * 3 + 90 * 2 + 9


// n = 120
// 1. N자리수 확인, len(n)
// 2. len(n) = 3이면 n - ('9' * len(n-1)) = 21
// 3. result += 21 * len(n)