import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[i] = value;
        }
        
        Arrays.sort(arr);
        
        for (int a : arr) {
            bw.write(a + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}