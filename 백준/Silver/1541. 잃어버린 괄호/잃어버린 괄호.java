import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int answer = 0;
        String[] str = sc.nextLine().split("-");
        for (int i = 0; i < str.length; i++) {
            int temp = mySum(str[i]);

            if (i == 0) {
                answer = answer + temp;
            } else {
                answer = answer - temp;
            }
        }
        System.out.println(answer);

    }

    static int mySum(String a) {
        int sum = 0;
        String[] temp = a.split("\\+");
        
        for (int i = 0; i < temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }
}