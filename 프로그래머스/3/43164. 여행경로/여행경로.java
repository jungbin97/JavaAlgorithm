import java.util.*;

class Solution {
    public static List<String> answer = new LinkedList<>();
    public String[] solution(String[][] tickets) {
        // 티켓 개수
        int n = tickets.length;
        
        // 방문 배열
        boolean[] visited = new boolean[n];
        
        // 알파벳 순으로 탐색
        Arrays.sort(tickets, (a, b) -> (a[0].equals(b[0])) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));
        
        // 시작 지점 방문 처리
        answer.add("ICN");
        dfs("ICN", 0, n, tickets, visited);
        
        
        return answer.stream().toArray(String[]::new);
    }
    
    public static boolean dfs(String current, int index, int n, String[][] tickets, boolean[] visited) {
        if (index == n) {
            return true;
        }
        
        for (int i = 0; i < n; i++) {
            // 현재 공항에서 출발하는 티켓 검색
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                answer.add(tickets[i][1]);
                
                // DFS
                if (dfs(tickets[i][1], index+1, n, tickets, visited)) {
                    return true;
                }
                
                visited[i] = false;
                answer.remove(answer.size() - 1);
            }
            
        }
        return false;
    }
    
}


// ICN -> JFK -> HND -> IAD
// ICN -> SFO -> ATL -> ICN -> ATL -> SFO


// DFS로 구현