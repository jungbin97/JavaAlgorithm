SET @HOUR = -1;
select (@HOUR :=@HOUR + 1) as HOUR, (
    SELECT COUNT(*) FROM ANIMAL_OUTS
    WHERE HOUR(DATETIME) = @HOUR) as count
from ANIMAL_OUTS
where @HOUR < 23;


-- 입 각 시간 대별(0 ~ 23시), 시간대에 아무것도 없으면 0
-- 시간대순 오름차순 정렬