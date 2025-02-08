import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        // 첫번쨰 문자열 
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        
        // 0이 아니면 제거해야할 문자
        int[] checkChar = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            checkChar[str1.charAt(i)-'a']++;
        }
        
        for (int i = 0; i < str2.length(); i++) {
            checkChar[str2.charAt(i)-'a']--;
        }
        
        int result = 0;
        for (int i = 0; i < checkChar.length; i++) {
            if (checkChar[i] != 0) {
                result += Math.abs(checkChar[i]);
            }
        }
        
        System.out.println(result);
    }
}


// 최소개수 제거로 애너그램을 만들어라 => 같은 문자 찾고, 같지않은것들 카운트