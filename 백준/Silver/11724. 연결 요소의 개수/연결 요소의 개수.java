import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
        /**********************************************************************
         *
         *
         **********************************************************************/
        static boolean[] visited;
        static ArrayList<Integer>[] A;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            visited = new boolean[n+1];
            A = new ArrayList[n+1];

            for(int i =1; i<n+1; i++){
                A[i] = new ArrayList<Integer>();
            }

            for(int i = 0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                // 무방향그래프이므로 연결되어있는 양쪽 다 초기화
                A[s].add(e);
                A[e].add(s);
            }

            int count = 0;
            for(int i = 1; i<n+1; i++){
                // 방문하지 않은 노드가 있으면
                if(!visited[i]){
                    count++;
                    DFS(i);
                }
            }
            System.out.println(count);
        }

    private static void DFS(int v) {
        visited[v] = true;
        for(int i : A[v]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }
}
