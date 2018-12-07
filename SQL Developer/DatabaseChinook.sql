-- 2.
-- 2.1 SELECT
-- Task – Select all records from the Employee table.
SELECT * FROM EMPLOYEE;

-- Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE 
WHERE LASTNAME = 'King';

-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE 
WHERE (FIRSTNAME = 'Andrew') AND (REPORTSTO IS NULL);

-- 2.2 ORDER BY
-- Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM 
ORDER BY(TITLE) DESC;

-- Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME 
FROM CUSTOMER 
ORDER BY(CITY) ASC;

-- 2.3 INSERT INTO
-- Task – Insert two new records into Genre table
INSERT INTO GENRE 
VALUES (26, 'Instrumental Rock');
INSERT INTO GENRE table
INSERT INTO EMPLOYEE
VALUES (9, 'Cunningham','Paul','IT Staff',6,NULL,NULL,'12345 Road St','New York','NY','USA','54321','19194201234','19194200987','paul@chinookcorp.com');
INSERT INTO EMPLOYEE
VALUES (10, 'Cunningham','Michelle','Sales Support Agent',2,NULL,NULL,'12345 Road St','New York','NY','USA','54321','19194201234','19194200987','michelle@chinookcorp.com');

-- Task – Insert two new records into Customer table
INSERT INTO CUSTOMER
VALUES (27, 'KPOP');

-- Task – Insert two new records into Employee 
VALUES(60, 'Jeanne','Yeet',NULL,'45 Lane Ave','Indianapolis','IN','USA','46062','13172345678',NULL,'jeanne@gmail.com',4);
INSERT INTO CUSTOMER
VALUES(61, 'Jon','Yote',NULL,'47 Lane Ave','Indianapolis','IN','USA','46062','13172348765',NULL,'jon@gmail.com',4);

-- 2.4 UPDATE
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CHINOOK.CUSTOMER 
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' 
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE CHINOOK.ARTIST 
SET NAME = 'CCR' 
WHERE NAME = 'Creedence Clearwater Revival';

-- 2.5 LIKE
-- Task – Select all invoices with a billing address like “T%” 
SELECT * FROM INVOICE 
WHERE BILLINGADDRESS LIKE 'T%';

-- 2.6 BETWEEN
-- Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE 
WHERE TOTAL BETWEEN 15 AND 50;

-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE 
WHERE HIREDATE BETWEEN '01-JUNE-03' AND '01-MARCH-04';

-- 2.7 DELETE
-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE CUSTOMER
DROP CONSTRAINT FK_CUSTOMERSUPPORTREPID;
/
ALTER TABLE CUSTOMER
ADD CONSTRAINT FK_CUSTOMERSUPPORTREPID
FOREIGN KEY (SUPPORTREPID) REFERENCES EMPLOYEE(EMPLOYEEID) ON DELETE CASCADE;
/
ALTER TABLE INVOICE
DROP CONSTRAINT FK_INVOICECUSTOMERID;
/
ALTER TABLE INVOICE
ADD CONSTRAINT FK_INVOICECUSTOMERID
FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER(CUSTOMERID) ON DELETE CASCADE;
/
ALTER TABLE INVOICELINE
DROP CONSTRAINT FK_INVOICELINEINVOICEID;
/
ALTER TABLE INVOICELINE
ADD CONSTRAINT FK_INVOICELINEINVOICEID
FOREIGN KEY (INVOICEID) REFERENCES INVOICE(INVOICEID) ON DELETE CASCADE;
/
DELETE
FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
/
-- 3. SQL Functions
-- In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
-- 3.1 System Defined Functions
--Task – Create a function that returns the current time.
SELECT TO_CHAR(CURRENT_DATE, 'MM-DD-YYYY HH24:MI:SS') 
FROM DUAL;

-- Task – create a function that returns	 the length of name in MEDIATYPE table
SELECT LENGTH(NAME) 
FROM MEDIATYPE;

-- 3.2 System Defined Aggregate Functions
-- Task – Create a function that returns the average total of all invoices
SELECT ROUND(AVG(TOTAL),2) 
FROM INVOICE;

--Task – Create a function that returns the most expensive track
SELECT * FROM TRACK 
WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK);

-- 3.3 User Defined Scalar Functions
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
SELECT ROUND(AVG(UNITPRICE),2) 
FROM INVOICELINE;

-- 3.4 User Defined Table Valued Functions
-- Task – Create a function that returns all employees who are born after 1968.
SELECT LASTNAME, FIRSTNAME 
FROM EMPLOYEE
WHERE BIRTHDATE > DATE '1968-12-31';
