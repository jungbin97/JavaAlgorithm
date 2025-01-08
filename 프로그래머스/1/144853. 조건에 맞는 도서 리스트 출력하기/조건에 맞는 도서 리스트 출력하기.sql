-- 코드를 입력하세요
SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE from BOOK
WHERE YEAR(PUBLISHED_DATE) = '2021' and CATEGORY = '인문'
order by PUBLISHED_DATE asc;


-- 2021년, '인문' 카테고리
-- 출판일기준 오름차순