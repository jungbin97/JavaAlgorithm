import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long[] D = new long[101];
        
        D[1] = 1;
        D[2] = 1;
        D[3] = 1;
        D[4] = 2;
        D[5] = 2;
        for (int i = 6; i <= 100; i++) {
            D[i] = D[i-1] + D[i-5];
        }


        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc ; t++) {
            int value = Integer.parseInt(br.readLine());
            System.out.println(D[value]);
        }
    }
}

// 테이블 정의
//  D[i]: i번쨰 나선에 있는 정삼각형 변의 길이

// 초기값 세팅하기
// D[1] = 1
// D[2] = 1
// D[3] = 1
// D[4] = 2
// D[5] = 2
// 
// 점화식 구하기
// D[il = D[i-1] + D[i-5];