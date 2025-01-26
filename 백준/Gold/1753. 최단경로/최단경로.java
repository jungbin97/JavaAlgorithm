import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Node>[] graph;
    static int[] distance;
    static boolean[] visited;
    static PriorityQueue<Node> q = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 노드, 엣지 개수
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
            
        
        // 시작 노드
        int K = Integer.parseInt(br.readLine());
        
        
        // 최단 거리 배열 초기화
        distance = new int[N+1];
        for (int i = 0; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        
        // 방문 체크 배열
        visited = new boolean[N+1];

        graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 인접 리스트 초기화
        for (int i = 0; i < E; i++)  {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, value));
        }
        
        // K를 시작점으로 설정
        q.add(new Node(K, 0));
        distance[K] = 0;
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            int currentNode = node.node;
            
            if (visited[currentNode]) {
                continue;
            }
            visited[currentNode] =true;
            
            for (int i = 0; i < graph[currentNode].size(); i++) {
                Node nextNode = graph[currentNode].get(i);
                int next = nextNode.node;
                int nextValue = nextNode.value;
                
                if (distance[next] > distance[currentNode] + nextValue) {
                    distance[next] = distance[currentNode] + nextValue;
                    q.add(new Node(next, distance[next]));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }
        
    }
    
    static class Node implements Comparable<Node> {
        int node;
        int value;

        Node (int node, int value) {
            this.node = node;
            this.value = value;
        }
        
        // value 기준으로 오름차순 정렬
        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.value, node.value);
        }
    }
}