import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[m];
        visited = new boolean[n+1];

        func(0);
        
    }

    static void func(int index) {
        // escape
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                arr[index] = i;
                visited[i] = true;
                func(index+1);
                visited[i] = false;
            }
        }
    }
}

// 배열이 가득차면 저장, 그리고 다음거 넣기, 없으면 이전단계로?