import java.util.*;
import java.io.*;

public class Main {
    static char[][] arr;
    static boolean[][] visited;
    static int result;
    static int[] dx = {0, 1, -1 , 0};
    static int[] dy = {1, 0, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new char[12][6];
        for (int i = 0; i < 12; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        
        while (true) {
            boolean exploded = false;
            
            // 같은 색이 4개 이상인 것 찾기
            List<int[]> allPuyos = new ArrayList<>();
            visited = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    // 빈공간이 아니고, 방문하지 않았다면
                    if (arr[i][j] != '.' && !visited[i][j]) {
                        List<int[]> puyoGroup = bfs(i, j, arr[i][j]);
                        if (!puyoGroup.isEmpty()) {
                            allPuyos.addAll(puyoGroup);
                            exploded = true;
                        }
                    }
                }
            }

            // 블록 터트리기
            if (!exploded) {
                break;
            }
            popPuyo(allPuyos);
            
            // 중력 적용
            gravity();
            
            result++;
        }
        
        System.out.println(result);
    }
    
    // 같은 색의 블록 BFS 탐색
    static List<int[]> bfs(int x, int y, char color) {
        // 터질 블록 리스트
        List<int[]> puyoList = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.add(new int[] {x, y});
        puyoList.add(new int[]{x, y});
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            for (int d = 0; d < 4; d++) {
                int nx = cx+ dx[d];
                int ny = cy+ dy[d];
                
                if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;
                if (!visited[nx][ny] && arr[nx][ny] == color) {
                    queue.add(new int[] {nx, ny});
                    puyoList.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return puyoList.size() >= 4 ? puyoList : new ArrayList<>();
    }
    
    // 블록 터트리기
    static void popPuyo(List<int[]> puyoList) {
        for (int[] puyo : puyoList) {
            arr[puyo[0]][puyo[1]] = '.';
        }
    }
    
    // 블록 떨어뜨리기
    static void gravity() {
        // 열에 대해 중력 적용
        for (int col = 0; col < 6; col++) {
            Queue<Character> temp = new ArrayDeque<>();
            
            // 아래에서 위로 스캔하기
            for(int row = 11; row >= 0; row--) {
                if (arr[row][col] != '.') {
                    temp.add(arr[row][col]);
                    arr[row][col] = '.';
                }
            }

            int row = 11;
            while (!temp.isEmpty()) {
                arr[row--][col] = temp.poll();
            }
        }
    }

}

// 연쇄 횟수를 구하여라
//
// 같은 색 뿌요 4개 이상 상하좌우 연결 체크(여러개면 동시에 터져야함.)
// 중력에 의해 떨어짐.