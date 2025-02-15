import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String line = br.readLine();
            // 종료 조건
            if (line.equals(".")) {
                break;
            }
            
            Stack<Character> stack = new Stack<>();
            boolean flag = false;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                // 여는 괄호
                if (c == '(' || c == '[') {
                    stack.push(c);
                // 닫는 괄호
                } else if (c == ')') {
                    // 스택 peek()와 짝이 맞는 괄호
                    if (stack.isEmpty() || stack.peek() != '(') {
                        flag = true;
                        break;
                    }
                    stack.pop();
                } else if (c == ']') {
                    // 스택 peek()와 짝이 맞는 괄호
                    if (stack.isEmpty() || stack.peek() != '[') {
                        flag = true;
                        break;
                    }
                    stack.pop();
                }
            }
            
            // 스택에 괄호 남아 있다면
            if (!stack.isEmpty()) {
                flag = true;
            }

            if (flag) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }
        }
        

    }
}

// 여는 괄호 스택 추가
// 닫는 괄호 나올 경우
// - 스택이 비어있다면 X
// - 스택 peek()와 짝이 맞지 않는 경우 X
// - 스택 top과 짝이 맞는 괄호 pop
// 모든 과정 수행 후 괄호가 남아있다면 X
// 남아있지 않으면 올바른 쌍
