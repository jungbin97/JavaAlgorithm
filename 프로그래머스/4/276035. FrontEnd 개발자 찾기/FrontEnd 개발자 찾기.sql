select ID, EMAIL, FIRST_NAME, LAST_NAME from DEVELOPERS DEV
where DEV.SKILL_CODE & (
	SELECT sum(CODE)
    FROM SKILLCODES
    WHERE CATEGORY = "Front End"
)
order by ID asc;


-- Front End 스킬을 가진 개발자 정보 조회
-- ID 기준 오름차순 정렬


-- 프론트 스킬 합 구하고 & 연산 처리