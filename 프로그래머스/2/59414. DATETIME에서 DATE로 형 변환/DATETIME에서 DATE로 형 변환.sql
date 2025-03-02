select animal_id, name, DATE_FORMAT(datetime, "%Y-%m-%d") as 날짜 from ANIMAL_INS A
order by animal_id



-- 날짜를 시간 잘러서
-- 아이디순 오름차순 정렬