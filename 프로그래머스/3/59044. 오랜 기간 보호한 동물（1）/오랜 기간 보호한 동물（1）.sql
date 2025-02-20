SELECT AI.NAME, AI.DATETIME FROM ANIMAL_INS AI LEFT JOIN ANIMAL_OUTS AO
ON AI.ANIMAL_ID = AO.ANIMAL_ID
WHERE AO.DATETIME is null
order by AI.DATETIME asc
LIMIT 3






-- 아직 입양을 못간 동물 중, 가장 오래 보호소에 있던 동물 3마리
-- 이름, 보호시작일
-- 보호 시작일 기준 정렬(오름차순)