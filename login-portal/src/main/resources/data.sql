INSERT INTO USER_ROLE VALUES (1, 'ADMIN');
INSERT INTO USER_ROLE VALUES (2, 'MEMBER');

Insert into USER (USER_ID,USERNAME,PASSWORD,EMAIL,USER_ROLE_ID) values (1,'Michael','Scott','michaelscott@email.com',1);
Insert into USER (USER_ID,USERNAME,PASSWORD,EMAIL,USER_ROLE_ID) values (2,'Jane','Doe','janedoe@email.com',1);
Insert into USER (USER_ID,USERNAME,PASSWORD,EMAIL,USER_ROLE_ID) values (3,'Jim','Halpert','jimhalpert@email.com',2);
Insert into USER (USER_ID,USERNAME,PASSWORD,EMAIL,USER_ROLE_ID) values (4,'John','Johnson','johnjohnson@email.com',2);

COMMIT;