--SET WORKSHEETNAME 'Week_2_HW';
--2.1 SELECT STATEMENTS
SELECT *
FROM CHINOOK.employee;

SELECT *
FROM CHINOOK.employee
WHERE LASTNAME = 'King';

SELECT *
FROM CHINOOK.employee
WHERE FIRSTNAME = 'Andrew'
AND REPORTSTO = null;
--Here we are getting no rows returned, even though the syntax is correct and both conditions are met...
--We'll come back to this later...

--2.2 ORDER BY
SELECT *
FROM CHINOOK.album
ORDER BY TITLE DESC;

SELECT FIRSTNAME
FROM CHINOOK.customer
ORDER BY CITY ASC;

--2.3 INSERT INTO
INSERT INTO CHINOOK.genre
(genreid, name)
VALUES (26, 'J-Pop');

INSERT INTO CHINOOK.genre
(genreid, name)
VALUES (27, 'K-Pop');
--Okay, they are inserted, but not in order.
--I will have to get back to rectify this EGREGIOUS problem later.
--First I just need to make sure I get everything done, even to a mediocre level
--Then I can handle the little, annoying things
INSERT INTO CHINOOK.employee
(employeeid, lastname, firstname, title)
VALUES (9, 'Brown', 'Jane', 'Secretary');
--VALUES (9, 'Bob', 'Jimbo', 'Greeter', 3, 05-DEC-98, 05-DEC-18, '123 BLUEBERRY HILL RD', 'MEMPHIS', 'TN', 'USA', '12345', '1 (234) 567-8910', '1 (234) 567-0198', 'jimbo-bob@yahoo.com');
INSERT INTO CHINOOK.employee
(employeeid, lastname, firstname, title)
VALUES (10, 'White', 'Joe', 'Janitor');
--VALUES (10, 'Bobaganoosh', 'Jimbo', 'Greeter', 4, 06-DEC-98, 06-DEC-18, '321 RASBERRY LANE', 'MEMPHIS', 'TN', 'USA', '12345', '1 (098) 765-4321', '1 (098) 765-1234', 'jimbo-bobaganoosh@aol.com');
INSERT INTO CHINOOK.customer
(customerid, firstname, lastname, email)
VALUES (100, 'Jimbo', 'Bobaganoosh', 'JB@yahoo.com');
INSERT INTO CHINOOK.customer
(customerid, firstname, lastname, email)
VALUES (200, 'Jimmy-John', 'Joe', 'JJ@aol.com');

--2.4
UPDATE CHINOOK.customer
SET FIRSTNAME = 'Robert'
WHERE FIRSTNAME = 'Aaron'
/
UPDATE CHINOOK.customer
SET lastname = 'Walter'
WHERE lastname = 'Mitchell';

--2.5
SELECT *
FROM CHINOOK.invoice
WHERE billingaddress LIKE 'T%';

--2.6
SELECT *
FROM CHINOOK.invoice
WHERE TOTAL BETWEEN 15 AND 50;

--SELECT EMPLOYEEID because I only want the id to show up at the end of the query
SELECT EMPLOYEEID
FROM CHINOOK.employee
WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

--2.7
DELETE
FROM CHINOOK.invoice
WHERE CUSTOMERID = 32;
/
DELETE
FROM CHINOOK.customer
--WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
WHERE CUSTOMERID = 32;
/
DELETE
FROM CHINOOK.INVOICELINE
WHERE INVOICEID = 116;
/
DELETE
FROM CHINOOK.INVOICELINE
WHERE INVOICEID = 245;
/
DELETE
FROM CHINOOK.INVOICELINE
WHERE INVOICEID = 268;
/
DELETE
FROM CHINOOK.INVOICELINE
WHERE INVOICEID = 290;
/
DELETE
FROM CHINOOK.INVOICELINE
WHERE INVOICEID = 342;
/
DELETE
FROM CHINOOK.INVOICELINE
WHERE INVOICEID = 50;
/
DELETE
FROM CHINOOK.INVOICELINE
WHERE INVOICEID = 61;

--3.1


