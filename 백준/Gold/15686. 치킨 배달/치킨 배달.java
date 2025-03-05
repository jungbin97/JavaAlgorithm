import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] graph;
    static ArrayList<int[]> chickenArr;
    static ArrayList<int[]> houseArr;
    static int result = Integer.MAX_VALUE;

    static boolean[] isUsed;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 행, 치킨 집 개수
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        chickenArr = new ArrayList<>();
        houseArr = new ArrayList<>();
        graph = new int[n][n];

        // 집, 치킨 집 좌표 구하기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 2) {
                    chickenArr.add(new int[] {i, j});
                } else if (graph[i][j] == 1) {
                    houseArr.add(new int[] {i, j});
                }
            } 
        }
        
        isUsed = new boolean[chickenArr.size()];
        func(0, 0);
        
        System.out.println(result);
        
    }
    
    // 치킨 조합 구하기(백 트래킹)
    static void func(int start, int index) {
        if (index == m) {
            result = Math.min(result, calDistance());
            return;
        }
        
        for (int i = start; i < chickenArr.size(); i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                func(i+1, index+1);
                isUsed[i] = false;
            }
        }
    }
    
    // 치킨 거리의 합 구하기
    static int calDistance() {
        int totalCount = 0;
        
        for (int[] house : houseArr) {
            int houseX = house[0];
            int houseY = house[1];
            int minDist = Integer.MAX_VALUE;

            for (int i = 0; i < chickenArr.size(); i++) {
                if (isUsed[i]) {
                    int[] chicken = chickenArr.get(i);
                    int chickenX = chicken[0];
                    int chickenY = chicken[1];
                    
                    minDist = Math.min(minDist, Math.abs(chickenX - houseX) + Math.abs(chickenY- houseY));
                }
            }
            totalCount += minDist;
        }

        return totalCount;
    }
}


// 도시의 치킨 거리의 합 최솟값 구하기
// 0 빈칸, 1 집, 2 치킨집

// 1. m개수에 도달하면 최솟값이면 갱신(조합, 백트래킹)
// 2. 치킨 거리 구하기



// (1, 2), (5, 5), (3, 1)
// m = 2

// 1, 2
// 1, 3
// 2, 3