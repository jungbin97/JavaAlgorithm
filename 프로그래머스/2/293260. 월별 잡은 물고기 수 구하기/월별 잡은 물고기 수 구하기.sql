select count(*) as FISH_COUNT, month(time) as MONTH from FISH_INFO
GROUP BY MONTH
order by MONTH asc;

-- 월별 잡은 물고기 수 출력하기
-- 월을 기준으로 오름차순 정렬