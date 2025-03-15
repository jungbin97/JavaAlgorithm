select HE.DEPT_ID, HD.DEPT_NAME_EN, round(avg(SAL)) as AVG_SAL from HR_DEPARTMENT HD 
JOIN HR_EMPLOYEES HE
ON HD.DEPT_ID = HE.DEPT_ID
group by HE.DEPT_ID
order by AVG_SAL desc


-- 부서별 평균 연봉 구하기
-- 평균연봉은 첫째자리에서 반올림
-- 평균 연봉 기준 내림차순 정렬