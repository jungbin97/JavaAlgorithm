import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
        /**********************************************************************
         * 그리디 알고리즘
         *
         **********************************************************************/
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int count = 0;
            // 배열 입력받기
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(br.readLine());
            }

            // 그리디 알고리즘 -> 최대한 큰 동전 먼저 사용하기
            for (int i = n-1; i>= 0; i--){
                if(arr[i] <= k){
                    count += k/arr[i];
                    k = k%arr[i];
                }
            }
            System.out.println(count);
        }
}
