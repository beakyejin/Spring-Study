--------------------------------------------------------
--  파일이 생성됨 - 목요일-11월-15-2018   
--------------------------------------------------------
DROP TABLE "TEST_USERS";
--------------------------------------------------------
--  DDL for Table TEST_USERS
--------------------------------------------------------

  CREATE TABLE "TEST_USERS" 
   (	"ID" VARCHAR2(8), 
	"PASSWOARD" VARCHAR2(8), 
	"NAME" VARCHAR2(20), 
	"ROLE" VARCHAR2(5)
   )
REM INSERTING into TEST_USERS
SET DEFINE OFF;
Insert into TEST_USERS (ID,PASSWOARD,NAME,ROLE) values ('test','test123','관리자','r');
commit;
--------------------------------------------------------
--  DDL for Index SYS_C007045
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007045" ON "TEST_USERS" ("ID")
--------------------------------------------------------
--  Constraints for Table TEST_USERS
--------------------------------------------------------

  ALTER TABLE "TEST_USERS" ADD PRIMARY KEY ("ID") ENABLE
