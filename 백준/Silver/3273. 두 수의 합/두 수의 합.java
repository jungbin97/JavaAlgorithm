import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 정렬 오름차순
        Arrays.sort(arr);

        int target = Integer.parseInt(br.readLine());
        
        // 투포인터 인덱스 지정
        int start = 0;
        int end = n-1;
        int result = 0;
        
        while (start < end) {
            int sum = arr[start]+ arr[end];
            // target 값과 일치하면 start + 1, end - 1
            if (target == sum) {
                start++;
                end--;
                result++;
            // target 값 보다 크다면, end--
            } else if (target < sum) {
                end--;
            } else {
                start++;
            }
        }
        
        System.out.println(result);
    }
}


// 정렬?
// 1 2 3 5 7 9 10 11 12


