import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        

        // 노드, 에지 개수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        

        // 인접 리스트 초기화
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        
        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
        }

        // 진입 차수 배열
        int[] arr = new int[N+1];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A.get(s).add(e);
            arr[e]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 1; i <= N; i++) {
            if (arr[i] == 0) {
                q.add(i);
            }
        }
        
        while (!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");
            for (int next : A.get(now)) {
                arr[next]--;
                if (arr[next] == 0) {
                    q.add(next);
                }
            }

        }

    }
}