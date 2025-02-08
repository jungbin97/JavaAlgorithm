import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] pre = new int[5001];
        int[] next = new int[5001];

        // 결과 저장
        ArrayList<Integer> result = new ArrayList<>();

        int len = 0;
        // 그처음 노드와 마지막 노드가 서로키서로 가르키도록 지정
        for (int i = 1; i <= n; i++) {
            pre[i] = (i==1) ? n : i-1;
            next[i] = (i==n) ? 1 : i+1;
            len++;
        }

        int count = 1;
        for (int cur = 1; len != 0; cur = next[cur]) {
            // K번째일때 제거
            if (count == k) {
                // 현재 노드 제거
                pre[next[cur]] = pre[cur];
                next[pre[cur]] = next[cur];
                count = 1;
                len--;
                result.add(cur);
            } else {
                count++;
            }
        }
        
        // 출력
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < result.size(); i++) {
            if (i == result.size()-1) {
                sb.append(result.get(i) + ">");
                break;
            }
            sb.append(result.get(i)+ ", ");

        }

        System.out.println(sb.toString());
    }
}


// 1 2 3 4 5 6 7
// => 3

// 456712
// => 6

//     1 2 3 4 5 6 7
//pre  7 1 2 3 4 5 6
//next 2 3 4 5 6 7 1