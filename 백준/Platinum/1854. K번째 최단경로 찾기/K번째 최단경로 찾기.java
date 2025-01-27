import java.util.*;
import java.io.*;


public class Main {
    static int N, M, K;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static PriorityQueue<Integer>[] distance;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // a에서 b로 가는 비용 c
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
        }

        // 최단 경로우선순위 큐
        distance = new PriorityQueue[N+1];
        for (int i = 0; i <= N; i++) {
            // 크기 K로, 내림차순 정렬
            distance[i] = new PriorityQueue<>(K, (o1, o2) -> Integer.compare(o2, o1));
        }
        
        // 다익스트라 수행
        dijkstra();
        //
        // K번쨰 경로 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= N; i++) {
            if (distance[i].size() == K) {
                bw.write(distance[i].peek() + "\n");
            } else {
                bw.write(-1+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void dijkstra() throws Exception {
        // // 방문 체크 배열
        // visited = new boolean[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        // 시작 노드 세팅
        pq.add(new Node(1, 0));
        distance[1].add(0);
        
        while (!pq.isEmpty()) {
            Node u = pq.poll();
            int nowNode = u.targetNode;
            int nowValue = u.value;
            
            for (Node next : graph[nowNode]) {
                // 저장된 경로가 K개가 아니면 그냥 추가
                if (distance[next.targetNode].size() < K) {
                    distance[next.targetNode].add(nowValue+next.value);
                    pq.add(new Node(next.targetNode, nowValue+next.value));
                }
                // 저장된 경로가 K개이고, 현재 가장 큰값보다 작을 때 추가
                else if (distance[next.targetNode].peek() > nowValue + next.value) {
                    distance[next.targetNode].poll();
                    distance[next.targetNode].add(nowValue + next.value);
                    pq.add(new Node(next.targetNode, nowValue + next.value));
                }
            }
        }
        
    }

    public static class Node implements Comparable<Node> {
        int targetNode;
        int value;

        Node (int targetNode, int value) {
            this.targetNode = targetNode;
            this.value = value;
        }

        // 오름차순 정렬
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value);
        }
    }
}