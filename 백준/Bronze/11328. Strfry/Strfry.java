import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int[] arr = new int[26];
            st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();

            // s1,s2 문자 개수 카운트
            for (int j = 0; j < s1.length(); j++) {
                arr[s1.charAt(j) - 'a']++;
            }
            
            for (int j = 0; j < s2.length(); j++) {
                arr[s2.charAt(j) - 'a']--;
            } 
            

            boolean impossible = false;  // 불가능한 경우 체크

            for (int j = 0 ; j < arr.length; j++) {
                if (arr[j] != 0) {
                    impossible = true;
                }
            }

            if (impossible) {
                System.out.println("Impossible");
            } else {
                System.out.println("Possible");
            }
        }
    }
}
