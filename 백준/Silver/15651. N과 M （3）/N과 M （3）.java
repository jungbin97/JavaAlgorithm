import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[m];
        
        func(0);
        System.out.println(sb.toString());
    }
    
    
    static void func(int index) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            arr[index] = i;
            func(index+1);
        }
    }
}

// 같은 수를 여러번 골라도 된다.

// [1, ]
// [1, 1]
// [1, 2]
// [1, 3]
// [1, 4]
// [2, ]
// [2, 1]
// [2, 2]
// [2, 3]
// [2, 4]