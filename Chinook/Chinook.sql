



-- HOMEWORK
-- 2. SQL QUERIES
-- 2.1 SELECT
-- Task – Select all records from the Employee table.
SELECT * FROM EMPLOYEE;
-- Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE WHERE LASTNAME  = 'King';
-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE WHERE FIRSTNAME IN('Andrew') AND REPORTSTO IS NULL;
-- 2.2 ORDER BY
-- Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM ORDER BY TITLE DESC;
-- DESC IS NEEDED TO MAKE AN ORDER BY IN DESCENDING ORDER
-- Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER  ORDER BY CITY ASC;
-- ASC IS OPTIONAL SINCE ORDER BY ALREADY SHOWS THE RESULT IN ASC ORDER
-- 2.3 INSERT INTO
-- Task – Insert two new records into Genre table 
INSERT INTO GENRE(GENREID, NAME)
VALUES(33,'BOBBY');
INSERT INTO GENRE(GENREID, NAME)
VALUES(34,'Leroy');
-- Task – Insert two new records into Employee table
INSERT INTO EMPLOYEE
VALUES(9,'SHROPSHIRE','JEREMY','CEO',NULL,DATE '1989-07-24',DATE '2017-06-24','1212 ACANTHUS ST','PFLUGERVILLE','TX','AFRICA','777 777','+1 (225) 287-5024','+1 (225) 287-5022','SWOP@CHINOOKCORP.COM');
INSERT INTO EMPLOYEE
VALUES(10,'TURNER','TIMMMY','SLAVE',7,DATE '1999-12-24',DATE '2017-06-24','1545 LEMON ST','TEXAS','TX','FRANCE','777 777','+1 (225) 555-5555','+1 (225) 287-5022','TIM@CHINOOKCORP.COM');
-- Task – Insert two new records into Customer table
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (60, 'CHARLES', 'HATFIELD', 'WalMart', '123 Pixar St.', 'Calgary', 'AB', 'Canada', 'T2P 2T4',14032623445, 14032623458, 'wal@mart.com', 3);
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (61, 'Milton', 'Erickson', 'International Psych', '512 Walnut St.', 'Calgary', 'AB', 'Canada', 'T2P 2T5',14032623448, 14032623459, 'milton@erickson.com', 2);
-- 2.4 UPDATE
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”   
UPDATE ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';
-- 2.5 LIKE
-- Task – Select all invoices with a billing address like “T%” 
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';
-- 2.6 BETWEEN
-- Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
-- Task – Select all employeesID hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUNE-03' AND '01-MARCH-04';
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
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
/
-- 3. SQL Functions
-- 3.1 SYSTEM DEFINED FUNCTIONS
-- Task – Create a function that returns the current time.
SELECT TO_CHAR (CURRENT_DATE, 'MM-DD-YYYY HH24:MI:SS') "NOW" FROM DUAL;
-- Task – create a function that return the length of name in MEDIATYPE table   
SELECT LENGTH(NAME) FROM MEDIATYPE;
-- 3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS
-- Task – Create a function that returns the average total of all invoices 
SELECT ROUND(AVG(TOTAL), 2) FROM INVOICE;
-- Task – Create a function that returns the most expensive track
SELECT * FROM TRACK WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK);
-- 3.3 USER DEFINED SCALAR FUNCTIONS
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
SELECT ROUND(AVG(UNITPRICE), 2) FROM INVOICELINE;
-- 3.4 USER DEFINED TABLE VALUED FUNCTIONS
-- Task – Create a function that returns all employees who are born after 1968
SELECT LASTNAME, FIRSTNAME FROM EMPLOYEE 
WHERE BIRTHDATE > DATE '1968-12-31';
-- 4. STORED PROCEDURES
-- 4.1 BASIC STORED PROCEDURE
-- 4.2 STORED PROCEDURE INPUT PARAMETERS
-- 4.3 STORED PROCEDURE OUTPUT PARAMETERS
-- 5. TRANSACTIONS
-- 6. TRIGGERS 
-- 6.1 AFTER/FOR
-- 7. JOINS
-- 7.1 INNER
-- 7.2 OUTER
-- 7.3 RIGHT
-- 7.4 CROSS
-- 7.5 SELF
-- HOMEWORK
-- 2. SQL QUERIES
-- 2.1 SELECT
-- Task – Select all records from the Employee table.
SELECT * FROM CHINOOK.EMPLOYEE;
-- Task – Select all records from the Employee table where last name is King.
SELECT * FROM CHINOOK.EMPLOYEE WHERE LASTNAME IN('King');
-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM CHINOOK.EMPLOYEE WHERE FIRSTNAME IN('Andrew') AND REPORTSTO IS NULL;
-- 2.2 ORDER BY
-- Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM CHINOOK.ALBUM ORDER BY TITLE DESC;
-- DESC IS NEEDED TO MAKE AN ORDER BY IN DESCENDING ORDER
-- Task – Select first name from Customer and sort result set in ascending order by city
SELECT * FROM CHINOOK.CUSTOMER ORDER BY CITY; 
-- ASC IS OPTIONAL SINCE ORDER BY ALREADY SHOWS THE RESULT IN ASC ORDER
-- 2.3 INSERT INTO
-- Task – Insert two new records into Genre table 
INSERT INTO CHINOOK.GENRE(GENREID, NAME) VALUES(26,'Spanish Rock');
INSERT INTO CHINOOK.GENRE(GENREID, NAME) VALUES(27, 'Salsa');
-- Task – Insert two new records into Employee table
INSERT INTO CHINOOK.EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (9, 'Wazowski', 'Mike', 'Comedian', 3, '12-DEC-1999', '14-AUG-2018', '123 ABC St.', 'Calgary', 'AB', 'Canada', 'T2P 2T3',14032623443, 14032623456, 'mikew@chinookcorp.com');
INSERT INTO CHINOOK.EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (10, 'Sullivan', 'James', 'Scarer', 4, '12-NOV-1999', '14-AUG-2018', '123 ABC St.', 'Calgary', 'AB', 'Canada', 'T2P 2T3',14032623444, 14032623457, 'jpsullivan@chinookcorp.com');
-- Task – Insert two new records into Customer table
INSERT INTO CHINOOK.CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (60, 'Walt', 'Disney', 'Walt Disney Corp.', '123 Pixar St.', 'Calgary', 'AB', 'Canada', 'T2P 2T4',14032623445, 14032623458, 'waltedisney@disneycorp.com', 3);
INSERT INTO CHINOOK.CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (61, 'Milton', 'Erickson', 'International Psych', '512 Walnut St.', 'Calgary', 'AB', 'Canada', 'T2P 2T5',14032623448, 14032623459, 'milton@erickson.com', 2);
-- 2.4 UPDATE
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CHINOOK.CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”   
UPDATE CHINOOK.ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';
-- 2.5 LIKE
-- Task – Select all invoices with a billing address like “T%” 
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';
-- 2.6 BETWEEN
-- Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
-- Task – Select all employeesID hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUNE-03' AND '01-MARCH-04';
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
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
/
-- 3. SQL Functions
-- 3.1 SYSTEM DEFINED FUNCTIONS
-- Task – Create a function that returns the current time.
SELECT TO_CHAR (CURRENT_DATE, 'MM-DD-YYYY HH24:MI:SS') "TIME_NOW" FROM DUAL;
-- Task – create a function that return the length of name in MEDIATYPE table   
SELECT LENGTH(NAME) FROM MEDIATYPE;
-- 3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS
-- Task – Create a function that returns the average total of all invoices 
SELECT ROUND(AVG(TOTAL), 2) FROM INVOICE;
-- Task – Create a function that returns the most expensive track
SELECT * FROM TRACK WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK);
-- 3.3 USER DEFINED SCALAR FUNCTIONS
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
SELECT ROUND(AVG(UNITPRICE), 2) FROM INVOICELINE;
-- 3.4 USER DEFINED TABLE VALUED FUNCTIONS
-- Task – Create a function that returns all employees who are born after 1968
SELECT LASTNAME, FIRSTNAME FROM EMPLOYEE 
WHERE BIRTHDATE > DATE '1968-12-31';