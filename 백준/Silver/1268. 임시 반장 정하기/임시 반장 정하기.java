import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 학생 수
        int n = Integer.parseInt(br.readLine());

        // 같은 반 학생 측정하기
        int[] result = new int[n+1];

        int[][] arr = new int[n+1][6];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                int room = Integer.parseInt(st.nextToken());
                arr[i][j] = room;
            }
        }
        
        // 1번 학생부터
        for (int i = 1; i <= n; i++) {
            // 비교 대상
            for (int j = 1; j <= n; j++) {
                // 자기 자신 제외
                if (i == j) continue;
                // 1학년 부터
                for (int k = 1; k <= 5; k++) {
                    // 한번이라도 같은 반 된 수
                    if (arr[i][k] == arr[j][k]) {
                        result[i]++;
                        result[j]++;
                        break;
                    }
                }
            }

        }
        int max = -1;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (max < result[i]) {
                max = result[i];
                index = i;
            }
        }

        
        System.out.println(index);
    }
}




// 같은 반이였던 학 수가 제일 많으면 임시반장
// 1~9반까지

// 1학년때 1반 명수
// [1][1] 

// 1학년 2반 명수
// [1][2]