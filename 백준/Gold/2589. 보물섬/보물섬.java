import java.util.*;
import java.io.*;

public class Main {
    static int r, c;
    static char[][] arr;
    static int result;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        arr = new char[r][c];
        
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        
        result = 0;
        // 해당 육지로부터 최단거리로 갈수있는 가장 먼거리
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 육지면
                if (arr[i][j] == 'L') {
                    visited = new boolean[r][c];
                    bfs(i,j);
                }
            }
        }

        System.out.println(result);
    }
    
    static void bfs(int i, int j) {
        Queue<Node> q = new LinkedList<>();

        Node startNode = new Node(i, j, 0);
        q.add(startNode);
        visited[i][j] = true;
        
        while (!q.isEmpty()) {
            Node currentNode = q.poll();
            
            for (int k = 0; k < 4; k++) {
                int nx = currentNode.x + dx[k];
                int ny = currentNode.y + dy[k];
                
                // 범위 체크 및 육지 체크
                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                    if (arr[nx][ny] == 'L' && visited[nx][ny] == false) {
                        visited[nx][ny] = true;
                        q.add(new Node(nx, ny, currentNode.count+1));
                        result = Math.max(result, currentNode.count+1);
                    }
                }
            }
        }
        
    }
    
    static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}