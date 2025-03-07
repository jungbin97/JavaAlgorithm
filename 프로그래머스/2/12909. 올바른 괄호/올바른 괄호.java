import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
		Stack<Character> stack = new Stack<>();
        
        //char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')  {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        
        if (!stack.isEmpty()) {
            return false;
        }

        return answer;
    }
}