SELECT round(avg(IF(LENGTH is null, 10, LENGTH)), 2) as AVERAGE_LENGTH FROM FISH_INFO
-- 조건문, 집계함수