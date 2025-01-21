SELECT HOUR(DATETIME) as HOUR, COUNT(*) as COUNT FROM ANIMAL_OUTS
GROUP BY HOUR
HAVING HOUR BETWEEN 9 and 19
order by HOUR asc


-- 09:00부터 19:59까지 각 시간대별로 입양 건수 구하기
-- 시간대 순으로 오름차순 정렬