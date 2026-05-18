-- WITH 절을 이용한 전체 게시글 조회 : MYSQL 8.0 이상에서 지원
with board_content_like as 
(select bl.bno, count(*) as blike from board_like bl group by bl.bno),
board_content_hate as 
(select bh.bno, count(*) as bhate from board_hate bh group by bh.bno),
board_comment_count as 
(select bc.bno, count(*) as bccount from board_comment bc group by bc.bno)
SELECT
    b.bno, b.title, b.write_date,
    b.content,b.bcount, bm.no, bm.nickname, ifnull(bcc.bccount,0) as bccount,
    ifnull(bcl.blike,0) as blike, ifnull(bch.bhate,0) as bhate
from board b left outer join board_member bm on b.mno = bm.no
LEFT outer join board_content_like bcl on bcl.bno = b.bno
LEFT outer join board_content_hate bch on bch.bno = b.bno
left outer join board_comment_count bcc on b.bno = bcc.bno;
;

CREATE OR REPLACE VIEW board_view
as
with board_content_like as 
(select bl.bno, count(*) as blike from board_like bl group by bl.bno),
board_content_hate as 
(select bh.bno, count(*) as bhate from board_hate bh group by bh.bno),
board_comment_count as 
(select bc.bno, count(*) as bccount from board_comment bc group by bc.bno)
SELECT
    b.bno, b.title, b.write_date,b.write_update_date as write_update,
    b.content,b.bcount, bm.no, bm.nickname, ifnull(bcc.bccount,0) as bccount,
    ifnull(bcl.blike,0) as blike, ifnull(bch.bhate,0) as bhate
from board b left outer join board_member bm on b.mno = bm.no
LEFT outer join board_content_like bcl on bcl.bno = b.bno
LEFT outer join board_content_hate bch on bch.bno = b.bno
left outer join board_comment_count bcc on b.bno = bcc.bno
order by b.bno desc
;