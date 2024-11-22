import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        long A = sc.nextLong();
        long B = sc.nextLong();

        long[] arr = new long[10000001];
        
        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }
        
        // 제곱근까지 수행하기
        for (int i = 2; i <= Math.sqrt(arr.length); i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = i + i; j < arr.length; j = j + i) { // 배수 제거
                arr[j] = 0;
            }
        }
        int count = 0;

        for (int i = 2; i < 10000001; i++) {
            if (arr[i] != 0) {
                double square = (double) arr[i] * arr[i];
                // 범위에 속하는지 판단하기
                while (square <= B) {
                    if (square >= A) {
                        count++;
                    }
                    square *= arr[i];
                }
                
            }
        }
        System.out.println(count);

    }
}