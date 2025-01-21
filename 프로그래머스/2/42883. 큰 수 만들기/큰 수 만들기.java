import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        String answer = "";
        
        for (int i = 0; i < number.length(); i++) {
            char nowNum = number.charAt(i);
            
            while (k > 0 && !stack.isEmpty() && stack.peek() < nowNum) {
                stack.pop();
                k--;
            }
            stack.push(nowNum);
        }
        
        // k가 남은 경우: 54321
        // 뒤에서 남은 K만큼 제거
        if (k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : stack) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}



// 1924, k=2
// 1, 2제거 94

// 1231234, k=3
// 1, 2, 1제거 3234


// stack = [1]
// stack = [2], stack.peek() = 1 < 2,stack.pop(1) stack.append(2) 
// stack = [3], stack.peek() = 2 < 3,stack.pop(2) stack.append(3)
// stack = [3, 1] stack.peek() > 1, stack.append(1)
// stack = [3, 2] stack.peek() < 2, stack.pop(1), stack.append(2)

// k = 0 => 3234


// k == 0인 경우 나머지 문자 쭉 추가하기