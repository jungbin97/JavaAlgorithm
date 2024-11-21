import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        
        // 배열 초기화
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // 오름차순 정렬
        Arrays.sort(A);
        
        // 찾을 수 갯수
        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < m; i++) {
            int find = Integer.parseInt(st.nextToken());
            
            
            if (binarySearch(A, find)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
        
        
    }
    
    public static boolean binarySearch(int[] A, int find) {
        int start = 0;
        int end = A.length-1;
        
        
        while(start <= end) {
            int midIndex = (start + end) / 2;
            int midValue = A[midIndex];
            
            // midValue 값이 target 값보다 크면 end조정
            if (midValue > find) {
                end = midIndex-1;
            } else if (midValue < find) {
                start = midIndex + 1;
            } else {
                // 찾았으면 flag = true
                return true;
            }
        }
        return false;
    }
}