import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int[] visited;
    static int[] isCycle;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        Stack<Character> stack  = new Stack<>();
        
        int result = 0;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            //여는 괄호 스택 추가
            if (c == '(') {
                stack.push(c);
            // 닫는 괄호 경우
            } else {
                // 레이저일경우
                if (line.charAt(i-1) == '(') {
                    stack.pop();
                    result += stack.size();
                // 쇠막대일경우
                } else {
                    stack.pop();
                    result++;
                }
            }
        }
        
        System.out.println(result);

    }
}


// ()는 레이저
// '(' ~ ')'는 쇠막대기

// 레이저와 쇠막대기 구분법
// arr[i-1] == '(' 바로 이전 확인값이 여는괄호=> 레이저
// 아니면 ()가 아니므로 쇠막대기


// 레이저 1개 => 2개로 분할
// 레이저 2개 => 3개로 분할
// 레이저 3개 => 4개로 분할
// 레이저 4개 => 5개로 분할
// ....

