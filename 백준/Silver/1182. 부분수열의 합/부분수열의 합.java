import java.util.*;
import java.io.*;

public class Main {
    static int n, s;
    static int[] arr;
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i =0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        
        func(0, 0);
        
        // S가0이면 공집합도 포함됨.
        if (s == 0) {
            count = count-1;
        }

        System.out.println(count);
    }
    
    static void func(int sum, int index) {
        // base condition
        if (index == n) {
            if (sum == s) {
                count++;
            }
            return;
        }
        
        func(sum, index+1);
        func(sum+arr[index], index+1);
    }
}

// 부분집합 개수는 2^5-1(공집합 제외)


// 매번 더할경우 안 더할 경우로 분기 
// base condtion
// index== n이고 
// 합해온 값이 == s와 같음 count++
