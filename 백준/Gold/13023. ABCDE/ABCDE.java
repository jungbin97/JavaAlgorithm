import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean exist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 노드 개수
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        A = new ArrayList[n];
        visited = new boolean[n];

        // 배열 초기화
        for (int i = 0; i < n; i++) {
            A[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        
        // 노드별 DFS 탐색 시작
        for (int i = 0; i < n; i++) {
            DFS(i, 1);
            if (exist) {
                break;
            }
        }
        
        if (exist) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
        
    }
    
    static void DFS(int now, int depth) {
        // 탈출 조건
        // depth가 5이상이면 종료 
        if (depth >= 5 || exist) {
            exist = true;
            return;
        }
        
        visited[now] = true;
        
        for (int i : A[now]) {
            if (!visited[i]) {
                DFS(i, depth + 1);
            }
        }
        visited[now] = false;
    }

}