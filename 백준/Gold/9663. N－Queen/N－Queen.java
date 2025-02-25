import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int count;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        
        func(0);
        System.out.println(count);
    }
    static boolean check(int index) {
        for (int i = 0; i < index; i++) {
            if (arr[index] == arr[i] || Math.abs(arr[index] - arr[i]) == index - i) {
                return false;
            }
        }
        return true;
    }
    
    static void func(int index) {
        if (index == n) {
            count++;
            return;
        } else {
            // 해당 행의 열을 차례대로 탐색하여 유망한곳 찾기
            for (int i = 0; i < n; i++) {
                arr[index] = i;
                if (check(index)) {
                    func(index+1);
                }
            }
        }
    }
}


// Q 이동 경로: 상하좌우, 대각선