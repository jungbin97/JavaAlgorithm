import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int n  = sc.nextInt();

        // 양수, 음수, 1, 0
        // 양수는 내림차순으로 
        // 음수는 오름차순으로
        PriorityQueue<Integer> plusQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQ = new PriorityQueue<>();
        
        int one = 0;
        int zero = 0;


        // 입력값 4가지로 분리 저장
        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            
            // 양수 일때
            if (number > 1) {
                plusQ.add(number);
            } else if (number == 0) {
                zero++;
            } else if (number == 1) {
                one++;
            } else {
                minusQ.add(number);
            }
        }
        
        int sum = 0;
        //  양수 처리
        while (plusQ.size() > 1) {
            int first = plusQ.poll();
            int second = plusQ.poll();
            sum = sum + first * second;
        }

        // 큐에 남아있으면
        if (!plusQ.isEmpty()) {
            sum = sum + plusQ.poll();
        }
        
        // 음수 처리 하기
        while (minusQ.size() > 1) {
            int first = minusQ.poll();
            int second = minusQ.poll(); 
            sum = sum + (first * second);
        }
    
        // 큐에 남아있으면 
        if (!minusQ.isEmpty()) {
            if (zero == 0) {
                sum = sum + minusQ.poll();
            }
        }
        
        // 1 처리하기
        sum = sum + one;
        System.out.println(sum);
        

    }
}