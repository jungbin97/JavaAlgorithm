import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int d1 = sc.nextInt();

            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int d2 = sc.nextInt();

            double d = Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2), 2));

            // 원이 완전히 겹침
            if (x1 == x2 && y1 == y2 && d1 == d2) {
                System.out.println("-1");
            } 
            
            // 원이 겹치지 않음 (외부 내부)
            else if (d1 + d2 < d || d < Math.abs(d1 - d2)) {
                System.out.println("0");
            }
            
            // 원이 맞닿음
            else if (d1 + d2 == d || d == Math.abs(d1 - d2)) {
                System.out.println("1");
            }

            // 원이 겹치는 점 2개
            else if ((d1 - d2) * (d1 - d2) < (d*d) && (d*d) < (d1 + d2) * (d1 + d2)) {
                System.out.println("2");
            }

        }
    }
}