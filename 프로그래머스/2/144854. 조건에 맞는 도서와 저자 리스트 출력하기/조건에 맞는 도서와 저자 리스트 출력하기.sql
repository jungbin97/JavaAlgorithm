select B.BOOK_ID, A.AUTHOR_NAME, DATE_FORMAT(B.PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE from BOOK B
JOIN AUTHOR A
ON B.AUTHOR_ID = A.AUTHOR_ID
WHERE B.CATEGORY = '경제'
order by B.PUBLISHED_DATE asc


-- '경제' 카테고리 도서 출력
-- 출판일 기준 오름차순 정렬