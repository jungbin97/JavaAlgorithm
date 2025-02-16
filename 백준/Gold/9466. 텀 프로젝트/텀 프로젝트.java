import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int[] visited;
    static int[] isCycle;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < tc; t++) {
            // 학생 수 
            int n = Integer.parseInt(br.readLine());
            
            // 그래프 초기화
            arr = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            // 사이클 체크 배열(방문하지않음 0, 사이클 1)
            visited = new int[n+1];
            isCycle = new int[n+1];

            // 1부터 탐색
            for (int i = 1; i <= n; i++) {
                // 아직 방문하지 않으면
                if (visited[i] == 0) {
                    dfs(i);
                }
            }

            // 논사이클 속한 개수
            int result = 0;
            for (int i = 1; i <= n; i++) {
                if (isCycle[i] != 1) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
    
    public static void dfs(int x) {
        // visited[]는 3가지 상태를 가진다. 0: 방문하지 않음, 1: 방문중, 2: 방문완료
        visited[x] = 1;
        int next = arr[x];
        
        // 아직 방문하지 않으면,
        if (visited[next] == 0) {
            dfs(next);
        // 방문 중인 노드 다시 방문 -> 사이클
        } else if (visited[next] == 1) {
            makeCycle(next);
        }
        
        // x에 대한 dfs 수행완료
        visited[x] = 2;
    }
    
    private static void makeCycle(int start) {
        int now = start;
        while (true) {
            isCycle[now] = 1;
            now = arr[now];
            
            if (now == start) {
                break;
            }
        }
    }
}

// 사이클과 non사이클 체크
// 방문하지 않은 곳 dfs 순회 자기자신을 만나면 그사이 거쳐간 것들 모두 사이클
// 방문하지 않은 곳 중 연결된 노드에 사이클과 non사이클을 만나는 것은 사이클에 속하지 못한것.