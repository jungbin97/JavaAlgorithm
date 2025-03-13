import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 건물 개수, 도로 개수
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        ArrayList<Edge> edgeList = new ArrayList<>();

        // 도로 개수만큼 간선(비용: 0 오르막, 1 내리막)
        for (int i = 0; i < m+1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Edge edge = new Edge(s, e, v);
            
            edgeList.add(edge);
        }

        // 정렬(오르막 우선)=> 오름차순
        Collections.sort(edgeList, (o1, o2) -> Integer.compare(o1.v, o2.v));
        int worstValue = kruskal(edgeList);
        
        // 정렬(내리막 우선) => 내림차순
        Collections.sort(edgeList, (o1, o2) -> Integer.compare(o2.v, o1.v)); 
        int bestValue = kruskal(edgeList);
        
        // 피로도 계산 
        System.out.println((worstValue*worstValue - bestValue*bestValue));
    }
    
    static int kruskal(List<Edge> edgeList) {
        parent = new int[n+1];
        for (int i = 0; i<=n; i++) parent[i] = i;
        
        // 선택 간선 개수
        int edgeCount = 0;
        // 오르막길 개수 
        int ascConut = 0;
        for(Edge edge : edgeList) {
            if (find(edge.s) != find(edge.e)) {
                union(edge.s, edge.e);
                edgeCount++;
                
                if (edge.v == 0) {
                    ascConut++;
                }
                
                if (edgeCount == n) {
                    break;
                }
            }
        }
        return ascConut;
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
            parent[a] = b;
        }
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

// 최악 경로 피로도, 최적 경로 피로도 차이 구하기
// 최악 경로(오르막 우선): 간선 비용 작은 것
// 최적 경로(내리막 우선): 간선 비용이 큰 것

// 오르막 개수 k => k^2 구하여 빼기