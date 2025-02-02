import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] graph = new int[n+1][n+1];
        for (int i = 0; i < results.length; i++) {
            graph[results[i][0]][results[i][1]] = 1;  // win
            graph[results[i][1]][results[i][0]] = -1; // lose
        }
        
        //floyd warshall 알고리즘
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] == 1 && graph[k][j]==1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <=n; j++) {
                if (graph[i][j] != 0) {
                    count++;
                }
            }
            if (count == n-1) {
                answer++;
            }
        }
        
        return answer;
    }
}
// ㅅㄴㅓㅅㅜ - ㅇㅣㄱㅣㄴ ㅅㅓㄴㅅㅜ ㅂㅓㄴㅎㅗ
// 4 - 2, 3
// 3 - 2
// 1 - 2
// 2 - 5


