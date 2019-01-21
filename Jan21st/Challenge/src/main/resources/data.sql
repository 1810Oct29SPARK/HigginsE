INSERT INTO USER_ROLE VALUES (1,'ADMIN');
INSERT INTO USER_ROLE VALUES (2,'MEMBER');

Insert into USER (USER_ID,NAME,PASSWORD,EMAIL,USER_ROLE_ID) values (1,'Dick','Dastardly','StewartBenGardner@Gmail.com',1);
Insert into USER (USER_ID,NAME,PASSWORD,EMAIL,USER_ROLE_ID) values (2,'Mutley','HeHeHe','StewartBenGardner@Gmail.com',1);
Insert into USER (USER_ID,NAME,PASSWORD,EMAIL,USER_ROLE_ID) values (3,'Catch','The Pigeon','StewartBenGardner@Gmail.com',2);
Insert into USER (USER_ID,NAME,PASSWORD,EMAIL,USER_ROLE_ID) values (4,'Wacky','Races','StewartBenGardner@Gmail.com',2);

COMMIT;