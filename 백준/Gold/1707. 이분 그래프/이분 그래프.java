import java.util.*;
import java.io.*;

public class Main {
    static int T;
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static boolean IsEven;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        // 테스트 케이스 실행
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 노드 개수 입력 받기
            int v = Integer.parseInt(st.nextToken());
            // 간선 개수 입력 받기
            int e = Integer.parseInt(st.nextToken());

            // 인접리스트로 그래프 배열 초기화
            graph = new ArrayList[v+1];
            for (int j = 1; j <= v; j++) {
                graph[j] = new ArrayList<>();
            }
            // 방문 배열
            visited = new int[v+1];
            for (int j = 0; j <= v; j++) {
                visited[j] = -1;
            }

            // 그래프 배열 간선 연결
            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine()); 
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph[start].add(end);
                graph[end].add(start);
            }

            IsEven = true;
            // 각 노드 개수 만큼 반복(노드간의 연결이 안된곳도 있으니)
            for (int j = 1; j <= v; j++) {
                if (visited[j]==-1 && IsEven) {
                    visited[j] = 1;
                    DFS(j);
                }
            }
            
            // 이분 그래프 결과 출력
            if (IsEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    
    // DFS 구현
    public static void DFS(int node) {
        for (int i : graph[node]) {
            if (visited[i] == -1) {
                //인접한 노드는 같은 집합이 아니므로 이전 노드와 다른 노드 처리
                if (visited[node] == 1) {
                    visited[i] = 2;
                } else {
                    visited[i] = 1;
                }
                DFS(i);
            } // 이미 방문한 노드가 현재 노드와 같은 집합이면 이분 그래프 아님
            else if (visited[node] == visited[i]) {
                IsEven = false;
                return;
            }
        }
    }
}