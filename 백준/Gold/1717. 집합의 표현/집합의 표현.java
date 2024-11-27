import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 원소 개수
        int n = Integer.parseInt(st.nextToken());
        // 질의 개수
        int m = Integer.parseInt(st.nextToken());
        
        arr = new int[n+1];
        
        // 배열 자신 노드로 초기세팅
        for(int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int question = Integer.parseInt(st.nextToken()); 
            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken()); 
            
            // 합집합연산
            if (question == 0) {
                union(a, b);
            } else {
                if (checkSame(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

        
    }
    
    // 대표 노드 까리 연결하기
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            arr[b] = a;
        }
    }


    // 대표 노드 찾기
    public static int find(int a) {
        if (a == arr[a]) {
            return a;
        } else {
            return arr[a] = find(arr[a]);
        }
    }
    
    // 두원소가 같은 집합인지
    public static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a == b) {
            return true;
        } else {
            return false;
        }
    }
}