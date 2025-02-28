import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] arr;
    static int[] result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        result = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
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
        

        for (int i = 0; i < n; i++) {
            result[index] = arr[i];
            func(index+1);
        }
    }

}



// 자기 자신 선택 가능
// 중복된 수열은 안됨.
// 수열은 오름차순