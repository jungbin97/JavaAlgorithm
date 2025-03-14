select route, 
concat(round(sum(D_BETWEEN_DIST), 1), 'km') as TOTAL_DISTANCE, 
concat(round(avg(D_BETWEEN_DIST), 2), 'km') as AVERAGE_DISTANCE
from SUBWAY_DISTANCE
group by route 
order by round(sum(D_BETWEEN_DIST), 1) desc






-- 노선별로 총누계거리, 평균 역사이 거리 거리 구하기
-- 총누계거리 기준 내림차순 정렬