import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        // 노드 개수
        int n = sc.nextInt();
        // 에지 개수
        int m = sc.nextInt();
        
        // 학생 수만큼 인접 노드 생성
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            A.add(new ArrayList<>());
        }
        // 진입 차수
        int[] indegree = new int[n+1];
        
        for (int i = 0; i < m; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A.get(S).add(E);
            indegree[E]++;
        }
        // 위상 정렬 수행
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        while (!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");
            for (int next : A.get(now)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }
    }
}