import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int[] visited;
    static int[] isCycle;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        Stack<Character> stack = new Stack<>();
        
        // 더하기 연산 저장
        int sum = 0;
        // 곱하기 연산 저장
        int temp = 1;
        for (int i = 0; i < line.length(); i++){
            char c = line.charAt(i);
            
            if (c == '(') {
                stack.push(c);
                temp *= 2;
            } else if (c == '[') {
                stack.push(c);
                temp *= 3;
            } else if (c == ']'){
                // 스택이 비어있다면 || 짝이 맞지 않다면
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println("0");
                    return;
                }
                // 이전 값과 짝이 맞는 경우
                if (line.charAt(i-1) == '[') {
                    sum += temp;
                }
                stack.pop();
                temp /= 3;

            } else {
                // 스택이 비어있다면 || 짝이 맞지 않다면
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println("0");
                    return;
                }
                // 이전 값과 짝이 맞는 경우
                if (line.charAt(i-1) == '(') {
                    sum += temp;
                }
                stack.pop();
                temp /= 2;
            }
            
        }
        
        // 스택에 남아있다면 잘못된 문자열
        if (!stack.isEmpty()) {
            System.out.println("0");
            return;
        }
        
        System.out.println(sum);
    }
}

// ([]()) 2 X (3 + 2)=  10
// (2 X 3) + (2 X 2)

// sum = 0;
// temp = 2 * 3
// sum += temp => 6
// temp / 3 = 2
// 
// temp = 2 * 2 = 4
// sum += temp => 6 + 4 = 10
// temp / 2 = 2

// temp / 2 = 2


// '(', '['면 stack.push()
// ')', ']'면 stack.peek()와 짝이 맞는지확인, 
// 짝이 맞지 않으면 0반환,, 
// 스택이 비어있는지 확인 비어있다면 0 반환
// 
// 짝이 맞고, 이전 '['이고 현재 ']'이면 붙어있는 것. (sum += 괄호값),  temp // 괄호 값
// 짝이 맞고, 이전 값이 다른 것. 이면 sum과 temp  곱하기

