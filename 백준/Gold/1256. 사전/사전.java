import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        // N(a의 개수), M(z의 개수), K
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        
        long[][] DP = new long[202][202];
        
        
        // DP 초기화: 조합 수 계산
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    DP[i][j] = 1;
                } else {
                    DP[i][j] = DP[i - 1][j] + DP[i - 1][j - 1];
                    if (DP[i][j] > 1_000_000_000_000L) DP[i][j] = 1_000_000_000_001L; // 안전한 범위 제한
                }
            }
        }
        
        if (DP[N+M][M] < K) {
            System.out.println("-1");
            return;
        }

        // 문자열 만들기
        StringBuilder result = new StringBuilder();
        while (!(N == 0 && M == 0)) {
            // a를 선택한 경우의 수
            long aCount = (N > 0) ? DP[N+M-1][M] : 0;
            if (K <= aCount) {
                result.append("a");
                N--;
            } else {
                result.append("z");
                K -= aCount;
                M--;
            }
        }
        
        System.out.println(result.toString());
    }
}


// 2개 z 2개 k가 2인경우
// aazz 1번
// azaz 2번
// azza 3번
// zaaz 4번
// zaza 5번
// zzaa 6번


// a를 사용하는 경우
// 3C2 => 3가지 > k


// a = 1, z = 2
// 현재 a _ _ _
// 2C2 = 1 < k
// k - 1 = 1

//  a z _ _


// a = 1 z = 1
// 현재 a z _ _
// 1C1 = 1 >= k (1)
// a z a _

//  a = 0 z = 1
//  a z a z
//  0C1 = 0 < K = 1
