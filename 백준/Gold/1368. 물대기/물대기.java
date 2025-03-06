import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        // 부모 배열 초기화
        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        // 가상의 0 노드와 모든 논을 연결하는 간선 추가
        for (int i = 1; i <= n; i++) {
            int weight = Integer.parseInt(br.readLine());
            pq.add(new Edge(0, i, weight));
        }
        
        // 논 연결 간선 초기화
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (i < j) {
                    pq.add(new Edge(i, j, value));
                }
            }
        }
        
        int totalCost = 0;
        int useEdge = 0;
        while (useEdge < n) {
            Edge edge = pq.poll();

            // 사이클 여부 확인(같은 부모인지)
            if (find(edge.s) != find(edge.e)) {
                union(edge.s, edge.e);
                totalCost += edge.value;
                useEdge ++;
            }
        }

        System.out.println(totalCost);
        
    }
    
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a != b) {
            parent[b] = a;
        }
    }
    
    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        
        return parent[a] = find(parent[a]);
    }
    
    static class Edge implements Comparable<Edge> {
        int s, e, value;
        
        Edge(int s, int e, int value) {
            this.s = s;
            this.e = e;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.value, o.value);
        }
    }
    
    
}

