import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int Result = 0;
        
        long A[] = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 배열에 값 넣기
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // 오름차순 정렬
        Arrays.sort(A);

        for (int k = 0; k < N; k++) {
            int i = 0;
            int j = N-1;
            long find = A[k];
            
            // Two Pointer
            while (i < j) {
                if (A[i] + A[j] == find) {
                    // find 서로 다른 수 여야함.
                    if (i != k && j != k) {
                        Result++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                } else if (A[i] + A[j] < find) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        
        System.out.println(Result);
        br.close();
    }
}