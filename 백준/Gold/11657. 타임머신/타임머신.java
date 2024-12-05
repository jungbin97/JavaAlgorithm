import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static long[] distance;
    static Edge[] edges;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 노드
        N = Integer.parseInt(st.nextToken());
        // 엣지
        M = Integer.parseInt(st.nextToken());
        
        // 엣지 리스트 초기화
        edges = new Edge[M+1];
        // 거리 배열 초기화
        distance = new long[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        // 에지 리스트에 데이터 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, time);
        }
        
        // 벨만 포드 알고리즘 수행
        distance[1] = 0;
        // N보다 1개 적은 수만큼 수행
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                // 더 작은 최단 거리 있을 경우 업데이트
                if (distance[edge.start] != Integer.MAX_VALUE 
                && distance[edge.end] > distance[edge.start] + edge.time) {
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }
        
        boolean mCycle = false;
        
        // 음수 사이클 확인
        for (int i = 0; i < M; i++) {
            Edge edge = edges[i];
            if (distance[edge.start] != Integer.MAX_VALUE 
            && distance[edge.end] > distance[edge.start] + edge.time) {
                mCycle = true;
            }
        }

        // 음의 사이클 없을 때
        if (!mCycle) {
            for (int i = 2; i <= N; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }
            }
        } else {
            System.out.println("-1");
        }
        

    }

    static class Edge {
        int start, end, time;

        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
}