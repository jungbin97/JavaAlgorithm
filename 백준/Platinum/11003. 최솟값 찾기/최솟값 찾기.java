import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken()); 
        
        Deque<Node> mydeque = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        
        // 덱 초기화
        for(int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            // 덱의 마지막 위치에서 부터 now 보다 큰 값은 덱에서 제거
            while (!mydeque.isEmpty() && mydeque.getLast().value > now) {
                mydeque.removeLast();
            }
            mydeque.addLast(new Node(now, i));
            // 범위 벗어난 값은 덱에서 제거
            if (mydeque.getFirst().index <= i - L) {
                mydeque.removeFirst();
            }
            bw.write(mydeque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }
    
    static class Node {
        public int value;
        public int index;
        
        Node(int value, int index) {
            this.index = index;
            this.value = value;
        }
    }
}
