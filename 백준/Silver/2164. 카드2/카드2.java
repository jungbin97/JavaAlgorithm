import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
        /**********************************************************************
         *
         *
         **********************************************************************/
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            // 홀수면 버리고 짝수면 큐다시 삽입
            int cnt = 1;

            Queue<Integer> q = new LinkedList<>();

            // 큐에 카드숫자 삽입
            for (int i=1; i<N+1; i++){
                q.add(i);
            }

            while (q.size()>1){
                int card = q.poll();
                // 홀수일때
                if (cnt%2==1){
                    cnt++;
                }else{
                    cnt++;
                    q.add(card);
                }
            }

            System.out.println(q.poll());
        }
}
