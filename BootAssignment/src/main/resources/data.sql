INSERT INTO USER_ROLES VALUES (1, 'Member');
INSERT INTO USER_ROLES VALUES (2, 'Admin');

Insert into USERS (USER_ID, USERNAME, PASSWORD, FIRST_NAME,LAST_NAME,ROLE_ID) values (1,'ATrebek','password', 'Alex','Trebek',1);
Insert into USERS (USER_ID, USERNAME, PASSWORD, FIRST_NAME,LAST_NAME,ROLE_ID) values (2,'CObrien','password', 'Conan','O'Brien',1);
Insert into USERS (USER_ID, USERNAME, PASSWORD, FIRST_NAME,LAST_NAME,ROLE_ID) values (3,'AEinstein','password', 'Albert','Einstein',1);
Insert into USERS (USER_ID, USERNAME, PASSWORD, FIRST_NAME,LAST_NAME,ROLE_ID) values (4,'JMulrenin','password','Jake','Mulrenin',2);
Insert into USERS (USER_ID, USERNAME, PASSWORD, FIRST_NAME,LAST_NAME,ROLE_ID) values (5,'JHarbaugh','password','Jim','Harbaugh',2);
Insert into USERS (USER_ID, USERNAME, PASSWORD, FIRST_NAME,LAST_NAME,ROLE_ID) values (6,'KingJames','password','Lebron','James',2);

COMMIT;