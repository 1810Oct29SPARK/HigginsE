INSERT INTO ROLES (ROLE)
VALUES ('Admin');
INSERT INTO ROLES (ROLE)
VALUES ('Member');

INSERT INTO USERS (FIRSTNAME, LASTNAME, EMAIL, ROLE_ID, USERNAME, PASSWORD)
VALUES ('John', 'Mulaney', 'john@mail.com', 1, 'john', 'mulaney');
INSERT INTO USERS (FIRSTNAME, LASTNAME, EMAIL, ROLE_ID, USERNAME, PASSWORD)
VALUES ('Fred', 'Cams', 'fred@mail.com', 2, 'fred', 'cams');
INSERT INTO USERS (FIRSTNAME, LASTNAME, EMAIL, ROLE_ID, USERNAME, PASSWORD)
VALUES ('Susan', 'Hills', 'susan@mail.com', 2, 'susan', 'hills');
INSERT INTO USERS (FIRSTNAME, LASTNAME, EMAIL, ROLE_ID, USERNAME, PASSWORD)
VALUES ('Esteban', 'Perez', 'esteban@mail.com', 2, 'esteban', 'perez');
INSERT INTO USERS (FIRSTNAME, LASTNAME, EMAIL, ROLE_ID, USERNAME, PASSWORD)
VALUES ('Jonny', 'Salinas', 'jonny@mail.com', 1, 'jonny', 'salinas');

COMMIT;