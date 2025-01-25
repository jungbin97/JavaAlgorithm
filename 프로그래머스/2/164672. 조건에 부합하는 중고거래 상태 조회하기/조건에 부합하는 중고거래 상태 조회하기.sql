select BOARD_ID, WRITER_ID, TITLE, PRICE, 
case 
	when STATUS = "SALE"
    	then '판매중'
	when STATUS = "RESERVED"
    	then '예약중'
	when STATUS = "DONE"
    	then '거래완료'
    end as STATUS
from USED_GOODS_BOARD
WHERE DATE_FORMAT(CREATED_DATE, '%Y-%m-%d') = '2022-10-05'
order by BOARD_ID desc;


-- 2022년 10월 5일에 등록된 중고거래 게시물
-- STATE가 SALE이면 판매중, RESERVED 예약중, DONE 거래완료로 표시
-- 게시글 ID 기준 내림차순