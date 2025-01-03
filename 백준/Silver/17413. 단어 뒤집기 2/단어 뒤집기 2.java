import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        char[] temp = br.readLine().toCharArray();
        StringBuilder tempBuffer = new StringBuilder();
        boolean inTag = false;
        
        for (char ch : temp) {
            // 태그 모드
            if (ch == '<') {
                // 현재까지 버퍼에 담은 내용 뒤집어서 출력
                if (tempBuffer.length() > 0) {
                    bw.write(tempBuffer.reverse().toString());
                    tempBuffer.setLength(0);
                }
                inTag = true;
                // 태그 < 그래로 출력하기
                bw.write(ch);
            } else if (ch == '>') {
                // 태그 모드 종료
                inTag = false;
                bw.write(ch);
            } else if (inTag) {
                bw.write(ch);
            } else if (ch == ' ') {
                // 현재 버퍼를 내용을 뒤집기, 공백 출력
                if (tempBuffer.length() > 0) {
                    bw.write(tempBuffer.reverse().toString());
                    tempBuffer.setLength(0);
                }
                bw.write(ch);
            } else {
                // 일반 문자 버퍼에 추가
                tempBuffer.append(ch);
            }
        }

        // 마지막 일반 문자열이면 버퍼에 남아있을 수 있음.
        if (tempBuffer.length() > 0) {
            bw.write(tempBuffer.reverse().toString());
        }

        
        bw.flush();
        bw.close();
    }
}

// 문자열 쪼개기
// 1. <> 는 하나의 단위 태그
// 2. <>없으면 문자열, 문자열은 공백을 나누어져있음.
//  태그는 그대로 출력, 문자열은 뒤집어야 한다.