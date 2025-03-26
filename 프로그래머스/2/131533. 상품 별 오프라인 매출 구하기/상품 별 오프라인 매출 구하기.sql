select p.product_code, (p.price*sum(sales_amount)) as sales from product p join offline_sale o
on p.product_id = o.product_id
group by o.product_id
order by sales desc, p.product_code asc



-- 상품 코드별 매출액(판매가*판매량) 출력
-- 매풀액 기준으로 내림차순, 상품코드 기준 오름차순 정렬