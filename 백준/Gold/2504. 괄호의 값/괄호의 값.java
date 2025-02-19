import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        String line = br.readLine();
        
        boolean escapeFlag = false;
        int sumValue = 0;
        int temp = 1;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '('){
                stack.push(c);
                temp *= 2;
            } else if (c == '[') {
                stack.push(c);
                temp *= 3; 
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    escapeFlag = true;
                    break;
                }
                
                // 바로 이전 값이 '('
                if (line.charAt(i-1) == '(') {
                    sumValue += temp;
                }
                stack.pop();
                temp/=2;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    escapeFlag = true;
                    break;
                }
                
                // 바로 이전 값이 '['
                if (line.charAt(i-1) == '[') {
                    sumValue += temp;
                }
                stack.pop();
                temp/=3;
            }
        }
        
        // 스택이 비어있지 않다면, escapeFlag true
        if (!stack.isEmpty() || escapeFlag) {
            System.out.println("0");
        } else {
            System.out.println(sumValue);
        }
    }
}

// "("인경우 stack.push()
// temp *= 2
// "["인경우 stack.push()
// temp *= 3
// "]"인경우
// 스택이 비엇거나 || stack.peek() != '[' 짝이 안맞는 경우 탈출 0 반환
// 이전값이 '['이면 
// sumValue += temp
// stack.pop()
// temp / 3
// 아니면
// stack.pop()
// temp/ 3
// ....

// 모든 문자열 순회 후, 스택에 괄호가 남아있다면 0반환
// 아니라면 값 출력

