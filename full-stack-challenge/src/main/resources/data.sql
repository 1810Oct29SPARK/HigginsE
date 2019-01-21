INSERT INTO USER_ROLE VALUES (1, 0);
INSERT INTO USER_ROLE VALUES (2, 0);
INSERT INTO USER_ROLE VALUES (3, 0);
INSERT INTO USER_ROLE VALUES (4, 1);
INSERT INTO USER_ROLE VALUES (5, 1);
INSERT INTO USER_ROLE VALUES (6, 1);

Insert into USER (USER_ID, LOGIN, PASS, USER_ROLE_ID) values (1, ebanks, password1, 1);
Insert into USER (USER_ID, LOGIN, PASS, USER_ROLE_ID) values (2, jsmith, password1, 2);
Insert into USER (USER_ID, LOGIN, PASS, USER_ROLE_ID) values (3, jdoe, password1, 3);
Insert into USER (USER_ID, LOGIN, PASS, USER_ROLE_ID) values (4, mjones, password1, 4);
Insert into USER (USER_ID, LOGIN, PASS, USER_ROLE_ID) values (5, djohn, password1, 5);
Insert into USER (USER_ID, LOGIN, PASS, USER_ROLE_ID) values (6, kschultz, password1, 6);


COMMIT;