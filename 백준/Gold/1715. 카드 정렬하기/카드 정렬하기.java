import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int result = 0;

        for (int i = 0; i < N; i++) {
            pq.add(sc.nextInt());
        }
        
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            
            result += first+second;
            pq.add(first+second);

        }
        
        System.out.println(result);
    }
}

