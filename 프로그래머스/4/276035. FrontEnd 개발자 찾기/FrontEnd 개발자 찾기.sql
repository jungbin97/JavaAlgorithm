select id, email, first_name, last_name from developers
where skill_code & 
(select sum(code) from skillcodes 
 group by category
 having category = 'Front End'
)
 order by id asc;

-- Front End 스킬을 가진 개발자 정보 조회
-- ID 기준 오름차순 정렬


-- 프론트 스킬 합 구하고 & 연산 처리