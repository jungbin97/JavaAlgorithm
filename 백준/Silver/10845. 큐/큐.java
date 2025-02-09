import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue q = new Queue();
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                q.add(value);
            } else if (command.equals("front")) {
                if (q.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(q.front() + "\n");
                }
            } else if (command.equals("back")) {
                if (q.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(q.back() + "\n");
                }
            } else if (command.equals("empty")) {
                if (q.isEmpty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (command.equals("size")) {
                sb.append(q.size()+ "\n");
            } else if (command.equals("pop")) {
                if (q.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(q.poll() + "\n");
                }
            }
        }

        System.out.println(sb.toString());

    }

    /**
     * Queue
     * FIFO(First in First out)
     * 원소의 추가 O(1)
     * 원소의 제거 O(1)
     * 제일 앞/뒤 원소 확인 O(1)
     * 제일 앞/뒤가 아닌 원소의 확인/변경은 원칙적으로 불가능
     */
    static class Queue {
        static int MAX_SIZE = 1_000_001;
        int[] arr = new int[MAX_SIZE];
        int head = 0, tail = 0;

        // add 
        // 값 추가후 tail 위치 증가
        void add(int x) {
            arr[tail++] = x;
        }

        // poll 맨 앞값 뺴고, 반환
        int poll() {
            return arr[head++];
        }

        // q 비어있지 확인
        boolean isEmpty() {
            if (head == tail) {
                return true;
            } else {
                return false;
            }
        }
        
        // 큐 사이즈 반환
        int size() {
            return tail-head;
        }

        int front() {
            return arr[head];
        }

        int back() {
            return arr[tail-1];
        }
        
    }
}
