import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 노드 개수
        int N = Integer.parseInt(br.readLine());
        
        // 인접 행렬 초기화
        int[][] distance = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                distance[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 플로이드 워셜
        // 중간 노드
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (distance[i][k] == 1 && distance[k][j] == 1) {
                        distance[i][j] = 1;
                    }
                }
            }
        }
        
        // 출력
        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
        
    }
}