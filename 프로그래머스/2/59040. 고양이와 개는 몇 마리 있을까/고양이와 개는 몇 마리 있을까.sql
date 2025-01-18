-- 코드를 입력하세요
SELECT ANIMAL_TYPE, count(*) as count from ANIMAL_INS
WHERE ANIMAL_TYPE IN ('Cat', 'Dog')
GROUP BY ANIMAL_TYPE
order by ANIMAL_TYPE



-- 고양이, 개가 각각 몇마리인지 조회
-- 고양이, 개순서 정렬