import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] arr;
    static int[] result;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        result = new int[m];
        
        arr = new int[n];
        st = new StringTokenizer(br.readLine()); 
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        
        func(0);
        
        bw.flush();
        bw.close();

    }

    static void func(int index) throws Exception {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }
        
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (temp != arr[i]) {
                result[index] = arr[i];
                temp = result[index];
                func(index+1);
            }
        }
        
    }
}


// 2, 4, 4
// 2
// 4

// 1 7 9 9
// 1 1 
// 1 7
// 1 9
// 1 9 X 같은 Depth에서 뽑은 수 같으면 안됨.
// 7 1 
// 7 7 
// 7 9
// 7 9 X 
// 9 9
// 


// 같은 Depth에서 뽑은 수 가틍면 안됨.