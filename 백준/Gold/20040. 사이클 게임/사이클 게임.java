import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 점의 개수, 진행된 차례의 수
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        // 부모 배열 초기화
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int result = 0;
        // 차례 진행(union)
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if (find(a) == find(b)) {
                result = i;
                break;
            } else {
                union(a, b);
            }
            
        }
        System.out.println(result);
    }

    static int find(int a) {
        if (a == parent[a]) return a;
        
        return parent[a] = find(parent[a]);
    }
    
    static void union(int a, int b) {
        // 루트 찾기
        a = find(a);
        b = find(b);
        
        if (a!=b) {
            parent[b] = a;
        }
    }
}


// 모든 차례가 지나도 사이클이 없다면 0 출력
// 사이클이 만들어지는 차레 수 구하기