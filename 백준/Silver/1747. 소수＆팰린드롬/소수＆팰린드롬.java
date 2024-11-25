import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        // 수 n 입력 받기
        int n = sc.nextInt();

        // A 소수 판별할 배열 n의 개수 만큼
        int[] A = new int[1003002];
        for (int i = 2; i < A.length; i++) {
            A[i] = i;
        }

        // 에라토스테네스 체 사용
        for (int i = 2; i < Math.sqrt(A.length); i++){
            if (A[i] == 0) {
                continue;
            }
            for (int j = i + i; j < A.length; j = j + i) {
                A[j] = 0;
            }
        }

        int i = n;
        // 펠린드롬 판별하기(N부터 차례대로 있으면 반환)
        while(i < 1003002) {
            if (A[i] != 0) {
                int result = A[i];
                if (isPalindrome(result)) {
                    System.out.println(result);
                    break;
                }
            }
            i++;
        }
    }
    // 펠린드롬 수행
    public static boolean isPalindrome(int target) {
        char[] temp = String.valueOf(target).toCharArray();
        int s = 0;
        int e = temp.length - 1;
        
        while (s < e) {
            if (temp[s] != temp[e]) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}