import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        int n = progresses.length;
        
        int[] days = new int[n];
        
        // 남은 일수 계산
        for (int i = 0; i < n; i++) {
            days[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            
        }
        
        // 배포 그룹
        int current = days[0];
        int count = 1;
        
        for (int i = 1; i < n; i++) {
            if (days[i] <= current) {
                count++;
            } else {
                result.add(count);
                count = 1;
                current = days[i];
            }
        }
        
        result.add(count);
        
        return result.stream().mapToInt(i->i).toArray();
    }
}


// 남은 일수 구하기
//progresses = [93, 30, 55]
//speeds = [1, 30, 5]

// 100-30= (70+30-1)/30 = 3일
// 100-55=(45+5-1)/5 = 9일


