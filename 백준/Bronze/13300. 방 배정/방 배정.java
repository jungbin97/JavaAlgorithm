import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 참가 학생 수
        int n = Integer.parseInt(st.nextToken());
        // 방 최대 인원
        int k = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[2][7];
        

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken()); 
            int grade = Integer.parseInt(st.nextToken()); 

            arr[sex][grade]++;
        }

        int result = 0;
        // 방 개수 계산
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 7; j++) {
                // k로 나눠 방 개수 더하기, 나머지 있으면 추가
                result += arr[i][j] / k;
                if (arr[i][j]%k > 0) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}


