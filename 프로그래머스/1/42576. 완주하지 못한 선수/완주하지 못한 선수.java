import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // 완주자 목록 hashSet추가(검색 O(1))
        Map<String, Integer> map = new HashMap<>();
        
        for (String part : participant) {
            map.put(part, map.getOrDefault(part, 0) + 1);
        }
        
        for (String com : completion) {
            map.put(com, map.get(com) - 1);
        }
        
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}



// 중복문제 발생
// 동명이인이 여러명이면 한사람이 완주하면, 제거해버리므로 나머지 동명이인 참가자는 모두 미완주 처리함.


// HashMap으로 count를 하여 동명이인 처리를 해주어야함.
// participant를 순회하면서 카운트
// completion을 순회하면서 카운트 제거
// count 가0이 아닌 key 출력