import java.util.*;
import java.io.*;

public class Main {
    // 노드 개수 
    // 간선 개수
    static int V, E;
    // 그래프 인접 리스트
    static ArrayList<Node>[] graph;
    // 우선순위 큐
    static PriorityQueue<Node> q = new PriorityQueue<>();
    // 거리 배열
    static int[] distance;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 노드 입력 받기
        V = Integer.parseInt(st.nextToken());
        
        // 에지 입력 받기
        E = Integer.parseInt(st.nextToken());

        // 시작 노드 입력 받기
        int start = Integer.parseInt(br.readLine());

        // 그래프 초기화
        graph = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<Node>();
        }
        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            // u에서 v까지 w 비용
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        // 거리 배열 초기화(무한)
        distance = new int[V+1];
        for (int i = 0; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        
        // 시작 노드 세팅
        q.add(new Node(start, 0));
        distance[start] = 0;
        // 다익스트라 수행
        while (!q.isEmpty()) {
            // 큐 뺴기
            Node now = q.poll();
            int now_vertex = now.vertex;

            // 현재 노드의 거리가 큐에서 꺼낸 거리 보다 작으면 이미 갱신된것. 
            if (distance[now_vertex] < now.value) continue;
            
            for (Node temp : graph[now_vertex]) {
                int next_vertex = temp.vertex;
                int next_value = temp.value;
                
                if (distance[next_vertex] > now.value + next_value) {
                    distance[next_vertex] = now.value + next_value;
                    q.add(new Node(next_vertex, distance[next_vertex]));
                }
            }
        }
        
        // 출력
        for (int i = 1; i<= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }

    }
    
    static class Node implements Comparable<Node> {
        int vertex;
        int value;
        public Node(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        // 오름차순 정렬
        public int compareTo(Node o) {
            return Integer.compare(value, o.value);
        }
    }
}