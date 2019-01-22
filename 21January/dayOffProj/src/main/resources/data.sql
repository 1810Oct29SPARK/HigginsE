INSERT INTO USER_ROLES (ROLE_ID, NAME) VALUES (0, 'NON-MAN');
INSERT INTO USER_ROLES (ROLE_ID, NAME) VALUES (1, 'SUPERVISOR');
INSERT INTO USER_ROLES (ROLE_ID, NAME) VALUES (2, 'DIRECTOR');

Insert into USERS (USER_ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, ROLE_ID ) values (1,'John','Doe', 'jdoe@gmail.com','password', 0);
Insert into USERS (USER_ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, ROLE_ID ) values (2,'Jane','Doe', 'jdoe2@gmail.com','password', 0);
Insert into USERS (USER_ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, ROLE_ID ) values (3,'Alex','Wolfe', 'aWolfe@gmail.com','password', 2);
Insert into USERS (USER_ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, ROLE_ID ) values (4,'Chantell','Wolfe', 'cWolfe@gmail.com','password', 1);

COMMIT; 