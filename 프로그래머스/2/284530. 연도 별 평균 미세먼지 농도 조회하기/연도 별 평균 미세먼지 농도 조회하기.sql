SELECT YEAR(YM) as YEAR, round(avg(PM_VAL1), 2) as PM10, round(avg(PM_VAL2), 2) as 'PM2.5' FROM AIR_POLLUTION
WHERE LOCATION2 = "수원"
GROUP BY YEAR
order by YEAR

-- 수원 지역 연도 별 평균 미세먼지 오염도와 초미세먼지 오염도 조회
-- 오염도는 소수점 셋째 자리에서 반올림
-- 연도 기준 오름차순
