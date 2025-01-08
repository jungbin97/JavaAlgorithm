SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO, 'NONE') as TLNO from PATIENT
where age <= 12 and GEND_CD = 'W'
order by AGE desc, PT_NAME asc;


-- 여자환자, 12세이하
-- 전화번호가 없는경우 'NONE'으로 출력
-- 나이기준 내림차순, 환자이름 기준 오름차순