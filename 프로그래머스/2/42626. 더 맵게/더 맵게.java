import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 우선순위 큐 초기화
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        while (pq.peek() < K) {
            // 모두 더해도 k를 넘지 않는 경우
            if (pq.size() <= 1) {
                return -1;
            }
            
            int first = pq.poll();
            int second = pq.poll();
            
            int result = first + (second * 2);
            
            pq.add(result);
            answer++;
        }
        
        return answer;
    }
}


// 모든 음식의 스코빌 지수 K 이상 만들기(만들 수 없는 경우 -1)
//[1, 2, 3, 9, 10, 12]
// 1 + (2 * 2) = 5
//[3, 5, 9, 10, 12]
// 3 + (5 * 2) = 13

// [9, 10, 12, 13]
// 2번


// 우선순위 큐에 가장 작은 것이 K를 넘는지 체크
// 큐의 사이즈가 1이면 K이상으로 만들수 없는 것 => -1반환