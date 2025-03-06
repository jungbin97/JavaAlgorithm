import java.util.*;
import java.io.*;

public class Main {
    static int v, e;
    static int[] parent;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 정점 개수, 간선 개수
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        // 정점 자기 자신으로 초기화
        parent = new int[v+1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // 엣지 초기화
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            Edge edge = new Edge(start, end, value);
            pq.add(edge);
        }
        
        int result = 0;
        int useEdge = 0;
        while(useEdge < v-1) {
            Edge edge = pq.poll();
            
            // 사이클이 아니면
            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                result += edge.value;
                useEdge++;
            }
        }
        
        System.out.println(result);

    }

    
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a != b) {
            parent[b] = a;
        }
    }
    
    // 루트 노드 찾기
    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        
        // 경로 압축
        return parent[a] = find(parent[a]);
    }
    
    public static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int value;
        
        Edge(int s, int e, int v) {
            start = s;
            end = e;
            value = v;
        }
        
        // 오름차순 정렬
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.value, o.value);
        }
    }
}