import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10_001];
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[value] += 1;
        }
        
        for (int i = 0; i < 10_001; i++) {
            if (arr[i] != 0) {
                for (int j = 0; j < arr[i]; j++) {
                    bw.write(i + "\n");
                }
            }
        }
        
        
        bw.flush();
        bw.close();
    }
}