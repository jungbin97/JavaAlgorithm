import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        // 숫자 갯수
        int[] numCount = new int[10];

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        String result = String.valueOf(a * b * c);
        
        for (int i = 0; i<result.length(); i++) {
            int num = result.charAt(i) - '0';
            numCount[num] += 1;
        }
        
        for (int i = 0; i < numCount.length; i++) {
            System.out.println(numCount[i]);
        }
        
    }
}

