import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 수 개수, 합을 구해야하는 횟수
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] D = new int[n+1];
        int[] A = new int[n+1];

        D[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <=n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            D[i] = D[i-1] + A[i];
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            System.out.println(D[end] - D[start-1]);
            }
    }
}

// 시간 복잡도 O(NM) = 100억

// D[1] = 5
// D[2] = 9
// D[3] = 12

// 2 ~ 3 = D[3] - D[1] = 12-5 = 7
// 
// 
// 테이블 정의하기
// D[i] = A[1] + A[2] .. + A[i] 
// D[i] = D[i-1] + A[i]

// 점화식
// A[i] + A[i+1] ... + A[j]
// D[j] - D[i-1]
// 

// 초기값 세팅
// D[0] = 0