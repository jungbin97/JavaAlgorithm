import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int r, c;
    static int[][] paper = new int[12][12];
    static int[][] note = new int[42][42];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 세로, 가로, 스티커 개수
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        // 스티커 

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < c; j++) {
                    paper[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            // 4가지 방향 회전
            for (int rot = 0; rot < 4; rot++) {
                boolean isPaste = false;
                for (int x = 0; x <= N - r; x++) {
                    if (isPaste) break;
                    for (int y = 0; y <= M - c; y++) {
                        if (pastable(x, y)) {
                            isPaste = true;
                            break;
                        }
                    }
                }
                
                if (isPaste) break;
                rotate();
            }
        }
        
        
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (note[i][j]== 1) {
                    result++;
                }
            }
        }
        System.out.println(result);
        
        
    }


    // 스티커 붙이기
    static boolean pastable(int x, int y) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)  {
                if (note[x+i][y+j] == 1 && paper[i][j] == 1){
                    return false;
                }
            }
        }
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)  {
                if (paper[i][j] == 1) {
                    note[x+i][y+j] = 1;
                }
            }
        }
        return true;
    }
    

    // 배열 시계 방향 회전
    static void rotate() {
        int[][] tmp = new int[12][12];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                tmp[j][r-1-i] = paper[i][j];
            }
        }
        
        int tmpR = r;
        r = c;
        c = tmpR;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                paper[i][j] = tmp[i][j];
            }
        }
    }

}


// 스티커는 모두 연결되 있을 것.
// 스티커가 없는 행 or열이 있으면 안됨.
// 

// 스티커 붙이기 
// 스티커는 겹치거나 노트북을 벗어나면 안됨.
// 여러곳 붙일 수 있다면, 스티커는 위쪽, 왼쪽위치를 선택한다.
// 스티커를 붙일 수 있는 위치가 없다면, 시계방향 90도 회전
// 0, 90, 180, 270도 회전해도 붙일 공간 없다면 스티커 버림.
// 


// 스티커 회전하기 