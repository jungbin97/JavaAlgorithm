select MCDP_CD as '진료과코드', count(*) as '5월예약건수' from APPOINTMENT
where DATE_FORMAT(APNT_YMD, '%Y-%m') = '2022-05'
group by MCDP_CD
order by 5월예약건수 asc, 진료과코드 asc

 -- 2022년 5월 예약한 환자 수를 진료과 코드별로 조회(GROUP BY, where, count) (컬럼명: 진료과 코드, 5월예약건수)
-- 예약환자 수 기준 오름차순, 진료과 코드 기준 오름차순