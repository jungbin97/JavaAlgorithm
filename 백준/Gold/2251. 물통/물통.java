import java.util.*;

import javax.sound.midi.Receiver;

import java.io.*;

public class Main {
    // 6가지 경우 탐색을 위한 배열
    static int[] sender = {0, 0, 1, 1, 2, 2};
    static int[] reciver = {1, 2, 2, 0, 1, 0};
    
    static boolean[] answer;
    static boolean[][] visitied;
    static int[] now;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        now = new int[3];

        // 물통 A,B,C 초기화
        now[0] = sc.nextInt();
        now[1] = sc.nextInt();
        now[2] = sc.nextInt();
        
        // 방문배열
        visitied = new boolean[201][201];
        answer = new boolean[201];
        

        // BFS 수행
        BFS();

        // answer true인것 출력
        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                System.out.print(i + " ");
            }
        }
    }
    
    public static void BFS() {
        // 큐에 출발노드 담기
        Queue<AB> q = new LinkedList<>();
        // A, B가 0인상태로 시작
        q.add(new AB(0, 0));
        visitied[0][0] = true;
        // C의 기본물양
        answer[now[2]] = true;
        
        while (!q.isEmpty()) {
            AB p = q.poll();
            int A = p.A;
            int B= p.B;
            // 현재 C의 물양
            int C = now[2] - A - B;
            
            // 6가지 체크
            for (int k = 0; k < 6; k++) {
                int[] next = new int[] {A, B, C};
                next[reciver[k]] = next[reciver[k]] + next[sender[k]];
                next[sender[k]] = 0;
                // 초과하는 만큼 다시 이전 물통에 넣어줌
                if (next[reciver[k]] > now[reciver[k]]) {
                    next[sender[k]] = next[reciver[k]] - now[reciver[k]];
                    next[reciver[k]] = now[reciver[k]];
                }
                // A와 B의 물의 양을 이용해 방문 배열 체크
                if (!visitied[next[0]][next[1]]) {
                    visitied[next[0]][next[1]] = true; 
                    q.add(new AB(next[0], next[1]));
                    if (next[0] == 0) {
                        // A의 물의양이 0일때 C의 물의 무게를 정답변수에 저장
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }
}

class AB {
    int A;
    int B;

    public AB(int A, int B) {
        this.A = A;
        this.B = B;
    }
}
