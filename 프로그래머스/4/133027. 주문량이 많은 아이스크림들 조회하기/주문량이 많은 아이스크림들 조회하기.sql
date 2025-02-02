select FLAVOR from (select * from FIRST_HALF UNION ALL select * from JULY) as A
GROUP BY FLAVOR
order by sum(TOTAL_ORDER) desc
limit 3



-- 7월 아이스크림 총 주문량 + 상반기 아이스크림 총 주문량 더한 값이 큰 상위 3개의 맛
