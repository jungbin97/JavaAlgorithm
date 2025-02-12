import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // {현재 위치, count} 상태 보관
        Queue<int[]> q = new ArrayDeque<>();

        int result = 0;
        boolean[] visited = new boolean[100001];
        
        q.add(new int[] {n, 0});
        visited[n] = true;

        // bfs 수행
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            // 수빈이 위치랑 동생위치 같으면, count 반환
            if (now[0] == k) {
                result = now[1];
                break;
            }
            
            int[] nxValue = new int[]{now[0]-1, now[0]+1, now[0]*2}; 
            for (int nx : nxValue) {
                // 인덱스 범위 체크 && 방문체크
                if (0 <= nx && nx < 100001 && !visited[nx]) {
                    q.add(new int[] {nx, now[1]+1});
                    visited[nx] = true;
                }
            }
        }
        
        System.out.println(result);

    }
}


// 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20