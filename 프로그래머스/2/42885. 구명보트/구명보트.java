import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        // 필요한 구멍 보트 개수
        int count = 0;
        // 사람 무게 순 정렬(오름차순)
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length-1;
        
        while (left <= right) {
            // 가장 무거운 사람 + 가장 가벼운사람 이동 > limit이면 무거운사람 이동, maxIndex--
            if (people[left] + people[right] > limit){
                right--;
                count++;
            } else {
                left++;
                right--;
                count++;
            }
        }
        
        
        
        return count;
    }
}



// [70, 50, 80, 50], 무게 제한 100이하까지, 최대인원 2
// [50, 50, 70, 80]


// [50, 80]=> 80 => 1
// [50, 70] => 70 => 1
// [50, 50] => 1


// [70, 80, 50], 무게 제한 100이하까지, 최대인원 2
// [50, 70, 80]

// [50, 80] => 80 => 1 , maxindex--
// [50, 70] => 70 => 1 , maxIndex--
// [50] => minIndex==maxIndex => 1


// 투포인터 적용
// 가장 무거운 사람 + 가장 가벼운사람 이동 > limit이면 무거운사람 이동, maxIndex--
// 가장 무거운 사람 + 가장 가벼운사람 이동 < limit이면 같이 이동, minIndex++, maxIndex--
