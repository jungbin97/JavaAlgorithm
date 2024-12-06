import java.util.*;
import java.io.*;

public class Main {
	static final int INF = 9900001;
    static int[][] graph;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        graph = new int[n+1][n+1];
        
        for (int i = 1; i <=n; i++){
            for (int j = 1; j <= n; j++){
                // 자기 자신일 경우 0
                if (i == j) continue;
                // 초기값 INF
                graph[i][j] = INF;
            }
        }
        
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = Math.min(graph[a][b], c);
        }
        // 플로이드 워셜 알고리즘 수행
        for (int k = 1; k <= n; k++){
            for (int a = 1; a <= n; a++){
                for (int b = 1; b <= n; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }
        
        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=n; i++){
            for (int j = 1; j <= n; j++){
                if (graph[i][j] == INF) sb.append("0 ");
                else sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}