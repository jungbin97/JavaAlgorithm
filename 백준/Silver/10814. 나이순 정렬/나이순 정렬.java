import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String age = st.nextToken();
            String name = st.nextToken();
            arr[i][0] = age;
            arr[i][1] = name;
        }
        
        // 나이순 오름차순 정렬(Comparator)
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
            return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });
        
        for (String[] a : arr) {
            bw.write(a[0] + " " + a[1] + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}


// O(NlogN)
// sdf
