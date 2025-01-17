-- 코드를 입력하세요
SELECT USER_ID, NICKNAME, sum(PRICE) as TOTAL_SALES from USED_GOODS_BOARD as UGB
left join USED_GOODS_USER as UGU
on UGB.WRITER_ID = UGU.USER_ID
WHERE UGB.STATUS = 'DONE'
GROUP BY UGB.WRITER_ID
HAVING SUM(PRICE) >= 700000
order by TOTAL_SALES asc;




-- 완료된 중고 거래 총금액 70만원 이상인 사람 출력
-- 총거래금액 기준 오름차순