import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        map = new char[n][2*n - 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], ' ');
        }
        

        func(0, n-1, n);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < 2*n - 1; j++) {
                sb.append(map[i][j]);
            } 
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
    
    static void func(int x, int y, int n) {
        // base condition
        if (n == 3) {
            map[x][y] = '*';
            map[x+1][y-1] = '*';
            map[x+1][y+1] = '*';
            for (int i = y -2; i <= y+2; i++) {
                map[x+2][i] = '*';
            }
            return; 
        }
        
        func(x, y, n/2);
        func(x+n/2, y-n/2, n/2);
        func(x+n/2, y+n/2, n/2);

    }
}


// 3 X 2^k

// 3 => 6 => 12 => 24

// n=24일떄, 3 X 2^3
// 세로: 3 X 2^3 = 24개
// 가로: 6 X 2^3 = 48개


// n = 3일때 k=1, 3 X 2^0
// func(0, n-1, n)
//
// base condtion
// map[x][y] = '*';
// map[x+1][y-1] = map[x+1][y+1] = '*'
// map[x+2][y-2]  map[x+2][y-1] = map[x+2][y] = map[x+2][y+1] = map[x+2][y+2]
// return;


// n = 24일떄 k=3, 3 X 2^3
// func(0, n-1, n)

// 재귀 삼격형 3개 나누기
// func(x, y, n/2);
// func(x+n/2, y-n/2, n/2)
// func(x+n/2, y+n/2, n/2)