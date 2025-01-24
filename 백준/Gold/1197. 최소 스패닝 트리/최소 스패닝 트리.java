import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        // 유니온 파인드 배열 초기화
        parent = new int[V+1];
        
        for(int i = 1; i <= V; i++) {
            parent[i] = i;
        }


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            pq.add(new Edge(s, e, v));
        }
        
        int useEdge = 0;
        int result = 0;
        while(useEdge < V-1) {
            Edge edge = pq.poll();
            
            if (find(edge.s) != find(edge.e)) {
                union(edge.s, edge.e);
                useEdge++;
                result = result + edge.v;
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
    
    static void union (int a, int b) {
        a = find(a);
        b = find(b);

        if (a!=b) {
            parent[b] = a;
        }
    }
    


    static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int v;

        Edge (int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Edge o) {
            return (this.v - o.v);
        }
    }

}