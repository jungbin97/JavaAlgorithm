import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 테스트 케이스 입력
        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            String str = sc.next();
            LinkedList<Character> list = new LinkedList<>();

            // iterator(커서)
            ListIterator<Character> iterator = list.listIterator(0);

            for (char c : str.toCharArray()) {
                // '<' 일때
                if (c == '<') {
                    // 이전 노드가 존재하면 이동
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                    }
                    // 직전이 previous면 커서 다음 삭제
                // '>' 일때
                } else if (c == '>') {
                    // 다음 노드가 존재하면 이동
                    if (iterator.hasNext()) {
                        iterator.next();
                    }
                // 백스페이스 연산(-)
                } else if (c == '-') {
                    // 이전 문자가 존재하고, 문자이면
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                } else {
                    iterator.add(c);
                }
            }
            
            for (char c : list) {
                bw.append(c);
            }
            bw.append("\n");
        }
        
        bw.flush();
        bw.close();
        
    }
}