import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        for (int a : arr) {
            if (stack.empty() || !stack.peek().equals(a)) {
                stack.push(a);
            }
        }
        
        
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}