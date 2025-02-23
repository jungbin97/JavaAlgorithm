import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        boolean visited[] = new boolean[200_001];
        
        Queue<int[]> q = new ArrayDeque<>();
        int result = Integer.MAX_VALUE;
        
        // 현재위치, 시간
        q.add(new int[] {n, 0});
        visited[n] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowTime = now[1];

            // 동생 만남
            if (nowX == k) {
                result = Math.min(result, nowTime);
            }
            
            if (nowX*2 <= 200_000 && !visited[nowX*2]) {
                q.add(new int[] {nowX*2, nowTime});
                visited[nowX*2] = true;
            }

            if (nowX-1 >= 0 && !visited[nowX-1]) {
                q.add(new int[] {nowX-1, nowTime+1});
                visited[nowX-1] = true;
            }
            
            if (nowX+1 <= 200_000 && !visited[nowX+1]) {
                q.add(new int[] {nowX+1, nowTime+1});
                visited[nowX+1] = true;
            }
        
        }
        
        System.out.println(result);
    }
}