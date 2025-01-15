import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] p1 = new int[] {1, 2, 3, 4, 5};
        int[] p2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] answer = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[i%p1.length]) {
                answer[0] += 1;
            }
            if (answers[i] == p2[i%p2.length]) {
                answer[1] += 1;
            }       
            if (answers[i] == p3[i%p3.length]) {
                answer[2] += 1;
            }
        }
        
        // 최댓값 뽑기
        int winner = Math.max(Math.max(answer[0], answer[1]), answer[2]);
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < answer.length; i++) {
            // 최댓값이랑 같으면 추가
            if (winner == answer[i]) {
                result.add(i+1);
            }
        }
        
        int[] temp = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            temp[i] = result.get(i);
        }
        
        return temp;
    }
}


// 루프
// 1번 1, 2, 3, 4, 5
// 2번 2, 1, 2, 3, 2, 4, 2, 5
// 3번 3, 3, 1, 1, 2, 2, 4, 4, 5, 5


// 가장 많이 맞춘 사람 번호 출력, 어렷일 경우 사람 번호 오름차순 정렬
