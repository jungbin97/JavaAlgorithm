SELECT MP.MEMBER_NAME, RR.REVIEW_TEXT, DATE_FORMAT(RR.REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE FROM REST_REVIEW as RR LEFT JOIN MEMBER_PROFILE as MP
ON RR.MEMBER_ID = MP.MEMBER_ID
WHERE RR.MEMBER_ID = (
    SELECT MEMBER_ID FROM REST_REVIEW
    GROUP BY MEMBER_ID
    order by count(MEMBER_ID) desc
    LIMIT 1
)
order by REVIEW_DATE, RR.REVIEW_TEXT



-- 리뷰를 가장 많이 작성한 회원의 리뷰 조회
-- 회원 이름, 리뷰 텍스트, 리뷰 작성일
-- 리뷰 작성일 기준 오름차순, 리뷰 텍스트 기준 오름차순 정렬