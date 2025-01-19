import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 요청 시간 순으로 정렬
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        
        // 우선순위 큐  소요시간이 작은 순으로
        PriorityQueue<Job> pq = new PriorityQueue<>();
        
        int currentTime = 0; // 현재시간
        int totalTime = 0;  // 총 작업 시간
        int jobIndex = 0;	 // 다음 작업 인덱스
        int count = 0;		 // 처리한 작업 수
        
        while (count < jobs.length) {
            // 현재 시간까지 도착한 모든 작업을 우선순위 큐에 추가
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= currentTime) {
                pq.add(new Job(jobs[jobIndex][1], jobs[jobIndex][0], jobIndex));
                jobIndex++;
            }
            
            if (!pq.isEmpty()){
                // 우선순위에서 소요시간이 짤은 작업 선택
                Job currentJob = pq.poll();
                currentTime += currentJob.soyoTime; // 현재 시간을 작업 완료시간으로 업데이트
                totalTime += currentTime - currentJob.requireTime; // 작업 시간 계산
                count++;
            } else {
                // 현재시간에 도착한 작업이 없다면 다음작업시간으로 이동
                currentTime = jobs[jobIndex][0];
            }
            
        }
        
        return totalTime/jobs.length;
    }
    
    class Job implements Comparable<Job> {
        int soyoTime;	// 소요시간
        int requireTime;// 작업 요청 시간(큐에 삽입된 시간?)
        int number;		// 작업 번호
        
        public Job(int soyoTime, int requireTime, int number) {
            this.soyoTime = soyoTime;
            this.requireTime = requireTime;
            this.number = number;
        }
        
        @Override
        public int compareTo(Job other) {
            if (this.soyoTime != other.soyoTime) {
                return Integer.compare(this.soyoTime, other.soyoTime);
            }
            
            if (this.requireTime != other.requireTime) {
                return Integer.compare(this.requireTime, other.requireTime);
            }
            return Integer.compare(this.number, other.number);
        }
    }
}


// 우선순위 순서: 작업의 소요시간 짧은 것, 작업의 요청시간 빠른 것, 작업의 번호가 작은 것
// 반환 시간 계산: 작업 완료된 시간 - 처음 큐에 삽입된 시간