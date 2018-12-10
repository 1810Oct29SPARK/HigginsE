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
INSERT INTO GENRE(GENREID, NAME) VALUES(26,'Spanish Rock');
INSERT INTO GENRE(GENREID, NAME) VALUES(27, 'Salsa');
-- Task – Insert two new records into Employee table
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (9, 'Wazowski', 'Mike', 'Comedian', 3, '12-DEC-1999', '14-AUG-2018', '123 ABC St.', 'Calgary', 'AB', 'Canada', 'T2P 2T3',14032623443, 14032623456, 'mikew@chinookcorp.com');
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (10, 'Sullivan', 'James', 'Scarer', 4, '12-NOV-1999', '14-AUG-2018', '123 ABC St.', 'Calgary', 'AB', 'Canada', 'T2P 2T3',14032623444, 14032623457, 'jpsullivan@chinookcorp.com');
-- Task – Insert two new records into Customer table
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (60, 'Walt', 'Disney', 'Walt Disney Corp.', '123 Pixar St.', 'Calgary', 'AB', 'Canada', 'T2P 2T4',14032623445, 14032623458, 'waltedisney@disneycorp.com', 3);
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (61, 'Milton', 'Erickson', 'International Psych', '512 Walnut St.', 'Calgary', 'AB', 'Canada', 'T2P 2T5',14032623448, 14032623459, 'milton@erickson.com', 2);
-- 2.4 UPDATE
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER 
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' 
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST 
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

-- 4. Stored Procedures

-- 4.1 Basic Stored Procedures
-- Task - Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE FIRSTNAME_LASTNAME
IS
FL_NAME INTEGER;
BEGIN
SELECT COUNT (E.LASTNAME)
INTO FL_NAME
FROM EMPLOYEE E
WHERE E.EMPLOYEEID =1;
END;

-- 4.2 Stored Procedure Input Parameters
-- Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE(E_ID IN NUMBER)
AS
BEGIN
UPDATE EMPLOYEE SET FIRSTNAME='CARLOS'
WHERE EMPLOYEE.EMPLOYEEID = E_ID;
END;
/
BEGIN
UPDATE_EMPLOYEE(1);
END;
/
-- Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE GET_MANAGER(E_ID IN NUMBER, MANAGER2 OUT VARCHAR2)
IS
MAN_NAME VARCHAR2(30);
BEGIN
SELECT COUNT (E.REPORTSTO)
INTO MAN_NAME
FROM EMPLOYEE E
WHERE E.EMPLOYEEID = E_ID;
MANAGER2 := MAN_NAME;
END;
/
DECLARE
MANAGER2 VARCHAR2(30);
BEGIN
GET_MANAGER(1, MANAGER2);
END;

-- 4.3 Stored Procedure Output Parameters
-- Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE GET_NAME_AND_COMPANY (E_ID IN NUMBER, C_NAME OUT VARCHAR2, C_COMPANY OUT VARCHAR2)
IS
CUST_NAME VARCHAR2(30);
CUST_COMP VARCHAR2(30);
BEGIN
SELECT COUNT (N.REPORTSTO)
INTO CUST_NAME
FROM EMPLOYEE N
WHERE N.EMPLOYEEID = E_ID;
C_NAME := CUST_NAME;
SELECT COUNT (C.REPORTSTO)
INTO CUST_COMP
FROM EMPLOYEE C
WHERE C.EMPLOYEEID = E_ID;
C_COMPANY := CUST_COMP;
END;

-- 5.0 Transactions
-- Task – Create a transaction that given a invoiceId will delete that invoice 
-- (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE DELETE_INVOICE(INVOICE_ID NUMBER)
AS
BEGIN
DELETE
FROM INVOICE
WHERE INVOICEID = INVOICE_ID;
END;

-- 6.0 Triggers
-- 6.1 AFTER/FOR
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER TR_AFTER_EMPLOYEE_INSERT
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
DECLARE
BEGIN
DBMS_OUTPUT.PUT_LINE('EMPLOYEE INSERTED');
END;

-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER TR_AFTER_ALBUM_INSERT
AFTER INSERT ON ALBUM
FOR EACH ROW
DECLARE
BEGIN
DBMS_OUTPUT.PUT_LINE('ALBUM INSERTED');
END;


-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER TR_AFTER_CUSTOMER_DELETE
AFTER INSERT ON CUSTOMER
FOR EACH ROW
DECLARE
BEGIN
DBMS_OUTPUT.PUT_LINE('CUSTOMER DELETED');
END;

-- CREATE TRIGGERS FOR INVOICE AND INVOICELINE TABLES SINCE THEY RELY ON CUSTOMER TABLE
CREATE OR REPLACE TRIGGER TR_INVOICE_DELETE
AFTER DELETE
ON INVOICE
FOR EACH ROW
BEGIN
	INSERT INTO CHANGELOG
	VALUES (SEQ_CHANGELOG_ID.NEXTVAL, 'INVOICE', :OLD.INVOICEID, 'DELETE', CURRENT_TIMESTAMP);
END;
/
CREATE OR REPLACE TRIGGER TR_INVOICELINE_DELETE
AFTER DELETE
ON INVOICELINE
FOR EACH ROW
BEGIN
	INSERT INTO CHANGELOG
	VALUES (SEQ_CHANGELOG_ID.NEXTVAL, 'INVOICELINE', :OLD.INVOICELINEID, 'DELETE', CURRENT_TIMESTAMP);
END;

-- 7.0 JOINS
-- 7.1 INNER
-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT CUSTOMER.FIRSTNAME,CUSTOMER.LASTNAME,INVOICE.INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID;

-- 7.2 OUTER
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME,INVOICE.INVOICEID,INVOICE.TOTAL
FROM CUSTOMER
LEFT OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

-- Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
-- 7.3 RIGHT
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ALBUM
RIGHT JOIN ARTIST ON ALBUM.ARTISTID = ARTIST.ARTISTID;

-- Task – Create a right join that joins album and artist specifying artist name and title.
-- 7.4 CROSS
-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM ARTIST
CROSS JOIN ALBUM
ORDER BY ARTIST.NAME ASC;

-- 7.5 SELF
-- Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT *
FROM EMPLOYEE T1, EMPLOYEE T2
WHERE T1.REPORTSTO = T2.EMPLOYEEID;
