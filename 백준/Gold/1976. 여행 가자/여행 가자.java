import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // 도시 개수
        int n = sc.nextInt();
        
        // 여행 계획에 속한 도수
        int m = sc.nextInt();
        
        // 도시 데이터 저장
        int[][] dosi = new int[n+1][n+1];
        
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dosi[i][j] = sc.nextInt();
            }
        }
        
        // 여행 도시 경로 입력
        int[] route = new int[m+1];
        
        for (int i = 1; i <= m; i++) {
            route[i] = sc.nextInt();
        }
        
        parent = new int[n+1];
        
        for (int i = 1; i <= n; i++) {
            // 대표 노드를 자기 자신으로 초기화
            parent[i] = i;
        }
        
        // 인접 행렬에 도시가 연결되어 있으면 union연산 수행
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dosi[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        
        // 여행 계획 도시들이 1개의 대표 도시로 연결되어있느지 확인
        int index = find(route[1]);
        for (int i = 2; i < route.length; i++) {
            if (index != find(route[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    // union
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }
    
    // find
    public static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
}