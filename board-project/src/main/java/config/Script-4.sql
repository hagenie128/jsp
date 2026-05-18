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
    b.bno, b.title, b.write_date,b.write_update_date,
    b.content,b.bcount, bm.no, bm.nickname, ifnull(bcc.bccount,0) as bccount,
    ifnull(bcl.blike,0) as blike, ifnull(bch.bhate,0) as bhate
from board b left outer join board_member bm on b.mno = bm.no
LEFT outer join board_content_like bcl on bcl.bno = b.bno
LEFT outer join board_content_hate bch on bch.bno = b.bno
left outer join board_comment_count bcc on b.bno = bcc.bno
order by b.bno desc
;

-- 페이징 - 방법1 - MySQL만 가능
--  board_view에서 최근 글 30건만 조회
select * from board_view limit 30;
-- limit 조회할게시글개수 offset (페이지번호-1)*조회할게시글개수
select * from board_view limit 30 offset 30;
select * from board_view limit 30 offset 120;

-- 페이징 - 방법2 - 다른 DB에서도 가능
-- board_view 조회시 row_number 적용
select ROW_NUMBER() OVER(ORDER BY b.bno desc) as rw, b.*
from board_view b;

-- 1페이지 읽기
select * from (select ROW_NUMBER() OVER(ORDER BY b.bno desc) as rw, b.*
from board_view b) bv
where ceil(bv.rw/30) = 1;
-- 2페이지 읽기
select * from (select ROW_NUMBER() OVER(ORDER BY b.bno desc) as rw, b.*
from board_view b) bv
where ceil(bv.rw/30) = 2;

-- board_file
-- fno 파일번호, bno 글번호, fpath 실제 저장된 경로, fname 원본 파일명
create table board_file(
	fno int auto-increment primary key,
	bno int,
	fpath varchar(500),
	fname varchar(255)
);
constraint fk_board_filealter
	foreign key (bno)
	references board(bno)
	on delete cascade;
