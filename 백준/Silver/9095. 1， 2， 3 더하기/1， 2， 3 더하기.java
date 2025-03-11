import java.util.*;
import java.io.*;

public class Main {
    static int result = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        arr = new int[] {1, 2, 3};
        
        int tc = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            
            func(n, 0);
            System.out.println(result);
            result = 0;
        }
        
    }
    
    static void func(int n, int sum) {
        // base condtion
        if (sum == n) {
            result++;
            return;
        }
        
        if (sum > n) {
            return;
        }
        
        for (int num : arr) {
            func(n, sum+num);
        }
    }
}


