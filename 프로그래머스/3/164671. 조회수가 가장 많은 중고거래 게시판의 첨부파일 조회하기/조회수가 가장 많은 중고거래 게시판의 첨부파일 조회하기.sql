select CONCAT("/home/grep/src/", BOARD_ID, "/", FILE_ID, FILE_NAME, FILE_EXT) as FILE_PATH from USED_GOODS_FILE
WHERE BOARD_ID = (
    SELECT BOARD_ID FROM USED_GOODS_BOARD
    order by VIEWS desc LIMIT 1)
order by FILE_ID desc



-- 조회수가 가장 높은 중고거래 게시물의 첨부파일 경로 구하기(/home/grep/src/)
-- 첨부파일 경로는 FILE_ID 기준 내림차순 정렬