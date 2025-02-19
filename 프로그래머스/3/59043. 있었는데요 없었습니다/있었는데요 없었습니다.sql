select AI.ANIMAL_ID, AI.NAME FROM ANIMAL_INS AI JOIN ANIMAL_OUTS AO
ON AI.ANIMAL_ID = AO.ANIMAL_ID
WHERE AI.DATETIME > AO.DATETIME
order by AI.DATETIME asc;




-- 보호 시작일보다 입양일이 더빠른 동물의 아이디, 이름을 조회
-- 보호일이 빠른 순 정렬