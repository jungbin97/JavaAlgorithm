import java.util.*;
import java.io.*;

public class Main {
    static int k;
    static int[] arr;
    static int result[] = new int[6];
    static boolean[] isUsed;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            String line = br.readLine();
            // 종료 조건
            if (line.equals("0")) {
                break;
            }
            st = new StringTokenizer(line);
            k = Integer.parseInt(st.nextToken());
            isUsed = new boolean[k];
            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(arr);
            func(0, 0);
            bw.write("\n");
            
            


        }
        bw.flush();
        bw.close();    
    }

    
    static void func(int start, int index) throws IOException {
        if (index == 6) {
            for (int i = 0; i < 6; i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }
        
        for (int i = start; i < k; i++) {
            result[index] = arr[i];
            func(i+1, index+1);
        }
    }
    
}


// 1, 2, 3, 4, 5, 6, 7
// 오름차순으로 출력
/// 1 2 3 4 5 6
/// 1 2 3 4 5 7
/// 1 2 3 4 6 7
// 1 2 3 4 