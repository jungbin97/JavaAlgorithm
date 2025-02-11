import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        Deque<Node> dq = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (!dq.isEmpty() && dq.peekLast().value > now) {
                dq.removeLast();
            }
            
            dq.add(new Node(now, i));
            
            // 현재 인덱스 범위계산 후 초과 노드 제거
            while (dq.peekFirst().index <= i - L){
                dq.removeFirst();
            }
            
            bw.write(dq.peekFirst().value + " ");
        }

        bw.flush();
        bw.close();
    }

    static class Node {
        int value;
        int index;

        public Node (int value, int index)  {
            this.value = value;
            this.index = index;
        }
    }
}
// A1 A2 A3 A4  A5 A6 A7
// 1  5  2   3  6   2  3 


// D_1 = A_(1-3+1) ~ A_1 => A_0 ~ A_1 => 1
// D_2 = A_(2-3+1) ~ A_2 => A_0 ~ A_2 => 1
// D_3 = A_(3-3+1) ~ A_3 => A_1 ~ A_3 => 1
// D_4 = A_(4-3+1) ~ A_4 => A_2 ~ A_4 => 2

// java 1초에 1억번(100_000_000) 연산 
// 5_000_000번 연산(시간복잡도 주의)
// 특정 구간에서의 최소값을 구해야함.

// 오른쪽 하나씩늘어남. 왼쪽도 하나씩 줄음. => 우선순위 큐 (logN) log5 + log1000 + log1000 = 20(대략)
// 대략 100_000_000(1억)번 연산
