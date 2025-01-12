import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르 별 총 재생 횟수 계산
        Map<String, Integer> genrePlayCountMap = new HashMap<>();
        // 장르 별 노래 리스트 관리
        Map<String, List<Music>> genreMusicMap = new HashMap<>();
        
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int playCount = plays[i];
            
            // 장르별 총 재생 횟수 업데이트
            genrePlayCountMap.put(genre, genrePlayCountMap.getOrDefault(genre, 0) + playCount);
            
            // 장르별 노래 리스트 추가
            if (genreMusicMap.get(genre) == null) {
                genreMusicMap.put(genre, new ArrayList<>(List.of(new Music(i, playCount))));
            }else {
                genreMusicMap.get(genre).add(new Music(i, playCount));
            }
        }
        
        // 장르를 재생 횟수 기준으로 정렬(내림차순)
        List<String> sortedgenreKeySet = new ArrayList<>(genrePlayCountMap.keySet());
        sortedgenreKeySet.sort((o1, o2) -> genrePlayCountMap.get(o2).compareTo(genrePlayCountMap.get(o1)));
        
        // 결과 출력
        List<Integer> result = new ArrayList<>();
        for (String genre : sortedgenreKeySet) {
            List<Music> musicList = genreMusicMap.get(genre);
            
            // 노래 정렬: 재생횟수 내림차순, 고유 번호 오름차순
            musicList.sort((a, b) -> b.playCount == a.playCount ? a.index - b.index : b.playCount - a.playCount);
            
            
            // 상위 두 곡 추가(2보다 작으면 전부)
            for (int i = 0; i < Math.min(2, musicList.size()); i++) {
                result.add(musicList.get(i).index);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    
    class Music {
        int index;
        int playCount;
        
        public Music (int index, int playCount) {
            this.index = index;
            this.playCount = playCount;
        } 
    }
}


// 장르 별 집계

// 가장 많이 재생된 장르, 재생된 노래 순서로 2개 선택 (2개 이하면 최대 개수 만큼 선택)
// 그 다음 많이 재생된 장르 선택, 재생된 노래 순서로 2개 선택(2개 이하면 최대 개수 만큼 선택)
// 반복


