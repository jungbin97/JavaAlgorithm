import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 노드 개수, 간선 개수
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        ArrayList<Edge> edges = new ArrayList<>();
        // 간선 초기화
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges.add(new Edge(s, e, v));
        }
        
        edges.sort(Comparator.comparingInt(e -> e.v));
        
        // MST
        int useEdge = 0;
        int edgeIndex = 0;
        int totalValue = 0;
        int maxValue = 0;
        while (useEdge < n-1) {
            Edge now = edges.get(edgeIndex++);
            
            // 사이클 확인
            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);
                useEdge++;
                totalValue += now.v;
                maxValue = now.v;
                
            }
        }
        
        System.out.println(totalValue - maxValue);
    }
    
    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[a] = b;
        }
    }

    // 경로 압축
    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        
        return parent[a] = find(parent[a]);
    }

    static class Edge {
        int s;
        int e;
        int v;

        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }
    }
}
