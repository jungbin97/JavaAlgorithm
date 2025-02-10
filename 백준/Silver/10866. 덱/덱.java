import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 명령어 수
        int N = Integer.parseInt(br.readLine());
        
        Deque dq = new Deque();
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
    
    public static class Deque {
        // deque은 양방향으로 증가하기 때문에, 배열의 중간값을 나타냄
        static int MAX_SIZE = 1_000_001;
    
        int[] data = new int[(2*MAX_SIZE)+1];
        int head = MAX_SIZE, tail = MAX_SIZE;
    
        
        void addFirst(int x) {
            data[--head] = x;
        }
        
        void addLast(int x) {
            data[tail++] = x;
        }
        
        int pollFirst() {
            return data[head++];
        }
        
        int pollLast() {
            return data[--tail];
        }
        
        int peekFirst() {
            return data[head];
        }
    
        int peekLast() {
            return data[tail-1];
        }
    
        boolean isEmpty() {
            return head == tail;
        }
        
        int size() {
            return tail - head;
        }
    }
}


