import java.util.*;
import java.io.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String[]> q = new LinkedList<>();
        // 방문 체크 배열
        boolean[] visited = new boolean[words.length];
        int answer = 0;
        
        q.add(new String[] {begin, "0"});
        
        while (!q.isEmpty()) {
            String[] now_word = q.poll();
            
            // 탈출 조건
            if (now_word[0].equals(target)) {
                answer = Integer.parseInt(now_word[1]);
                return answer;
            }
            
            for (int i = 0; i < words.length; i++) {
                // 이미 방문한 단어이면 
                if (visited[i]) {
                    continue;
                }
                
                // 같지 않은 단어 개수 체크
                int not_same_char = 0;
                for (int j = 0; j < words[i].length(); j++)  {
                    if (words[i].charAt(j) != now_word[0].charAt(j)) {
                        not_same_char++;
                    } 
                }
                
                // 같지 않은 단어 개수가 1개일때 큐삽입, 방문체크
                if (not_same_char == 1) {
                    int count = Integer.parseInt(now_word[1])+1;
                    q.add(new String[] {words[i], Integer.toString(count)});
                    visited[i] = true;
                }
                
                
            }
            
            
        }
        
        return answer;
    }
}


// bfs탈출 조건 : 현재 단어 == target 현재
// words 배열에 하나만 다른것 있는지 체크