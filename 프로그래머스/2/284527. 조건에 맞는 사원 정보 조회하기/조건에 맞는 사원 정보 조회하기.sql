SELECT sum(SCORE) as SCORE, HE.EMP_NO, HE.EMP_NAME, HE.POSITION, HE.EMAIL FROM HR_EMPLOYEES as HE
JOIN HR_GRADE as HG
ON HE.EMP_NO = HG.EMP_NO
WHERE HE.EMP_NO = (
    SELECT EMP_NO from HR_GRADE 
    GROUP BY EMP_NO
    ORDER BY sum(SCORE) desc
    LIMIT 1
 	)
GROUP BY HE.EMP_NO






-- 2022년 한해 평가 점수가 가장 높은 사원 정보 조회
-- 평가 점수는 상, 하반기 점수의 합 