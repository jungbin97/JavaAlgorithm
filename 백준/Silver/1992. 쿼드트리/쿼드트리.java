import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    static int count;
    static ArrayList<Character> result = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        
        recursive(0, 0, n);
        
        for (char c:result){
            System.out.print(c);
        }
    }
    

    static void recursive(int x, int y, int n) {
        // base condition
        if (check(x, y, n)) {
            result.add((char) arr[x][y]);
            return;
        }

        // 쪼개기
        n/= 2;
        result.add('('); 
        // 재귀
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                recursive(x + i * n, y + j * n, n);
            }
        }
        result.add(')');
    }
    
    static boolean check(int x, int y, int n) {
        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if (arr[x][y] != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
}

// n == 2, 2 X 2
// 00
// 00

// 전부 같은 컬러, (0)
// 아니면 쪼개기 n=n/2
// 영역별 재귀 탐색
// 재귀 후 괄호 닫기

// base condition
// 전부 같은 컬러
// 

// n == 3, 8 X 8
// 전부 같으면 == 0
// 아니면 쪼개기
// "("
