select a.id, ifnull(cnt, 0) as CHILD_COUNT from ecoli_data a 
left join (
    select parent_id, count(parent_id) as cnt from ecoli_data
    group by parent_id
) as b
on a.id = b.parent_id


-- 대장균 ID에 해당하는 자식수 구하기
-- id기준 오름차순 정렬


