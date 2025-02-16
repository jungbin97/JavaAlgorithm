import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //테스트 케이스
        int Tc = Integer.parseInt(br.readLine());
        Stack<Character> stack;
        for (int t = 0; t < Tc; t++) {
            stack = new Stack<>();
            
            String line = br.readLine();
            boolean returnFlag = false;
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                // 여는 괄호가 나올 경우
                if (c == '(') {
                    stack.push(c);
                // 닫는 괄호
                } else if (c == ')') {
                    if (stack.isEmpty()) {
                        returnFlag = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            
            // 스택에 남아있다면 no
            if (!stack.isEmpty() || returnFlag) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

        }
        
    }
}

// 여는괄호 stack.push()
// 닫는 괄호 나올 경우
// - 스택이 비어있다면 no
// - 비어있지 않다면 stack.pop
// 
// 스택에 남아있다면 no
// 스택이 비어있다면 yes