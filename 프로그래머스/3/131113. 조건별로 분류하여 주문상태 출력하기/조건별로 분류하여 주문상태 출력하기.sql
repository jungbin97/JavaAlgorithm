select order_id, product_id, DATE_FORMAT(out_date, '%Y-%m-%d') as OUT_DATE,
case 
	when OUT_DATE <= '2022-05-01'
    	then '출고완료'
    when OUT_DATE is null
    	then '출고미정'
	else '출고대기'	
	end as 출고여부
from FOOD_ORDER
order by order_id asc


-- 주문 ID기준 오름차순 정렬