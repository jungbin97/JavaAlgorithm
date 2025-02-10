import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
            
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = 0;

        // 데크 초기화
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            dq.add(i);
        }
        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            int target = Integer.parseInt(st.nextToken());
            
            // 구하고자 하는 수 인덱스 찾기
            int index = 0;
            for (int num : dq) {
                if (num == target) {
                    break;
                }
                index++;
            }
            // 첫번째 원소가 target이 아니면, 현재 인덱스의 앞에 개수가 더 많은지 뒤에 개수가 더 많은지 판단
            while (dq.peekFirst() != target) {
                // 앞에서 뺴서, 뒤에 넣기
                if (index < dq.size() - index) {
                    dq.addLast(dq.pollFirst());
                // 뒤에서 빼서, 앞에 넣기
                } else {
                    dq.addFirst(dq.pollLast());
                }
                result++;
            }
            dq.pollFirst();
        }
        
        System.out.println(result);
    }
}