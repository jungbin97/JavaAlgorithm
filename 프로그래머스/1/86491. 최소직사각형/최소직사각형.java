import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int width  = 0;
        int height = 0;
        for (int i = 0; i < sizes.length; i++) {
            
            int x = Math.max(sizes[i][0], sizes[i][1]);
            int y = Math.min(sizes[i][0], sizes[i][1]);
            
            width = Math.max(width, x);
            height = Math.max(height, y);
        }
        answer = width * height;
        
        return answer;
    }
}

// 가로세로 중 가장 큰 것 = 80
// 가로세로 중 작은 것 중 큰 것

// 80 * 70 = 5600
// 80 * 50 = 4000
// 80 * 60 = 5400
// 70 * 80 = 5600