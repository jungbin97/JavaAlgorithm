import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long N = sc.nextLong();
        long L = sc.nextLong();
        boolean flag = true;
        
        while (L <= 100) {
        
            // 시작 값 구하기
            long a = N / L - (L - 1) / 2;


            // 음수면 
            if (a < 0) {
                break;
            } 

            if (N == (a * 2 + L - 1) * L / 2){
                for (long i = 0; i < L; i++) {
                    bw.write(a + i + " ");
                }
                flag = false;
                break;
            }
            
            L += 1;
        }
        
        
        if (flag) {
            bw.write("-1");
        }
        bw.write("\n");
        bw.flush();
    }
}
