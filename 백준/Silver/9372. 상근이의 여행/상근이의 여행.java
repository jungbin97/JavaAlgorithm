import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    static PriorityQueue<Edge> pq;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            // 국가 수, 비행기 종류
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            pq = new PriorityQueue<>();
            
            // 부모 배열 자기자신으로 초기화
            parent = new int[n+1];
            for (int i = 0; i <= n; i++) {
                parent[i]= i;
            }

            // 간선 추가
            for (int i = 1; i <= m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                Edge edge = new Edge(s, e, 1);
                pq.add(edge);
            }
            

            int useEdge = 0;
            while(!pq.isEmpty()) {
                Edge now = pq.poll();
                
                // 사이클이 아니라면
                if (find(now.s) != find(now.e)) {
                    union(now.s, now.e);
                    useEdge++;
                }

            }
            System.out.println(useEdge);
        }

    }
    
    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }
    
    static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        
        return parent[a] = find(parent[a]);
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
        
        //오름차순 정렬
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.v, o.v);
        }
    }
}


// 가상의 논만들기(0번 인덱스) -> 자신의 우물을 파는 경우
// MST (최소 스패닝 트리)