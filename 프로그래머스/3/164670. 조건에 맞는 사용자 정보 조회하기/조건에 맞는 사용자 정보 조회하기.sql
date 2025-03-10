select UGU.user_id, UGU.nickname, concat(UGU.city, ' ', UGU.street_address1, ' ', UGU.street_address2) as 전체주소, 
concat(substring(TLNO, 1, 3), '-', substring(TLNO, 4, 4), '-', substring(TLNO, 8, 4)) as 전화번호 
from USED_GOODS_USER UGU
JOIN USED_GOODS_BOARD UGB
ON UGU.user_id = UGB.writer_id
GROUP BY UGB.writer_id 
having count(*) >= 3
order by UGU.user_id desc;



-- 중고 거래 게시물을 3건 이상 등록한 사용자 조회
-- 회원 ID 기준 내림차순