import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int count = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                // 중복 제거(여벌이 있는데 도난 당한 경우)
                if (lost[i] == reserve[j]) {
                    count++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]-1 || lost[i] == reserve[j]+1) {
                    count++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        
        return n - lost.length + count;
    }
}


// 1 2 3 4 5

// lost: 2, 4
// reserve: 1, 3, 5


// 1 -> 2
// 3 -> 4 


// 1 2 3 4 5
// lost: 2, 4
// reserve: 3

// 3 -> 4

// 1. 현재 들을 수 있는 학생 계산 (n - lost.length)
// 2. 여벌이 있는 학생이 도난 당할 경우 빌려 줄 수 없음(reserve와 lost 동시에 있는 학생) => count + 1 후 lost, reserve 제거
// 3. reserve 앞 뒤에 lost있는지 확인(?)