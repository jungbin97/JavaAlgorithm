import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        // 배열 초기화
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        StringBuffer bw = new StringBuffer();
        for (int i = 0; i < N; i++) {
            int current = A[i]; // 현재 수열의 수
            if (current >= num) {
                while (current >= num) {
                    stack.push(num++);
                    bw.append("+\n");
                }
                stack.pop();
                bw.append("-\n");
            } else { // 수가 현재 수열의 수보다 클때
                int n = stack.pop();
                if (n > current) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bw.append("-\n");
                }
            }
        }
        if (result) {
            System.out.println(bw.toString());
        }
    }
}
