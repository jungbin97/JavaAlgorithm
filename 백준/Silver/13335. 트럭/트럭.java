import java.util.*;
import java.io.*;

public class Main {
    static int n, w, L;
    static Queue<Integer> truckQ = new ArrayDeque<>();
    static int[] bridge;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 트럭 개수, 다리길이, 다리하중
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        bridge = new int[w];
        // 트럭 큐에 추가
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< n; i++) {
            truckQ.add(Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        // 트럭이 다 건널떄까지 반복
        while(!truckQ.isEmpty() || !isBridgeEmtpy()) {
            // 트럭이동
            moveTruck();
            // 현재 다리 위 트럭의 총 무게
            int currentBridgeWidght = calculateWeight();
            
            // 새트럭 올라갈 수 있는지 체크
            if (!truckQ.isEmpty() && currentBridgeWidght + truckQ.peek() <= L) {
                bridge[0] = truckQ.poll();
            }
            
            time++;
        }
        
        System.out.println(time);
    }
    
    static void moveTruck() {
        for (int i = w-1; i > 0; i--) {
            bridge[i] = bridge[i-1];
        }
        bridge[0] = 0;
    }

    static int calculateWeight() {
        int sum = 0;
        for (int weight : bridge) {
            sum += weight;
        }
        return sum;
    }

    static boolean isBridgeEmtpy() {
        for(int weight : bridge) {
            if (weight != 0) {
                return false;
            }
        }
        return true;
    }
}


// 1. 트럭의 개수가 w를 넘어서면 안된다.
// 2. 트럭의 무게가 다리의 하중보다 작거나 같아야한다.
