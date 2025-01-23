import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 내림차순
        PriorityQueue<Integer> plusPQ = new PriorityQueue<>(Collections.reverseOrder());
        // 오름차순
        PriorityQueue<Integer> minusPQ = new PriorityQueue<>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int one = 0;
        int zero = 0;
        
        int result = 0;

        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            // 양수
            if (num>1) {
                plusPQ.add(num);
            } else if (num == 1) {
                one++;
            } else if (num == 0) {
                zero++;
            } else {
                minusPQ.add(num);
            }
        }
        
        // 양수 처리
        while (plusPQ.size() > 1) {
            int first = plusPQ.poll();
            int second = plusPQ.poll();

            result += (first * second);
        }
        
        // 남은 수 처리
        if (!plusPQ.isEmpty()) {
            result += plusPQ.poll();
        }
        
        // 음수처리
        while (minusPQ.size() > 1) {
            int first = minusPQ.poll();
            int second = minusPQ.poll();

            result += (first * second);
        }
        
        // 남은 수 처리
        if(!minusPQ.isEmpty()) {
            if (zero > 0) {
                result += minusPQ.poll() * 0;
            } else {
                result += minusPQ.poll();
            }
        }
        
        // 1처리 후 반환
        System.out.println(result + one);

    }
}

// 0 개별 카운트
// 1 개별 카운트
// 
// 음수 => 오름차순
// 나머지 하나 남으면(홀수)이면, 0과 곱하기, 0이 없으면 그냥 더하기

// 남은 1은 그냥 더하기

// 양수 => 내림차순 
// 홀수개면 마지막 그냥 더하기
