INSERT INTO USER_ROLES (name) VALUES ('User');
INSERT INTO USER_ROLES (name) VALUES ('Admin');

INSERT INTO USERS(username, email, password, role_id) VALUES('jsmith', 'jsmith@gmail.com', 'hello', 1);
INSERT INTO USERS(username, email, password, role_id) VALUES('admin', 'admin@gmail.com', 'admin', 2);