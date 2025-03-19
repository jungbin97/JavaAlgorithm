import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] D = new int[n];
        
        Arrays.fill(D, 1);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    D[i] = Math.max(D[j]+1, D[i]);
                }
            }
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, D[i]);
        }
        System.out.println(result);

    }
}



// 가장 긴 증가하는 부분수열
// A = [10, 20, 10 , 30, 20, 50]

// 테이블 정의하기
// D[i]: arr[i]를 포함하는 가장 긴 증가하는 수열의 길이
//
// D[0] = 1
// D[1] = 2
// D[2] = 1
// D[3] = 3

// 점화식 구하기
// i번쨰 원소(arr[i]) 보다 앞에 있는 원소(arr[j])가 작으면 갱신
// if(arr[j] < arr[i]) 
// D[i] = max(D[j]+1, D[i])