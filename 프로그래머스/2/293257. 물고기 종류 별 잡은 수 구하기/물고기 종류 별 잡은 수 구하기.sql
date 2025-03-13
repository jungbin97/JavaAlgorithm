select count(*) as FISH_COUNT, FNI.fish_name from fish_info FI
join fish_name_info FNI
on FI.fish_type = FNI.fish_type
GROUP BY FNI.fish_name
order by FISH_COUNT desc;





-- 물고기 종류 별, 물고기의 이름과 잡은 수 출력
-- 잡은 수 기준 내림차순 정렬