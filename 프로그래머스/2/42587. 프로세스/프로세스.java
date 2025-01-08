import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < priorities.length; i++) {
            int[] node = new int[] {priorities[i], i}; // {우선 순위, 인덱스}
            q.add(node);
            pq.add(priorities[i]); // 우선순위 큐에 우선순위 추가
        }
        
        int answer = 0;
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            
            // 현재 꺼낸게 우선순위가 가장 높은지 체크
            if (current[0] == pq.peek()) {
                pq.poll(); // 우선순위에서 제거
                answer++;
                
                if (current[1] == location) {
                    return answer;
                }
                
            } else {
                q.add(current); // 우선순위가 더 높은게 있으므로 다시 큐에 추가
            }
        }
        
        return answer;
    }
    
    
}

// [2, 1, 3, 2]
// [A, B, C, D]

// B, C, D, A
// C, D, A, B
// D, A, B
// A, B
// B


// priorites에 넘버링 (0, 1, 2 ...)
// 우선순위 순서대로 수행
// priorites 넘버링 == location이면 큐에서 꺼낸 순서 반환(1, 2, 3...)