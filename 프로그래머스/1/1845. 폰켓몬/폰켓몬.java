import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int n = nums.length;
        // 중복 값 제거 배열
        Set<Integer> set_nums = new HashSet<>();
        
        for (int num : nums) {
            set_nums.add(num);
        }
        
        if (set_nums.size() < n/2) {
            answer = set_nums.size();
        } else {
            answer = n/2;
        }
        
        return answer;
    }
}

// [3, 3, 3, 2, 2, 4]
// 중복 제거 후
// [3, 2, 4]


// [3, 3, 3, 2, 2, 2]
// 중복 제거 후
// [3, 2]


// 중복제거한 배열 크기 < n/2 : 중복제거 배열 크기가 가장많은 종류 포켓몬 선택
// 중복제거한 배열 크기 > n/2 : n/2가 최대값이다.