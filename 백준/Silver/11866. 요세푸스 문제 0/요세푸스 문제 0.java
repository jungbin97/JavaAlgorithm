import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        Queue<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>(); 

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        
        int count = 0;
        while(!q.isEmpty()) {
            int temp = q.poll();
            
            count++;
            if (count == k) {
                count = 0;
                result.add(temp);
                continue;
            }
            q.add(temp);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < result.size()-1; i++){
            sb.append(result.get(i)).append(", ");
        }
        sb.append(result.get(result.size()-1)).append(">");
        
        System.out.println(sb.toString());
    }
}

// 1~7명, 3번
// 1 2 3 4 5 6 7
// 3

// 4 5 6 7 1 2
// 6
