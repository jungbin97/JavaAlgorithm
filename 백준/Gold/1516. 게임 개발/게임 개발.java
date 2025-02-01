import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 건물의 종류 수
        int N = Integer.parseInt(br.readLine());
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 진입차수 배열 초기화
        int[] indegree = new int[N+1];
        // 해당 건물 집짓는 시간(자기 자신 비용으로 초기화)
        int[] buildTimes = new int[N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 건물 짓는데 걸리는 시간
            buildTimes[i] = Integer.parseInt(st.nextToken());
            
            while (true) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == -1) {
                    break;
                }
                
                graph.get(temp).add(i);
                indegree[i]++;
            }
        }
        
        
        int[] result = new int[N+1];
        // 위상정렬 수행
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph.get(now)) {
                indegree[next]--;
                // 시간 업데이트
                result[next] = Math.max(result[next], result[now] + buildTimes[now]);
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }
        
        for (int i = 1; i <= N; i++) {
            System.out.println(result[i] + buildTimes[i]);
        }
    }
}

