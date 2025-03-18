import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 참가자 수
        int n = Integer.parseInt(br.readLine());
        
        // 티셔츠 사이즈 별 신청자수
        int[] arr = new int[6];
        st= new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // T, P
        st= new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        
        int sum  = 0;
        for (int i = 0; i < 6; i++) {
            sum +=arr[i]/t;
            if (arr[i]%t>0) {
                sum++;
            }
        }

        System.out.println(sum);
        System.out.print(n/p + " ");
        System.out.print(n%p);
    }
}

// 티는 남아도 되지만 신청한 사이즈 대로 줘야함.
// 팬은 참가자 수만큼 정확히
