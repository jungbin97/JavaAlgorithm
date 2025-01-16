class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int totalTile = brown + yellow;
        
        for (int i = 1; i <= totalTile; i++) {
            // 나누어 떨어지면
            if (totalTile%i==0) {
                // 가로, 세로
                int width = i;
                int length = totalTile / width;
                // 가로가 세로보다 커야함
                if (width >= length) {
                    if (((width-2) * (length-2)) == yellow) {
                        System.out.println("가로 세로 :" +width + ", " + length);
                        answer[0] = width;
                        answer[1] = length;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}

// 가로가 더 길다.

// brown + yellow = 12
// 12 / 1 = 12
// 12 / 2 = 6
// 12 / 3 = 4
// 12 / 4 = 3
// 가로 세로
//(4-2) * (3-2) = 2(yellow)