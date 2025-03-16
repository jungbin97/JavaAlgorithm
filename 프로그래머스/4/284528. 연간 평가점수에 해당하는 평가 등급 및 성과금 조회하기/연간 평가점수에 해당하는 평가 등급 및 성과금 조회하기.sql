select HE.emp_no, HE.emp_name, 
(case
 	when avg(HG.score) >= 96 then 'S'
 	when avg(HG.score) >= 90 then 'A'
 	when avg(HG.score) >= 80 then 'B'
 	else 'C' end
) as GRADE,
(case 
	when avg(HG.score) >= 96 then HE.SAL*0.2
	when avg(HG.score) >= 90 then HE.SAL*0.15
	when avg(HG.score) >= 80 then HE.SAL*0.10
 	else 0 end
) as BONUS
from HR_EMPLOYEES HE JOIN HR_GRADE HG
ON HE.emp_no = HG.emp_no
group by HE.emp_no
order by HE.emp_no asc;


-- 사원별 성과금 정보 출력(등급에 딸느 성과급)
-- 사번 기준 오름차순 정렬