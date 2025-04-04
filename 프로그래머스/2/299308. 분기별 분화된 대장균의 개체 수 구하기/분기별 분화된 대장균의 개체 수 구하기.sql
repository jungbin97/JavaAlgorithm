SELECT CASE 
	WHEN MONTH(DIFFERENTIATION_DATE) IN (1, 2, 3) then '1Q'
    WHEN MONTH(DIFFERENTIATION_DATE) IN (4, 5, 6) then '2Q'
    WHEN MONTH(DIFFERENTIATION_DATE) IN (7, 8, 9) then '3Q'
    WHEN MONTH(DIFFERENTIATION_DATE) IN (10, 11, 12) then '4Q'
END as QUARTER, count(*) as ECOLI_COUNT
FROM ECOLI_DATA
GROUP BY QUARTER
order by QUARTER


-- 1, 2, 3
-- 4, 5, 6
-- 7, 8, 9
-- 10, 11, 12