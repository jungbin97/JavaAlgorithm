import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int MAX = 1_000_000;
        int[] arr = new int[MAX *2+1];
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[value + MAX] += 1;
        }
        
        for (int i = arr.length -1; i >= 0; i--) {
            if (arr[i] != 0) {
                bw.write(i-MAX + "\n");
            }
        }
        
        
        bw.flush();
        bw.close();
    }
}