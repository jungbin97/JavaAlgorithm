SELECT C.CAR_ID FROM CAR_RENTAL_COMPANY_CAR C join CAR_RENTAL_COMPANY_RENTAL_HISTORY H
ON C.CAR_ID = H.CAR_ID
where C.CAR_TYPE = "세단" and MONTH(H.START_DATE) = 10
GROUP BY C.CAR_ID
ORDER BY C.CAR_ID desc





-- 자동차 종류가 '세단'인 자동차 중 10월에 대여를 시작한 기록 출력, 중복없어야함.
-- 자동차 ID 기준 내림차순 정렬