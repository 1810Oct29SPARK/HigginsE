INSERT INTO USER_ROLES VALUES (1, 'Member');
INSERT INTO USER_ROLES VALUES (2, 'Admin');

Insert into USERS (USER_ID, USERNAME, PASSWORD, FIRST_NAME,LAST_NAME,ROLE_ID) values (1,'BHawk','password', 'Black','Hawk',1);
Insert into USERS (USER_ID, USERNAME, PASSWORD, FIRST_NAME,LAST_NAME,ROLE_ID) values (2,'SBull','password', 'Sitting','Bull',1);
Insert into USERS (USER_ID, USERNAME, PASSWORD, FIRST_NAME,LAST_NAME,ROLE_ID) values (3,'JThorpe','password', 'Jim','Thorpe',1);
Insert into USERS (USER_ID, USERNAME, PASSWORD, FIRST_NAME,LAST_NAME,ROLE_ID) values (4,'SShoshone','password','Sacajawea','Shoshone',2);
Insert into USERS (USER_ID, USERNAME, PASSWORD, FIRST_NAME,LAST_NAME,ROLE_ID) values (5,'CHorse','password','Crazy','Horse',2);
Insert into USERS (USER_ID, USERNAME, PASSWORD, FIRST_NAME,LAST_NAME,ROLE_ID) values (6,'GApache','password','Geronimo','Apache',2);
COMMIT;