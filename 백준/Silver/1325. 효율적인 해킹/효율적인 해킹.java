import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] answer;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 그래프 초기화
        graph = new ArrayList[N+1];
        answer = new int[N+1];
        for (int i = 1; i<N+1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 간선 연결
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
        }


        // 모든 노드 BFS 탐색하기
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            BFS(i);
        }
        
        // 최대값 찾기
        int MaxValue = 0;
        for (int i = 1; i <= N; i++) {
            MaxValue = Math.max(MaxValue, answer[i]);
        }
        
        // 노드 번호 출력하기
        for (int i = 1; i <= N; i++) {
            if (MaxValue == answer[i]) {
                System.out.print(i + " ");
            }
        }
    }
    // BFS 구현
    public static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        visited[node] = true;
        
        while (!q.isEmpty()) {
            int nowNode = q.poll();

            for (int nextNode : graph[nowNode]) {
                if (visited[nextNode] == false) {
                    q.add(nextNode);
                    answer[nextNode]++;
                    visited[nextNode] = true;
                }
            }
        }
    }
}