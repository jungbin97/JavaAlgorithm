select FOOD_TYPE, REST_ID, REST_NAME, FAVORITES from REST_INFO
WHERE (FOOD_TYPE, FAVORITES) IN (
	SELECT FOOD_TYPE, MAX(FAVORITES)
    from REST_INFO
    GROUP BY FOOD_TYPE
)
order by FOOD_TYPE desc


-- (음식 종류 별로) 즐겨찾기수가 가장 많은 식당
-- 음식 종류 기준 내림차순