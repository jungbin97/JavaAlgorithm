import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> str = new LinkedList<>();

        String S = br.readLine();
        // 마지막 인덱스 지정
        ListIterator<Character> iter = str.listIterator();
        // 링크드 리스트 삽입
        for (char c : S.toCharArray()) {
            iter.add(c);
        }

        
        // 커맨드 개수 입력
        int command = Integer.parseInt(br.readLine());
        
        
        // 커맨드 수행
        StringTokenizer st;
        for (int i = 0; i < command; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
        
            // L, 커서를 왼쪽으로 한칸 옮김.(커서가 0이면 무시)
            if (c == 'L' && iter.hasPrevious()) {
                iter.previous();
           // D, 커서를 오른쪽으로 한칸 옮김.(리스트 사이즈랑 같으면 무시)
            } else if (c == 'D' && iter.hasNext()) {
                iter.next();
           // B, 커서 왼쪽에 있는 문자를 삭제(커서가 0이면 무시)
            } else if (c == 'B' && iter.hasPrevious()) {
                iter.previous();
                iter.remove();
           // 현재 커서 왼쪽에 문자 추가
            } else if (c == 'P') {
                char e = st.nextToken().charAt(0);
                iter.add(e);
            }
        }

        // 리스트 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Character ch : str) {
            bw.append(ch);
        }

        bw.close();
        System.out.println(bw.toString());
    }
}