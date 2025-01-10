import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Stock> stack = new Stack<>();
        int n = prices.length;
        int[] answer = new int[n];
        
        //Arrays.stream(answer).forEach(i -> System.out.println(i));
        
        for (int i = 0; i < n; i++) {
            // stack이 비어있지 않고, top의 가격보다 작다면
            while (!stack.isEmpty() && stack.peek().price > prices[i]) {
                Stock beforeStock = stack.pop();
                answer[beforeStock.index] = i - beforeStock.index;
                //System.out.println(i +"번째 stack 작업, 가격 떨어지지 않은 기간 : " + count);
            }
                
            stack.push(new Stock(i, prices[i]));
        }
        
        // 끝까지 가격이 떨어지지 않은 것 갱신(stack에 남아있는 것)
        for (Stock s : stack) {
            int index = s.index;
            int price = s.price;
            
            // prices 리스트 길이 - 현재 인덱스 + 1
            answer[index] = n - index - 1;
        }
        
        
        
        return answer;
    }
    
    public class Stock {
        int index;
        int price;
        
        public Stock(int index, int price) {
            this.index = index;
            this.price = price;
        }
    }
    
}


// prices순차 탐색
// stack이 비어있다면 추가
// while 반복(현재 price가 stack의 top(이전 가격) 보다 작다면 => 가격이 떨어진 것) 리턴값 갱신해줌 while 수행될때마다 리턴값 증가
// 끝까지 가격 떨어지지 않은 것 갱신.