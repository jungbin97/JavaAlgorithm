SELECT P.PRODUCT_CODE, (P.PRICE*sum(OS.SALES_AMOUNT)) as SALES FROM PRODUCT P JOIN OFFLINE_SALE OS
ON P.PRODUCT_ID = OS.PRODUCT_ID
GROUP BY P.PRODUCT_ID
order by SALES desc, P.PRODUCT_CODE asc




-- 상품 코드별 매출액(판매가*판매량) 출력
-- 매풀액 기준으로 내림차순, 상품코드 기준 오름차순 정렬