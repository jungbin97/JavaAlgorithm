SELECT CAR_TYPE, count(*) as CARS FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%시트%'
GROUP BY CAR_TYPE
order BY CAR_TYPE asc


-- 통풍시트, 열선시트, 가죽시트 중 하나 이상 옵션이 있는 CAR_TYPE 별로 몇대인지(컬럼 : CARS)
--  자동차 종류 기준 오름차순 정렬