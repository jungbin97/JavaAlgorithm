import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static int[] result;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        graph = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        
        // 엣지 간접 리스트 초기화
        for (int i = 0; i < edge.length; i++) {
        	int start = edge[i][0];
        	int end = edge[i][1];
            graph[start].add(end);
            graph[end].add(start);
        }
        
        boolean[] visited = new boolean[n+1];
        result = new int[n+1];
        
        bfs(visited, 1);
        
        //for (int i = 1; i < result.length; i++) {
        //    System.out.println(i + " 노드의 최소 간선 비용: "+ result[i]);
        //}
        
        // 최단 경로 중 최댓값 찾기
        int maxValue = 0;
        for (int i = 1; i < result.length; i++) {
            maxValue = Math.max(maxValue, result[i]);
        }
        
        // 최댓값과 동일한 비용 찾기
        for (int i = 1; i < result.length; i++) {
            if (maxValue == result[i]) {
                answer ++;
            }
        }
        
        
        return answer;
    }
    
    private void bfs(boolean[] visited, int start) {
        Queue<Integer> q= new LinkedList<>();
        
        // 초기값 세팅
        visited[start] = true;
        q.add(start);
        result[start] = 0;
        
        // BFS 수행
        while (!q.isEmpty()) {
            int node = q.poll();
            int nodeValue = result[node];
            
            // 인접 노드 탐색
            for (Integer nextNode : graph[node]) {
                // 아직 방문하지 않은 노드이면 이동
                if (!visited[nextNode]) {
                    result[nextNode] = nodeValue + 1;
                    q.add(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }
    
    
}


// 1번 노드에서 가장 멀리떨어진 노드의 개수(최단경로로 이동했을때 가장 간선의 개수가 많은 노드)


// 방법 1.
// 다익스트라로 1에서 출발하여 도착하는 전체 노드 최단경로 구하기
// 최단경로중 가장 큰 값 찾기



// 방법 2.
// [1] => [2, 3] => [3, 5, 4] => [5, 4, 6]
// 0         1			2			2
// bfs로도 충분히 탐색 가능