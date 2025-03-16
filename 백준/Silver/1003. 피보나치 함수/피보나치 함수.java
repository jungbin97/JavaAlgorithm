import java.util.*;
import java.io.*;

public class Main {
    static int D[][] = new int[41][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        
        int tc = Integer.parseInt(br.readLine());
        
        D[0][0] = 1;
        D[0][1] = 0;
        D[1][0] = 0;
        D[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            D[i][0] = D[i-1][0] + D[i-2][0];
            D[i][1] = D[i-1][1] + D[i-2][1];
        }
        
        for (int t = 0; t < tc; t++) {
            int k = Integer.parseInt(br.readLine());
            System.out.println(D[k][0] + " " + D[k][1]);
        }
    }
}


// 테이블 정의하기 
// D[i][2]: i번째에 0이 출력되는 횟수 D[i][0], i번쨰에 1일 출력되는 횟수 D[i][1]

// 초기값 세팅
// D[0][] = ?
// D[0][0] = 1
// D[0][1] = 0

// D[1][] = ? 
// D[1][0] = 0
// D[1][1] = 1



// 점화식 구하기
// D[2][] = ?
// D[2][0] = D[1][0] + D[0][0] = 1
// D[2][1] = D[1][1] + D[0][1] = 1

// D[k][0] = D[k-1][0] + D[k-2][0]
// D[k][1] = D[k-1][1] + D[k-2][1] 