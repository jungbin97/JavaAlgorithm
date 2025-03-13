import java.util.*;
import java.io.*;

public class Main {
    static int[][] map = new int[505][505];
    static int n,m;
    // 청록색 (2), 노랑색 (1), 주황색(8), 초록색(4), 핑크색(4)
    static int[][][] block = {
        {{0,0}, {0, 1}, {0, 2}, {0, 3}},  // 청록색(가로)
        {{0,0}, {1, 0}, {2, 0}, {3, 0}},  // 청록색(세로)
    
        {{0, 0}, {0, 1}, {1, 0}, {1, 1}},  // 노랑색
    
        {{0, 0}, {0, 1}, {0, 2}, {1, 2}},
        {{0, 0}, {0, 1}, {0, 2}, {1, 0}},
        {{1, 0}, {1, 1}, {1, 2}, {0, 2}},
        {{1, 0}, {1, 1}, {1, 2}, {0, 0}},
    
        {{0, 1}, {1, 1}, {2, 1}, {0, 0}},
        {{0, 1}, {1, 1}, {2, 1}, {2, 0}},
        {{0, 0}, {1, 0}, {2, 0}, {0, 1}},
        {{0, 0}, {1, 0}, {2, 0}, {2, 1}},

        {{0, 0}, {1, 0}, {1, 1}, {2, 1}},  // 초록색(회전 1)
        {{1, 0}, {1, 1}, {0, 1}, {0, 2}},  // 초록색(회전 2)
        {{0, 1}, {1, 1}, {1, 0}, {2, 0}},  // 초록색(회전 3)
        {{0, 0}, {0, 1}, {1, 1}, {1, 2}},  // 초록색(회전 4)
    
        {{0, 0}, {0, 1}, {0, 2}, {1, 1}},  // ㅗ
        {{1, 0}, {1, 1}, {1, 2}, {0, 1}},  // ㅜ
        {{0, 1}, {1, 1}, {2, 1}, {1, 0}},  // ㅓ
        {{0, 0}, {1, 0}, {2, 0}, {1, 1}}   // ㅏ
        
    };
    

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 세로 가로
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        // 맵 초기화
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result = Math.max(result, bruteforce(i ,j));
            }
        }
        
        System.out.println(result);
    }
    
    static int bruteforce(int x, int y) {
        int maxValue = 0;
        for (int i = 0; i < block.length; i++) {
            int sumValue = 0;
            boolean flag = true;
            for (int j = 0; j < 4; j++) {
                int nx = x+block[i][j][0];
                int ny = y+block[i][j][1];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    flag = false;
                    break;
                }
                sumValue += map[nx][ny];
            }
            

            if (flag) {
                maxValue = Math.max(maxValue, sumValue);
            }
        }
        return maxValue;
    }
}

// 4가지 정사각형 연결되있는 5가지 테크로미노를 종위에 놓아 칸수의 합이 가장 큰 것을 찾기
//  
// 1. 4가지 칸이 인접한 경우 찾기 BFS
// 2. 적절한 위치 완전탐색