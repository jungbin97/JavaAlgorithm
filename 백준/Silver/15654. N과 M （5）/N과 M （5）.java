import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] arr;
    static int[] result;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        isUsed = new boolean[n];
        result = new int[m];
        arr = new int[n];
        st= new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 오름차순 정렬
        Arrays.sort(arr);
        
        func(0);
        
        System.out.println(sb.toString());
    }
    
    static void func(int index) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if (!isUsed[i]) {
                result[index] = arr[i];
                isUsed[i] = true;
                func(index+1);
                isUsed[i] = false;
            }
        }
    }
}



// 오름차순 출력, 중복된 수열 X