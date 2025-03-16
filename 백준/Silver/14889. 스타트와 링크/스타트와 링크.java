import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] S;
    static boolean[] isUsed;
    static ArrayList<Integer> teamB; 
    static ArrayList<Integer> teamA;
    
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 축구 인원
        n = Integer.parseInt(br.readLine());
        S = new int[n][n];
        isUsed = new boolean[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(0, 0);
        
        System.out.println(result);
    }
    
    static void func(int start, int depth) {
        // base condition
        if (depth == n/2) {
            // 방문하지 않은 곳 계산
            teamB = new ArrayList<>();
            teamA = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!isUsed[i]) {
                    teamB.add(i);
                } else {
                    teamA.add(i);
                }
            }
            int teamAValue = sumTeamValue(teamA);
            int teamBValue = sumTeamValue(teamB);

            result = Math.min(result, teamAValue > teamBValue ? teamAValue-teamBValue : teamBValue-teamAValue);
            return;
        }
        
        for (int i = start; i < n; i++) {
            isUsed[i] = true;
            func(i+1, depth+1);
            isUsed[i] = false;
        }
    }

    static int sumTeamValue(ArrayList<Integer> team) {
        int sum = 0;
        for (int i : team) {
            for (int j : team) {
                if (i == j) {
                    continue;
                }
                
                sum += S[i][j];
            }
        }
        return sum;
    }
}



// 스타트 팀과 링크 팀의 능력치 차이 최소값
// 1.. 절반 개수 씩, 경우의 수 모두 구하기(백트래킹)
// 1 1 X 자기 자신안됨.
// 1 2 
// 1 3
// 1 4
// 2 1 X 이미 선택한 조합