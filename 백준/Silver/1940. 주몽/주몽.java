import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
        /**********************************************************************
         *
         *
         **********************************************************************/
        public static void main(String[] args) throws IOException {
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            // 배열 정렬(오름차순)
            Arrays.sort(arr);

            int count = 0;
            int i = 0;      // Start Point
            int j = N-1;    // End Point

            while (i < j){
                if(arr[i]+arr[j] == M){
                    count++;
                    i++;
                    j--;
                }
                else if(arr[i]+arr[j] > M){
                    j--;
                }
                else{
                    i++;
                }
            }
            System.out.println(count);
        }
}
