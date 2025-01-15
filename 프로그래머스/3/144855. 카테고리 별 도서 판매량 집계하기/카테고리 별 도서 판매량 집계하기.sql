select BOOK.CATEGORY, sum(BOOK_SALES.SALES) as TOTAL_SALES from BOOK
join BOOK_SALES on BOOK.BOOK_ID = BOOK_SALES.BOOK_ID
where DATE_FORMAT(BOOK_SALES.SALES_DATE, '%Y-%m') = '2022-01'
group by BOOK.CATEGORY
order by BOOK.CATEGORY asc



-- 2022년 1월 카테고리 별 도서 판매량 (컬럼 : 카테고리, 총 판매량)
-- 카테고리 기준 오름차순