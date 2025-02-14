import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        boolean[] visited = new boolean[F+1];
        
        Queue<int[]> q = new ArrayDeque<>();
        visited[S] = true;
        q.add(new int[] {S, 0});
        
        int result = 0;
        boolean resultFlag = false;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowlocation = now[0];
            int nowCount = now[1];
            
            // 탈출 조건
            if (G == nowlocation) {
                result = nowCount;
                resultFlag = true;
                break;
            }

            // 2가지 방향 체크
            int[] dir = new int[] {U, -D};
            for (int d : dir) {
                int nextlocation = nowlocation + d;
                
                // 인덱스 체크 && 방문 체크
                if (0 < nextlocation && F >= nextlocation) {
                    if (!visited[nextlocation]) {
                        visited[nextlocation] = true;
                        q.add(new int[] {nextlocation, nowCount + 1});
                    }
                }
            }
            
        }
        
        if (!resultFlag) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result);
        }

        
    }
}

// F: 건물 층수
// S: 현재 층수
// G: 목표 층
// U: 위로 이동하는 층수
// D: 아래로 이동하는 층수
// U, D 해당 층수 없을떄 이동 불가
//  1 3 5 7 9 8 10
