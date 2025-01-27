select count(*) as FISH_COUNT, MAX(LENGTH) as MAX_LENGTH, FISH_TYPE from FISH_INFO
GROUP BY FISH_TYPE
HAVING avg(IFNULL(LENGTH, 10)) >= 33
order by FISH_TYPE asc;


-- 평균 길이가 33이상인 물고기 종류별로 분류하여 잡은 수, 최대 길이
-- 10cm 이하 물고기는 10cm로 취급하여 평균구하기
-- 물고기 종류에 대해 오름차순 정렬