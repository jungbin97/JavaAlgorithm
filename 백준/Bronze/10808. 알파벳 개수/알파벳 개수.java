import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);
        char[] S = sc.nextLine().toCharArray();
        
        int[] counts = new int[26];
        
        for (char c : S) {
            counts[c-97] += 1;
        }
        
        // 출력
        for(int i = 0; i < counts.length;i++) {
            System.out.print(counts[i]+ " ");
        }
    }
}

