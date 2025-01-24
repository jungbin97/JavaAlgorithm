import java.util.*;

class Solution {
    static int[] parent;
    static PriorityQueue<Edge> pq;
    public int solution(int n, int[][] costs) {
        
        // 우선 순위 큐 초기화
        pq = new PriorityQueue<>();
        // 유니온파인드 배열 초기화
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        
        for (int[] c : costs) {
            Edge edge = new Edge(c[0],c[1],c[2]);
            pq.add(edge);
        }
      
        int result = 0;
        int useEdge = 0;
        while (useEdge < n-1) {
            // 가장 작은 엣지 
            Edge nowEdge = pq.poll();
            
            int startNode = nowEdge.s;
            int endNode = nowEdge.e;
            int value = nowEdge.v;
            
            // 사이클이 형성 되지 않는다면 union 연산
            if (find(startNode) != find(endNode)) {
                union(startNode, endNode);
                useEdge++;
                result = result + value;
            }
        }
        
        
        
        return result;
    }
    
    // find 연산 구현
    public static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        //경로 압축
        return parent[a] = find(parent[a]);
    }
    
    // union 연산 구현
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a != b) {
            parent[b] = a;
        }
    }
    
    public class Edge implements Comparable<Edge> {
        int s;	// 시작 노드
        int e; 	// 도착 노드
        int v;	// 간선의 비용
        
        Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }
        
        // 간선의 비용 기준 오름차순 정렬
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.v, o.v);
        }
    }
}


// 최소의 비용으로 모든 섬 => 크루스칼(MST: 최소신장트리) 판단(?)


// 크루스칼 알고리즘
// 엣지(간선) 기준 리스트
// 노드 개수 N=4, 탈출조건 간선 개수가 N-1
// 사이클 판단(union-find 알고리즘으로)