import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 명령어 수
        int N = Integer.parseInt(br.readLine());
        
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push_back")) {
                int value = Integer.parseInt(st.nextToken());
                dq.addLast(value);
            } else if (command.equals("push_front")) {
                int value = Integer.parseInt(st.nextToken());
                dq.addFirst(value);
            } else if (command.equals("front")) {
                if (dq.isEmpty()) {
                    sb.append("-1").append("\n");
                } else{
                    sb.append(dq.peekFirst()).append("\n");
                }
            } else if (command.equals("back")) {
                if (dq.isEmpty()) {
                    sb.append("-1").append("\n");
                } else{
                    sb.append(dq.peekLast()).append("\n");
                }
            } else if (command.equals("size")) {
                sb.append(dq.size()).append("\n");
            } else if (command.equals("empty")) {
                if (dq.isEmpty()) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            } else if (command.equals("pop_front")){
                if (dq.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(dq.pollFirst()).append("\n");
                }
            } else if (command.equals("pop_back")){
                if (dq.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(dq.pollLast()).append("\n");
                }
            }
        }
        
        System.out.println(sb.toString());
    }
}


