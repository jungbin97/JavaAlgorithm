SELECT YEAR(A.DIFFERENTIATION_DATE) AS YEAR, ABS(A.SIZE_OF_COLONY - B.MAX_SIZE) AS YEAR_DEV, A.ID FROM ECOLI_DATA A 
LEFT JOIN (SELECT YEAR(A.DIFFERENTIATION_DATE) AS YEAR, MAX(A.SIZE_OF_COLONY) AS MAX_SIZE FROM ECOLI_DATA A
          GROUP BY YEAR(A.DIFFERENTIATION_DATE)) B
ON YEAR(A.DIFFERENTIATION_DATE) = B.YEAR
ORDER BY YEAR asc, YEAR_DEV asc;


/*
1. 연도별 가장 큰 크기 구하기
2. 1번에서 구한값 결합
3. 연도별 크기 편차 구하기
4. 연도와 크기 편차에 대해 오름차순 정렬
*/