class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0, 0);
        
        return answer;
       
    }
    
    public static void dfs(int[] number, int target, int sum, int idx) {
        if (idx == number.length) {
            if (sum == target) {
                answer += 1;
            }
            return;
        }
        
        dfs(number, target, sum+number[idx], idx+1);
        dfs(number, target, sum-number[idx], idx+1);
    }
}