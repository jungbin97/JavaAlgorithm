import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 1;
        
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }
        
        for (int i : map.values()) {
            answer *= i;
        }
        
        
        
        
        return answer-1;
    }
}


//(headgear, 2)
//(eyewear, 1)
//2. (2가지+아무것도 선택 안한경우1) * (1가지 + 아무것도 선택 안한경우1) = 3C1 * 2C1 = 6 - 1(둘다 선택 안한경우) = 5
     
    