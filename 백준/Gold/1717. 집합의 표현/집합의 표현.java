import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        // 자기 자신으로 초기화
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            // 0이면 합치기
            if (oper == 0) {
                union(a, b);
            } else if (oper == 1) {
                if (find(a) == find(b)) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }

        }
    }
    
    static void union(int a, int b) {
        // 루트 찾기
        a = find(a);
        b = find(b);
        
        if (a != b) {
            parent[b] = a;
        }
    }
    
    static int find(int node) {
        // 자기 자신이면 루트 노드o
        if (node == parent[node]) {
            return node;
        } else {
            return parent[node] = find(parent[node]);
        }
        
    }

}