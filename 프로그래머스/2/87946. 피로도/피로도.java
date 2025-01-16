class Solution {
    static boolean[] visited;
    static int answer = -1;
    public int solution(int k, int[][] dungeons) {
        // 던전 개수
        int n = dungeons.length;
        
        // 던전 방문 체크 배열
        visited = new boolean[n];
        
        dfs(dungeons, k, n, 0);
        
        return answer;
    }
    
    static void dfs(int[][] dungeons, int k, int n, int count) {
        
        for (int i = 0; i < n; i++) {
            // 방문하지 않았다면 
            // 현재 피로도가 최소 피로도 크거나 같으면
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(dungeons, k-dungeons[i][1], n, count+1);
                visited[i] = false;
            } 
        }
        answer = Math.max(answer, count);
    }
        
}


// 1 => 2 => 3번 던전 순서
// 첫번째 던전
// 80 -> 60

// 두번째 던전
// 60 -> 20

// 세번쨰 던전 (최소 피로도 만족 X)
// 20 

//=> result = 2
    

// 1. 던전 방문 순서 구하기(던전 최대개수는 8 => dfs)
// 2. 방문할 수 있는 던전 최대로 갱신
