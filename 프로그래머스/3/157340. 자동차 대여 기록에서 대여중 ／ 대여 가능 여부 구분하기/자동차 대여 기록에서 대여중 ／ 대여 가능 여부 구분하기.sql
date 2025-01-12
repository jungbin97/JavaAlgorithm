SELECT CAR_ID, CASE  WHEN CAR_ID IN (
    SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS A
    WHERE "2022-10-16" BETWEEN DATE_FORMAT(START_DATE, "%Y-%m-%d") AND DATE_FORMAT(END_DATE, "%Y-%m-%d")
                          ) THEN "대여중" 
                          ELSE "대여 가능"
                          END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS A
GROUP BY CAR_ID
ORDER BY CAR_ID desc


-- 2022년 10월 16일에 대여 중인 자동차 '대여중' 표시, 아닌 자동자 '대여 가능 표시' (컬럼명 : AVAILABILITY)
-- 반납일자가 2022년 10월 16일도 대여중임
-- 자동차 ID 기준 내림차순