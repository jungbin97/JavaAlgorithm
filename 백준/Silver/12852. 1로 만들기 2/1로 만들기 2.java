import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        int X = Integer.parseInt(br.readLine());
        int D[] = new int[X+1];
        int pre[] = new int[X+1];
        
        D[1] = 0;
        pre[1] = 0;

        for (int i = 2; i <= X; i++) {
            D[i] = D[i-1] + 1;
            pre[i] = i-1;
            
            if (i%2==0 && D[i] > D[i/2]+1) {
                D[i] = D[i/2] +1;
                pre[i] = i/2;
            }
            
            if (i%3==0 && D[i] > D[i/3]+1) {
                D[i] = D[i/3] +1;
                pre[i] = i/3; 
            }
        }
        
        System.out.println(D[X]);

        int current = X;
        while(true) {
            System.out.print(current + " ");
            if (current == 1) {
                break;
            }
            current = pre[current];
        }
    }
}

// 3개의 연산을 사용하여 최소한사용해 1로 최솟값
// 1_000_000


// 10
// 3개
// 10 -> 9 -> 3 -> 1 
// 

// 테이블 정의하기
// D[i] 최소한으로 1도달할 수 있는 횟수
// pre[i] 최소한 이동의 이전 위치


// 초기값 세팅
// D[1] = 0
// pre[1] = 0

// 점화식 구하기
// if (k%2 ==0) => D[k] = min(D[k/2], D[k-1])+1
// if (k%3 ==0) => D[k] = min(D[k/3], D[k-1])+1
// 
// pre[k] = (k/2 or k-1), (k/3 or k-1)