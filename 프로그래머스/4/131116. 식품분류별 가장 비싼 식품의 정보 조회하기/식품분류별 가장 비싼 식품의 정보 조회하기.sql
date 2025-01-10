-- 코드를 입력하세요
SELECT FP.CATEGORY, FP.PRICE as MAX_PRICE, FP.PRODUCT_NAME 
FROM FOOD_PRODUCT FP
JOIN (
    SELECT CATEGORY, MAX(PRICE) as MAX_PRICE FROM FOOD_PRODUCT
	GROUP BY CATEGORY
	HAVING CATEGORY IN ('과자', '국', '김치', '식용유')
    ) as MP
    ON FP.CATEGORY = MP.CATEGORY and FP.PRICE = MP.MAX_PRICE
ORDER BY MAX_PRICE desc


-- 식품분류별 가격이 제일 비싼 식품의 분류, 가격, 이름 
-- 식품 분류가 "과자" "국" "식용유" 인것만 출력
-- 식품 가격 기준 내림차순