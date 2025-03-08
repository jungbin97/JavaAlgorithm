import java.util.*;
import java.io.*;

public class Main {
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 행성 개수
        int n = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        // 간선 초기화
        for (int i = 1; i <= n; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (i < j) {
                    pq.add(new Edge(i, j, value));
                }
            }
        }
        
        long result = 0;
        int useEdges = 0;
        // 최소 플로우 비용
        while (useEdges < n-1) {
            Edge now = pq.poll();
            
            // 사이클 확인
            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);
                result += now.v;
                useEdges++;
            }
        }
        System.out.println(result);
        
        
    }
    
    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a != b) {
            parent[b] = a;
        }
        
    }

    static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int v;

        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        // 오름차순 정렬
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.v, o.v);
        }
    }
}