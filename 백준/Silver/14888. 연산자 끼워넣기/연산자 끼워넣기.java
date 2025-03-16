import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 수의 개수
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        

        // 덧셈, 뺄셈, 곱셈, 나눗셈 순
        int[] operatorCount = new int[4];
        st = new StringTokenizer(br.readLine()); 
        for (int i = 0; i<4; i++) {
            operatorCount[i] = Integer.parseInt(st.nextToken());
        }
        
        func(1, arr[0], operatorCount[0], operatorCount[1], operatorCount[2], operatorCount[3]);
        
        System.out.println(maxValue);
        System.out.println(minValue);
    }
    
    static void func(int depth, int sum, int plus, int minus, int muti, int division) {
        // base condition
        if (depth == n) {
            maxValue = Math.max(maxValue, sum);
            minValue = Math.min(minValue, sum);
            return;
        }
        
        // 덧셈이 있다면 
        if (plus != 0) {
            func(depth+1, sum+arr[depth], plus-1, minus, muti, division);
        }

        if (minus != 0) {
            func(depth+1, sum-arr[depth], plus, minus-1, muti, division); 
        }
        
        if (muti != 0) {
            func(depth+1, sum*arr[depth], plus, minus, muti-1, division);
        }
        
        if (division != 0) {
            func(depth+1, sum/arr[depth], plus, minus, muti, division-1);
        }
    }
}

// 식의 결과가 최대인 것과 최소인것 구하기
// 수의 순서를 바꾸면 안됨.
