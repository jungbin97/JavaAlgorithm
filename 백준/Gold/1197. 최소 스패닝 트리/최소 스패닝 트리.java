import java.util.*;
import java.io.*;
import java.net.SocketTimeoutException;

public class Main {
    static int[] parent;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        // 노드 개수
        int V = sc.nextInt();
        // 에지 개수
        int E = sc.nextInt();
        
        // 부모 배열(union-find)
        parent = new int[V+1];
        for(int i = 1; i<=V; i++) {
            parent[i] = i;
        }
        

        // 에지 리스트 초기화(오름차순으로 정렬)
        for (int i = 0; i < E; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int v = sc.nextInt();
            pq.add(new Edge(s, e, v));
        }
        
        int useEdge = 0;
        int result = 0;
        
        while (useEdge < V-1) {
            // 현재 가장 작은 엣지
            Edge now = pq.poll();
            
            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);
                result = result + now.v;
                useEdge++;
            }
        }
        System.out.println(result);
        
    }

    public static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int v;

        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.v, o.v);
        }
    }
    
    // find
    public static int find(int a) {
        // 자기 자신이면
        if (a == parent[a]) {
            return a;
        } else {
            // 경로 압축
            return parent[a] = find(parent[a]);
        }

    }
    
    // union
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a != b) {
            parent[b] = a;
        }
    }
}