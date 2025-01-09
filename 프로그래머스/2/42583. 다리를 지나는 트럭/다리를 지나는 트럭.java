import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
       
        int time = 0;
        int sum = 0;
        
        for (int truck : truck_weights) {
            while(true) {
                // 큐가 비어있다면 트럭삽입
                if (q.isEmpty()) {
                    q.add(truck);
                    sum += truck;
                    time++;
                    break;
                }
                
                
                // 큐에 자리가 있는 경우
                else if (q.size() < bridge_length) {
                    // 다리에 적재할 수 있는 무게 체크 
                    if (sum + truck > weight) {
                        q.add(0);
                        time++;
                    } else {
                        q.add(truck);
                        time++;
                        sum+=truck;
                        break;
                    }
                }
                // 큐가 가득 차 있는 경우
                else {
                    int pop_truck = q.poll();
                    sum = sum - pop_truck;
                }
                

            }
        }
        
        // 마지막 트럭 계산
        time = time + bridge_length;
        
        
        
        
        return time;
    }
}


// 큐에 아무것도 없다면 :  트럭 삽입 time +1

// 큐에 자리가 있는경우 : sum + 삽입할 트럭 무게 > weight 인 경우 트럭 삽입 못함. 0 추가, time +1 


// 큐에 자리가 없는 경우 : 큐에서 뻄, 뺸건 시간 포함 안함. sum = sum - q.poll()