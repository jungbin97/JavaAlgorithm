import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static int[] distance;
    static boolean[] visited;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); 	//정렬 기준 가장 작은 비용
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
        
        visited = new boolean[n+1];
        
        // 최단 거리 배열 초기화
        distance = new int[n+1];
        for (int i = 1; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        
        
        // 시작 지점 세팅
        pq.add(new int[] {1, 0});  //시작 노드 (1, 거리: 0)
        distance[1] = 0;
        
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowNode = now[0];
            int nowDistance = now[1];
            
            // 이미 방문한 노드면 패스
            if (visited[nowNode]) {
                continue;
            }
            
            visited[nowNode] = true;
            
            for (Integer nextNode : graph[nowNode]) {
                if(distance[nextNode] > nowDistance + 1) {
                    distance[nextNode] = nowDistance+1;
                    pq.add(new int[] {nextNode, distance[nextNode]});
                }
            }
        }
        
        
        // 가장 큰 수 찾기
        int maxValue = 0;
        for (int i = 1; i < distance.length; i++) { 
            maxValue = Math.max(distance[i], maxValue);
        }
        
        for (int i = 1; i < distance.length; i++) { 
            if (maxValue == distance[i]){
                answer++;
            }
        }           
        
        return answer;
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