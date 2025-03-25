import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] D = new int[n];
        int[] pre = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.fill(D, 1);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && D[i] < D[j]+1) {
                    D[i] = D[j] + 1;
                    pre[i] = j;
                }
                
            }
        }

        int maxIndex = 0;
        int maxLength = 0;
        for (int i = 0; i<n; i++) {
            if (D[i] > maxLength) {
                maxLength = D[i];
                maxIndex = i;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while (true) {
            result.add(arr[maxIndex]);
            if (D[maxIndex] == 1) {
                break;
            }
            maxIndex = pre[maxIndex];
        }
        Collections.reverse(result);

        System.out.println(maxLength);
        for (int a : result) {
            System.out.print(a + " ");
        }
        
    }
}

// {10, 20, 10, 30, 20, 50}

// 테이블 정의하기
// D[i]: i번째에서 가장 증가하는 부분수열 길이
// 
// 점화식 구하기
// i 번째 원소 보다 앞에 있는 원소가 작으면 갱신
// D[1] = ?
// 1
// D[2] = D[2] > D[1]이면 +1
// if (arr[j] < arr[i])
// D[i] = max(D[j]+1, D[i])