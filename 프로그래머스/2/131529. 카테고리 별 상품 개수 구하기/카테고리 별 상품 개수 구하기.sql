select SUBSTR(product_code,1, 2)as CATEGORY, count(*) as PRODUCTS from product
GROUP BY CATEGORY
order by CATEGORY


-- 상품 카테고리 코드(앞 2자리) 별 상품 개수 출력
-- 상품 카테로기 코드 기준 오름차순 