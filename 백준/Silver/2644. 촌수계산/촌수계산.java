import java.util.*;
import java.io.*;

public class Main {
    static int start, end;
    static List<Integer>[] arr;
    static int result = -1;
    static boolean[] check;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // 연속된 번호 n
        int n = sc.nextInt();

        start = sc.nextInt();
        end = sc.nextInt();

        // 촌수 개수
        int m = sc.nextInt();
        
        arr = new ArrayList[n+1];
        check = new boolean[n+1];
        for (int i = 1; i < n+1; i++) {
            arr[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            arr[x].add(y);
            arr[y].add(x);
        }
        
        dfs(start, end, 0);
        System.out.println(result);
    }

    static void dfs(int start, int end, int count) {
        if (start == end) {
            result = count;
            return;
        }
        
        check[start] = true;
        for (int i : arr[start]) {
            int next = i;
            
            if (!check[i]) {
                dfs(i, end, count+1);
            }
        }
    }
}