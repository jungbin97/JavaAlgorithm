import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        // 자리수 N
        int N = sc.nextInt();
        int Q = sc.nextInt();
        
        // 정답 저장 배열
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 2번 소문제 배열
        int[] arr = new int[N];

        long[] F = new long[21];
        boolean[] visited = new boolean[N+1];

        F[0] = 1;
        
        // 팩토리얼 배열 초기화 {0, 1, 2, 6, 24, 120}
        for (int i = 1; i <= 20; i++) {
            F[i] = F[i - 1] * i;
        }
        
        if (Q == 1) {
            long K = sc.nextLong();
            
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    // 이미 사용한 숫자는 패스
                    if (visited[j]) {
                        continue;
                    }

                    if (K - F[N-1-i] > 0) {
                        K -= F[N-1-i];
                    } else {
                        answer.add(j);
                        visited[j] = true;
                        break;
                    }
                }
            }
            
            for (int i = 0; i < answer.size(); i++) {
                System.out.print(answer.get(i) + " ");
            }
        } else if (Q == 2) {
            long answer_value = 1;
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            
            for (int i = 0; i < N; i++) {
                for (int j = 1; j < arr[i]; j++) {
                    if (visited[j] == false) {
                        answer_value += F[N-1-i];
                    }
                }
                visited[arr[i]] = true;
            }
            System.out.println(answer_value);
        }
        

    }
}


// {1, 2, 3, 4, 5}
// 5!

// 4! = 4 3 2 1 = 24
// 4! = 24
// 4! = 24
// 4! = 24 
// 4! = 24


// 24 * 5 = 120

// k = 61 번째  순열 구하기

// 61 - 24 = 37 => 1번째
// 37 - 24 = 13 => 2번째
// 13 - 24 < 0  => 3번째

// 3번쨰 이므로 처음값 3
// 
// 3 _ _ _ _

// 13 - 6 = 7 => 1번째
// 7 -  6 = 1 => 2번째
// 1 - 6 < 0 => 3번째

// 3 4 _ _ _ 



// 2번 소문제
// {3, 4, 1, 2, 5} = 61번째

// 1 _ _ _ _ => 24가지
// 2 _ _ _ _ => 24가지

// 48

// 3 1 _ _ _ => 6가지
// 3 2 _ _ _ => 6가지
// 3 4 _ _ _ 

// 48 + 12 = 60

// 3 4 1 _ _ 

// 3 4 1 2 5


// 60 + 1 = 61
