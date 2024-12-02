import java.util.*;
import java.io.*;

public class Main {
    // 도시수, 도로수, K
    static int N, M, K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 도시수
        N = Integer.parseInt(st.nextToken());
        // 간선 개수
        M = Integer.parseInt(st.nextToken());
        // K 번쨰 최단 경로 입력
        K = Integer.parseInt(st.nextToken());
        
        // 인접리스트 그래프 입력
        ArrayList<Node>[] graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 간선 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // a에서 b로가는 비용 c
            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken()); 
            int c = Integer.parseInt(st.nextToken()); 
            graph[a].add(new Node(b, c));
        }
        
        PriorityQueue<Integer>[] distanceQueue = new PriorityQueue[N+1];
        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        };
        
        for (int i = 0; i <= N; i++) {
            distanceQueue[i] = new PriorityQueue<>(K, cp);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        distanceQueue[1].add(0);
        
        // 다익스트라 수행
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int currentNode = now.node;
            int currentCost = now.cost;
            
            for (Node next : graph[currentNode]) {
                int nextNode = next.node;
                int nextCost = currentCost + next.cost;
                
                // K개의 최단 경로 유지
                if (distanceQueue[nextNode].size() < K) {
                    distanceQueue[nextNode].add(nextCost);
                    pq.add(new Node(nextNode, nextCost));
                } else if (distanceQueue[nextNode].peek() > nextCost) {
                    distanceQueue[nextNode].poll();
                    distanceQueue[nextNode].add(nextCost);
                    pq.add(new Node(nextNode, nextCost));
                }
            }
        }
        
        // 결과 출력
        for (int i = 1; i <= N; i++) {
            if (distanceQueue[i].size() == K) {
                System.out.println(distanceQueue[i].peek());
            } else {
                System.out.println(-1);
            }
        }
    }
    
    static class Node implements Comparable<Node> { 
        int node;
        int cost;
        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost < o.cost ? -1 : 1;
        }
    }
}