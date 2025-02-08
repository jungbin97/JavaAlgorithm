import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        // 입력 받을 개수
        int K = sc.nextInt();
        
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int value = sc.nextInt();
            
            if (value == 0){
                stack.pop();
            } else {
                stack.push(value);
            }
        }
        
        // 스택에 있는 수 전부 합하기
        int sum = stack.stream().mapToInt(i -> i).sum();
        System.out.println(sum);
    }
}
