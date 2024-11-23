import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[][] arr = new int[n+1][n+1];
        
        // 배열 초기화
        for (int i = 0; i <= n; i++) {
            // i개중 1개를 뽑는 경우
            arr[i][1] = i;
            // i개중 하나도 선택하지 않을 경우
            arr[i][0] = 1;
            // i개중 i개를 선택할 경우
            arr[i][i] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
            }
        }
        System.out.println(arr[n][m]);
        
        
    }
}