import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 레슨 수
        int n = Integer.parseInt(st.nextToken());
        // 블루레이 개수
        int m = Integer.parseInt(st.nextToken());
        
        int[] A = new int[n];
        
        int start = 0;
        int end = 0;
        // 배열 초기화
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            // 시작 인덱스 최대 레슨 시간
            if (start < A[i]) {
                start = A[i];
            }
            // 종료 인덱스 총합 레슨 시간
            end = end + A[i];
        }
        
        while (start <= end) {
            int mid = (start+end)/2;
            
            int sum = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                // 중간값 초과 시 블루레이 소모
                if (sum + A[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum = sum + A[i];
            }
            
            // 탐색후 0이 아니면 블루레이 1추가
            if (sum != 0) {
                count++;
            }

            if (count > m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start);
    }
}