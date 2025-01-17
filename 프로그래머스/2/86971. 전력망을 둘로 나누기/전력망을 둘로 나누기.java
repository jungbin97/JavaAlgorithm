import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    public int solution(int n, int[][] wires) {
        int answer = 1000;
        
        // grpah 초기화(0 ~ 9)
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 인접 리스트(양방향)
        for (int i = 0; i < wires.length; i++) {
            graph[wires[i][0]].add(wires[i][1]);
            graph[wires[i][1]].add(wires[i][0]);
        }
        
        // 하나씩 연결 끊기
        for (int i = 0; i < wires.length; i++) {
            int result = bfs(wires[i][0], wires[i][1], n);
                
            // 두 전력망 차이 Math.abs((n - result) - result)
            answer = Math.min(answer, Math.abs((n-result) - result));
        }
        
        
        
        return answer;
    }
    
    static int bfs(int node1, int node2, int n) {
        // 큐 생성
        Queue<Integer> q = new LinkedList<>();
        // 방문 배열
        boolean[] visited = new boolean[n+1];
        
        int count = 0;
        // 시작 노드 초기화
        q.add(node1);
        visited[node1] = true;
        
        while(!q.isEmpty()) {
            int nowNode = q.poll();
            count += 1;
            
            for (int nextNode : graph[nowNode]) {
                // 다음 노드가 방문하지 않았고 v2(연결 끊은 노드)를 방문하지 않아야함.
                if (!visited[nextNode] && nextNode != node2) {
                    q.add(nextNode);
                    visited[nextNode] =true;
                }
            }
        }
        
        return count;
    }
}



// 간선 연결을 끊고 bfs 수행(끊은 노드 2개 기준으로 수행)
// 결과 2개가 Math.abs()가 차이가 가장 작은 것을 결과로 출력