import java.util.*;
import java.io.*;

public class Main {
        static ArrayList<Integer>[] A;
        static int[] visited;
        static List<Integer> answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 노드 개수
        int n = Integer.parseInt(st.nextToken());
        // 간선 수
        int m = Integer.parseInt(st.nextToken());
        // 최단 거리 정보
        int k = Integer.parseInt(st.nextToken());
        // 출발 도시 정보
        int x = Integer.parseInt(st.nextToken());
        
        A = new ArrayList[n+1];
        answer = new ArrayList<Integer>();
        // 배열 초기화
        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<Integer>();
        }
        
        // 그래프 데이터 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
        }

        // 방문체크
        visited = new int[n+1];
        for (int i = 0; i <= n; i++) {
            visited[i]= -1;
        }
        
        BFS(x);
        for (int i = 0; i <= n; i++){
            if(visited[i] == k){
                answer.add(i);
            }
        }
        
        if (answer.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(answer);
            for (int temp : answer) {
                System.out.println(temp);
            }
        }
    }
    
    public static void BFS(int node) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(node);
        
        visited[node]++;
        
        while(!q.isEmpty()) {
            int nowNode = q.poll();
            for (int i : A[nowNode]) {
                if (visited[i] == -1) {
                    visited[i] = visited[nowNode] + 1;
                    q.add(i);
                }
            }
        }
    }
}