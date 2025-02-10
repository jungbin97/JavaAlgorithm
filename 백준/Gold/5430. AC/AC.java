import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            // 커맨드 입력
            char[] command = br.readLine().toCharArray();
            
            // 배열에 들어가 있는 수
            int arrSize = Integer.parseInt(br.readLine());
            
            // 배열 초기화
            Deque<Integer> dq = new ArrayDeque<>();
            // 0이 아니면 값 입력 받기
            if (arrSize > 0) {
                String input = br.readLine().replace("[", "").replace("]", "");
                st = new StringTokenizer(input, ",");
                
                for (int i = 0; i < arrSize; i++) {
                    dq.add(Integer.parseInt(st.nextToken()));
                }
            } else {
                br.readLine();
            }
            
            boolean reverseFlag = false;
            boolean errorFlag = false;
            // 커맨드 수행
            for (int i = 0; i < command.length; i++) {
                // 뒤집기
                if (command[i] == 'R') {
                    reverseFlag = !reverseFlag;
                // 첫번쨰 수 버리기
                } else if (command[i] == 'D') {
                    // 배열의 사이즈가 0이면 error
                    if (arrSize == 0) {
                        System.out.println("error");
                        errorFlag = true;
                        break;
                    }
                    
                    // 뒤에서 빼기
                    if (reverseFlag) {
                        dq.pollLast();
                        arrSize--;
                    } else {
                        dq.pollFirst();
                        arrSize--;
                    }
                }
            }
            
            // 출력
            if (!errorFlag) {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                
                if (!dq.isEmpty()) {

                    // 정방향, 역방향 출력 
                    if (!reverseFlag) {
                        for (int ch : dq) {
                            sb.append(ch).append(",");
                        }
                    } else if (reverseFlag) {
                        Iterator<Integer> iter = dq.descendingIterator();
                        while (iter.hasNext()) {
                            sb.append(iter.next()).append(",");
                        }
                    }
                // 마지막 ',' 제거 및 ']' 추가
                sb.setLength(sb.length() - 1);
                }
                
                sb.append("]");
                System.out.println(sb.toString());
            }
        }
        
    }
}


// R: 배열 수의 순서 뒤집기
// D: 첫번쨰 수 버리기, 배열 비어있는데 사용하면 error

// RDD 
// 1 2 3 4

// 4 3 2 1
// 2 1


// 뒤집기 수행하면 뒤에서 빼기, 또 뒤집기 수행하면 앞에서 빼기
// 마지막 뒤집기가 앞에서 뺴기면 정방향 출력, 뒤면 역순출력

// 빈 배열 처리에 유의 해야한다.