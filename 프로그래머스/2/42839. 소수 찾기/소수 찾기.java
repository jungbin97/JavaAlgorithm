import java.util.*;

class Solution {
    // 1 ~ 9999999
    static boolean[] arr = new boolean[10000000];
    static int count = 0;
    static Set<Integer> set;
    public int solution(String numbers) {
        int answer = 0;
        // 에라토스테네스 채 수행
        isPrime();
        
        // 숫자 개수
        int n = numbers.length();
        boolean[] visited = new boolean[n];
        
        // 숫자 만들기
        set = new HashSet<>();
        dfs(visited, numbers, "", 0, n);
        
        for(Integer num : set) {
            if (!arr[num]) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // 숫자 만들기(dfs)
    public static void dfs(boolean[] visited, String numbers, String s, int depth, int n) {
        // 탈출조건 (depth == n)
        if (depth == n) {
            return;
        }
        
        for(int i = 0; i < n; i++) {
            // 방문하지 않으면
            if(!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(s + numbers.charAt(i)));
                dfs(visited, numbers, s + numbers.charAt(i), depth+1, n);
                visited[i] = false;
            }
        }
        
        
        
    }
    
    
    // 소수는 false
    public static void isPrime() {
        arr[0] = arr[1] = true;
        
        // n의 제곱근까지 나누기
        for (int i = 2; i <= Math.sqrt(10000000); i++) {
            if (!arr[i]) {
                for (int j = i*i; j < arr.length; j+=i) {
                    arr[j] = true;
                }
            }
        }
    }
    
}



// 문자 만들기 0, 1, 1 => 1, 11, 10, 101, 110
// dfs로 만들 수 있음

// 소수 판별 알고리즘(에라토스테네스 체)