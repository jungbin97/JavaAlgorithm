Select FLOOR(PRICE/10000) * 10000 as PRICE_GROUP, count(*) from PRODUCT
GROUP BY PRICE_GROUP
order by PRICE_GROUP asc;


-- 만원 단위 가격대 별로 상품 개수 출력
-- 가격대 기준 오름차순 정렬