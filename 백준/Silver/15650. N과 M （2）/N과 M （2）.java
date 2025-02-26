import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[m];
        
        func(1, 0);
    }
    
    static void func(int start, int index) {
        // base condition
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        
        for (int i = start; i <= n; i++) {
            arr[index] = i;
            func(i+1, index+1);
        }
    }
}


// 1, 2, 3, 4

// 1, 2
// 1, 3
// 1, 4
// 2, 3
// 2, 4
// 3, 4