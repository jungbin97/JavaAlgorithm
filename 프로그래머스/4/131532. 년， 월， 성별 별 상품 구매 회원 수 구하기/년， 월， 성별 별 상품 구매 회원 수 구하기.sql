SELECT YEAR(ONLINE_SALE.SALES_DATE) as YEAR, MONTH(ONLINE_SALE.SALES_DATE) as MONTH, USER_INFO.GENDER as GENDER, count(distinct USER_INFO.USER_ID) as USERS
FROM USER_INFO RIGHT JOIN ONLINE_SALE
ON USER_INFO.USER_ID = ONLINE_SALE.USER_ID
WHERE USER_INFO.GENDER is not null
group by YEAR, MONTH, GENDER
order by YEAR, MONTH, GENDER





-- 년, 월, 성별 별로 상품을 구매한 회원 수 집계
-- 성별 정보가 없는 경우 결과에서 제외
-- 년, 월 성별 기준으로 오름차순 정렬