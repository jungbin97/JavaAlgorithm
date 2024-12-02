import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    // 방문자 체크 배열(n+1)
    static boolean[] visited;
    // 최단경로 배열(n+1)
    static int[] distance;
    // 그래프 인접 리스트(n+1)
    static ArrayList<Edge>[] graph;
    // 우선순위 큐()
    static PriorityQueue<Edge> q = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 도시 개수
        n = Integer.parseInt(br.readLine());
        // 버스 개수
        m = Integer.parseInt(br.readLine());
        
        // 인접리스트 초기화
        graph = new ArrayList[n+1];
        
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 인접리스트 입력값 받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            // s 노드에서 e까지 w 비용
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[s].add(new Edge(e, w));
        }
        
        // 경로 배열 초기화
        distance = new int[n+1];
        for (int i = 1; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        
        visited = new boolean[n+1];
        
        // 시작 노드, 도착 노드 입력
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        
        // 결과 출력하기
        int result = dijkstra(start, end);
        System.out.println(result);
    }
    
    public static int dijkstra(int start, int end) {
        // 시작 노드 큐삽입
        q.add(new Edge(start, 0));
        // 거리 0으로 초기화
        distance[start] = 0;

        // 다익스트라 수행
        while (!q.isEmpty()) {
            Edge now = q.poll();
            int n_vertex = now.vertex;
            if (visited[n_vertex]) continue;
            visited[n_vertex] = true;

            for (Edge temp : graph[n_vertex]) {
                int next = temp.vertex;
                int value = temp.value;
                
                if (distance[next] > distance[n_vertex] + value) {
                    distance[next] = distance[n_vertex] + value;
                    q.add(new Edge(next, distance[next]));
                }
            }
        }
        
        return distance[end];
    }
    
    static class Edge implements Comparable<Edge> {
        int vertex;
        int value;
        public Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        // 정렬 기준 설정하기(오름차순 -> 최소힙)
        public int compareTo(Edge o) {
            return Integer.compare(this.value, o.value);
        }
    }
}