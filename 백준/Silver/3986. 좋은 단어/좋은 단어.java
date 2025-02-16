import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Stack<Character> stack;
        // 단어 줄 수
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < n; i++) {
            stack = new Stack<>();
            String line = br.readLine();

            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                
                // 스태깅 비어있다면 push
                if (stack.isEmpty()) {
                    stack.push(c);
                // 비어있지 않다면, peek()와 같은 단어인지 확인
                } else if (!stack.isEmpty()) {
                    if (stack.peek() == c) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
            
            // 연산이후 스택이 비어있다면
            if (stack.isEmpty()) {
                result++;
            }
        }
        
        System.out.println(result);
    }
}

// 스택이 비어있다면 push
// 비어 있지 않다면 
// - stack.peek()가 같은 단어인지 확인, 같은 단어면 stack.pop()
// - 다른 단어면 stack.push()
// 
// 스택이 비어있지 않다면 카운트 X
// 스택이 비어있다면 카운트
// 

// A