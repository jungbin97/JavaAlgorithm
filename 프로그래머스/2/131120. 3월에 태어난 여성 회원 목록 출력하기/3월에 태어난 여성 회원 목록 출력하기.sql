select MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') as DATE_OF_BIRTH from MEMBER_PROFILE
where MONTH(DATE_OF_BIRTH) = '3' and GENDER = 'W' and TLNO is not null

-- 생일 3월, 여성, 전화번호 NULL인 경우 제외
-- 회원 ID 기준으로 오름차순 정렬