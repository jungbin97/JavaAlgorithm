import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        StringBuffer sb = new StringBuffer();
        sb.append('<');

        while (q.size() > 1) {
            for (int i = 0; i < k-1; i++) {
                int val = q.poll();
                q.add(val);
            }

            sb.append(q.poll()).append(", ");
        }

        sb.append(q.poll()).append('>');
        System.out.println(sb);
    }
}


// 1 2 3 4 5 6 7
// => 3

// 456712
// => 6
