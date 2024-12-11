import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    // 행렬 크기, 섬 넘버
    static int N, M, sumNum;
    // graph 정보 저장
    static int[][] graph;
    // BFS 방문체크 배열
    static boolean[][] visited;
    // 섬 위치 저장
    static ArrayList<ArrayList<int[]>> sumlist;
    static ArrayList<int[]> mlist; 
    
    // 우선 순위 큐
    static PriorityQueue<Edge> pq;
    // 부모 배열
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // graph 초기화
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // vistied 배열
        visited = new boolean[N][M];
        
        // 섬 넘버
        sumNum = 1;

        // 섬 분리 작업
        sumlist = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] != 0 && !visited[i][j]) {
                    BFS(i, j);
                    sumNum++;
                    sumlist.add(mlist);
                }
            }
        }
        
        // 엣지 저장 우선순위 큐
        pq = new PriorityQueue<>();
        
        // 엣지 만들기(섬의 각 지점에서 만들 수 있는 모든 엣지 저장하기)
        for (int i = 0; i < sumlist.size(); i++) {
            ArrayList<int[]> now = sumlist.get(i);
            
            for (int j = 0; j < now.size(); j++) {
                int x = now.get(j)[0];
                int y = now.get(j)[1];
                
                // 현재 섬의 넘버
                int now_S = graph[x][y];
                
                for (int d = 0; d < 4; d++) {
                    int tempX = x + dx[d];
                    int tempY = y + dy[d];
                    
                    int bridgeSize = 0;
                    while (tempX >= 0 && tempY >= 0 && tempX < N && tempY < M) {
                        // 같은 섬이면 엣지 생성 불가
                        if (graph[tempX][tempY] == now_S) {
                            break;
                        }
                        // 바다면 다리 늘리기 
                        else if (graph[tempX][tempY] == 0) {
                            bridgeSize++;
                        }
                        // 섬이면
                        else {
                            if (bridgeSize > 1) {
                                pq.add(new Edge(now_S, graph[tempX][tempY], bridgeSize));
                            } 
                            break;
                        }
                        tempX += dx[d];
                        tempY += dy[d];
                    }
                }

            }
        }
        
        // 섬의 개수(노드 개수)
        parent = new int[sumNum];
        
        for (int i = 0; i < sumNum; i++) {
            parent[i] = i;
        }
        
        int useEdge = 0;
        int result = 0;
        // 최소 신장 트리 알고리즘 수행
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            
            // 같은 부모 아니면 합치기
            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);
                result = result + now.v;
                useEdge++;
            }
        }

        if (useEdge == sumNum - 2) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }

    }
    
    // union 연산
    public static void union(int a, int  b) {
        a = find(a);
        b = find(b);
        
        if (a != b) {
            parent[a] = b;
        }
    }
    
    // find 연산
    public static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            // 경로 압축
            return parent[a] = find(parent[a]);
        }
    }
    
    public static void BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        mlist = new ArrayList<>();
        
        int[] start = {i, j};
        
        q.add(start);
        mlist.add(start);
        visited[i][j] = true;
        graph[i][j] = sumNum;
        while (!q.isEmpty()){
            int now[] = q.poll();
            
            int x = now[0];
            int y = now[1];
            
            // 4가지 방향 탐색
            for (int d = 0; d < 4; d++) {
                int nextX = x + dx[d];
                int nextY = y + dy[d];
            
                if (nextX >= 0 && nextY >=0 && nextX < N && nextY < M) {
                    // 현재 방문한적 없고 바다가 아니면
                    if (visited[nextX][nextY] == false && graph[nextX][nextY] != 0) {
                        graph[nextX][nextY]= sumNum;
                        visited[nextX][nextY] = true;
                        mlist.add(new int[] {nextX, nextY});
                        q.add(new int[] {nextX, nextY});
                    }   
                }
            }
        }
    }
    
    public static class Edge implements Comparable<Edge> {
        int s, e, v;

        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        // 오름차순 정렬(비용이 작은 순서로 뽑기 위해)
        public int compareTo(Edge o) {
            return Integer.compare(this.v, o.v);
        }
    }
}
