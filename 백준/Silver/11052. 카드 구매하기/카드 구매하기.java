import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 구매하려는 카드 개수
        int n = Integer.parseInt(br.readLine());
        
        int[] D = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                D[i] = Math.max(D[i], D[i-j] + D[j]);
            }
        }
        
        System.out.println(D[n]);
    }
}



// 최대한 많은 금액을 지불해야한다.
// 

// 테이블 구하기
// D[i] i개의 카드를 고를 때 최대 비용

// D[4] = max(D[1]* 4, D[2] * 2, D[3]+D[1], D[4])