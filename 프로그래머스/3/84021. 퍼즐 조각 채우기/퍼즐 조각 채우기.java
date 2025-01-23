import java.util.*;

class Solution {
    // 상하좌우
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] game_board, int[][] table) {
        List<List<int[]>> blocks = new ArrayList<>();
        List<List<int[]>> emptyBoard = new ArrayList<>();
        
        int row = game_board.length;
        int col = game_board.length;
        
        // 2차원 방문 배열
        boolean[][] visited = new boolean[row][col];
        
        // game_board에서 빈공간 추출
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 게임보드 0이고, 방문하지 않은 곳
                if (game_board[i][j] != 1 && !visited[i][j]) {
                    emptyBoard.add(bfs(visited, game_board, i, j, row, col, 0));
                }
            }
        }
        
        // table에서 블록 추출
        row = table.length;
        col = table.length;
        
        visited = new boolean[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 게임보드 0이고, 방문하지 않은 곳
                if (table[i][j] != 0 && !visited[i][j]) {
                    blocks.add(bfs(visited, table, i, j, row, col, 1));
                }
            }
        }
        
        int answer = -1;
        
        // 일치하는지 체크
        answer = match(emptyBoard, blocks);
        
        
        return answer;
    }
    
    // 일치하는지 체크
    private int match(List<List<int[]>> emptyBoard, List<List<int[]>> blocks) {
        int result = 0;
        boolean[] usedBlock = new boolean[blocks.size()];
        
        
        for (int i = 0; i < emptyBoard.size(); i++) {
            List<int[]> empty = emptyBoard.get(i);
            
            // 블록 대입
            for (int j = 0; j < blocks.size(); j++) {
                // 사용한 블록은 패스
                if (usedBlock[j]) continue;
                
                List<int[]> block = blocks.get(j);

                // 사이즈가 맞지 않으면 미리 탈출
                if (block.size() != empty.size()) continue;
                
                // 비교, 회전
                if (rotationAndCompare(empty, block)) {
                    result += block.size();
                    usedBlock[j] = true;
                    break;
                }
            }
        }
        return result;
    }
    
    // 빈공간과 블록 비교
    private boolean rotationAndCompare(List<int[]> empty, List<int[]> block) {
        List<int[]> rotated = block;
        
        // 회전
        for (int i = 0; i < 4; i++) {
            if (compare(empty, rotated)) {
                return true;
            }
            
            if (i < 3) {
                rotated = rotate(rotated);
            }
        }
        return false;
    }
    
    // 블록 시계방향 90도 회전(+ 정규화)
   	private List<int[]> rotate(List<int[]> block) {
        List<int[]> result = new ArrayList<>();
        
        // x, y => y, -x
        for (int[] b : block) {
            int x = b[1];
            int y = -b[0];
            
            result.add(new int[] {x, y});
        }
        return normalize(result);
    }
    
    // empty와 block을 비교수행
	private boolean compare(List<int[]> empty, List<int[]> block) {
        Collections.sort(empty, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        Collections.sort(block, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        
        for (int i = 0; i < empty.size(); i++) {
            int[] e = empty.get(i);
            int[] b = block.get(i);
            
            if (e[0] != b[0] || e[1] != b[1]) {
                return false;
            }
        }
        return true;
    }
    
    private List<int[]> bfs(boolean[][] visited, int[][] arr, int startX, int startY, int row, int col, int target) {
        List<int[]> result = new ArrayList<>();

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {startX, startY});
        visited[startX][startY] = true;

        // BFS 수행
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            // 결과 리스트 추가
            result.add(now);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 체크 && 방문체크 && target과 일치하는지 체크
                if (nx >= 0 && ny >= 0 && nx < row && ny < col && visited[nx][ny] == false) {
                    if (arr[nx][ny] == target) {
                        visited[nx][ny] = true;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }

        // 정규화로 넘겨줌.
        return normalize(result);
    }
    
    
    // 정규화 수행
    private List<int[]> normalize(List<int[]> list) {
        int minX = 51;
        int minY = 51;
        
        for (int[] b : list) {
            // 블럭 중 가장 작은 좌표 찾기
            minX = Math.min(minX, b[0]);
            minY = Math.min(minY, b[1]);
        }
        
        for (int[] b : list) {
            b[0] -= minX;
            b[1] -= minY;
        }
        
        return list;
    }
}


// table에서 블럭 위치 추출(BFS) => 정규화
// game_board 빈 공간 위치 추출(BFS) => 정규화

// game_board 빈공간 위치에 블럭 하나씩 대입
// 1. game_board 빈공간 위치
// 2. 블럭 위치 대입 -> 90도 회전 후 정규화 대입(3번) => 블럭 마다 반복
// 3. 딱 맞으면 game_board 개수 더하기