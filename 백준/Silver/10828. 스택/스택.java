import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 명령 개수
        int N = Integer.parseInt(br.readLine());
        // Stack 초기화
        Stack<Integer> stack = new Stack<>();
        
        // 결과 리스트
        ArrayList<Integer> result = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            
            // 5개 연산 조건문 분기
            // push 일때만 추가 입력값 존재
            if (command.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                stack.push(value);
            } else if (command.equals("top")) {
                if (stack.isEmpty()) {
                    result.add(-1);
                } else {
                    result.add(stack.peek());
                }
            } else if (command.equals("size")) {
                result.add(stack.size());
            } else if (command.equals("empty")) {
                if (stack.isEmpty()) {
                    result.add(1);
                } else {
                    result.add(0);
                }
            } else if (command.equals("pop")) {
                if (stack.isEmpty()) {
                    result.add(-1);
                } else{
                    result.add(stack.pop());
                }
            }
        }
        
        // 출력
        for (int value : result) {
            System.out.println(value);
        }
    }
}

