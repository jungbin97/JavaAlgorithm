select id, 
case 
	when SIZE_OF_COLONY <= 100 then 'LOW'
	when SIZE_OF_COLONY > 100 and SIZE_OF_COLONY <= 1000 then 'MEDIUM'
	when SIZE_OF_COLONY > 1000 then 'HIGH'
end as size 
from ECOLI_DATA
order by id




-- 크기 100이하면 LOW, 100초과 1000이하 MEDIUM, 1000 초과 HIGH
-- 개체 ID 기준 오름차순 정렬