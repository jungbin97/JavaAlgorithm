import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
		Stack<Character> stack = new Stack<>();
        
        char[] arr = s.toCharArray();
        for (char c : arr) {
            // 열린괄호
            if (c == '(')  {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        
        if (!stack.empty()) {
            return false;
        }

        return answer;
    }
}