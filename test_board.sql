--------------------------------------------------------
--  파일이 생성됨 - 목요일-11월-15-2018   
--------------------------------------------------------
DROP TABLE "TEST_BOARD";
--------------------------------------------------------
--  DDL for Table TEST_BOARD
--------------------------------------------------------

  CREATE TABLE "TEST_BOARD" 
   (	"SEQ" NUMBER(5,0), 
	"TITLE" VARCHAR2(200), 
	"WRITER" VARCHAR2(20), 
	"CONTENT" VARCHAR2(2000), 
	"REGDATE" DATE DEFAULT sysdate, 
	"CNT" NUMBER(5,0) DEFAULT 0
   )
REM INSERTING into TEST_BOARD
SET DEFINE OFF;
Insert into TEST_BOARD (SEQ,TITLE,WRITER,CONTENT,REGDATE,CNT) values (9,'title','writer','test',to_date('18/11/09','RR/MM/DD'),0);
Insert into TEST_BOARD (SEQ,TITLE,WRITER,CONTENT,REGDATE,CNT) values (10,'title','writer','test',to_date('18/11/14','RR/MM/DD'),0);
Insert into TEST_BOARD (SEQ,TITLE,WRITER,CONTENT,REGDATE,CNT) values (11,'title','writer','test',to_date('18/11/15','RR/MM/DD'),0);
Insert into TEST_BOARD (SEQ,TITLE,WRITER,CONTENT,REGDATE,CNT) values (1,'title','writer','test',to_date('18/11/06','RR/MM/DD'),0);
Insert into TEST_BOARD (SEQ,TITLE,WRITER,CONTENT,REGDATE,CNT) values (2,'title','writer','test',to_date('18/11/06','RR/MM/DD'),0);
Insert into TEST_BOARD (SEQ,TITLE,WRITER,CONTENT,REGDATE,CNT) values (3,'title','writer','test',to_date('18/11/06','RR/MM/DD'),0);
Insert into TEST_BOARD (SEQ,TITLE,WRITER,CONTENT,REGDATE,CNT) values (4,'title','writer','test',to_date('18/11/06','RR/MM/DD'),0);
Insert into TEST_BOARD (SEQ,TITLE,WRITER,CONTENT,REGDATE,CNT) values (5,'title','writer','test',to_date('18/11/09','RR/MM/DD'),0);
Insert into TEST_BOARD (SEQ,TITLE,WRITER,CONTENT,REGDATE,CNT) values (6,'title','writer','test',to_date('18/11/09','RR/MM/DD'),0);
Insert into TEST_BOARD (SEQ,TITLE,WRITER,CONTENT,REGDATE,CNT) values (7,'title','writer','test',to_date('18/11/09','RR/MM/DD'),0);
Insert into TEST_BOARD (SEQ,TITLE,WRITER,CONTENT,REGDATE,CNT) values (8,'title','writer','test',to_date('18/11/09','RR/MM/DD'),0);
Insert into TEST_BOARD (SEQ,TITLE,WRITER,CONTENT,REGDATE,CNT) values (12,'title','writer','test',to_date('18/11/15','RR/MM/DD'),0);
Insert into TEST_BOARD (SEQ,TITLE,WRITER,CONTENT,REGDATE,CNT) values (13,'title','writer','test',to_date('18/11/15','RR/MM/DD'),0);
Insert into TEST_BOARD (SEQ,TITLE,WRITER,CONTENT,REGDATE,CNT) values (14,'title','writer','test',to_date('18/11/15','RR/MM/DD'),0);
commit;
--------------------------------------------------------
--  DDL for Index SYS_C007044
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007044" ON "TEST_BOARD" ("SEQ")
--------------------------------------------------------
--  Constraints for Table TEST_BOARD
--------------------------------------------------------

  ALTER TABLE "TEST_BOARD" ADD PRIMARY KEY ("SEQ") ENABLE
