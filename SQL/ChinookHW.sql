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
-- Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE SelectEmployees
AS
    FIRST_NAME VARCHAR2(20);
    LAST_NAME VARCHAR2(20);
    CURSOR CURSOR1 IS
    SELECT FIRSTNAME, LASTNAME INTO FIRST_NAME, LAST_NAME FROM EMPLOYEE;
BEGIN
OPEN CURSOR1;

LOOP
   FETCH CURSOR1 INTO FIRST_NAME, LAST_NAME;
   EXIT WHEN CURSOR1%NOTFOUND;
   DBMS_OUTPUT.PUT_LINE(FIRST_NAME || ' ' || LAST_NAME);
END LOOP;
   CLOSE CURSOR1;
END;

EXECUTE SelectEmployees;
SET SERVEROUTPUT ON;   


-- 4.2 STORED PROCEDURE INPUT PARAMETERS
-- Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE(E_ID IN NUMBER)
AS
BEGIN
UPDATE EMPLOYEE SET FIRSTNAME='Alex', LASTNAME='Lora', TITLE='Assistant Manager'
WHERE EMPLOYEE.EMPLOYEEID = E_ID;
END;
BEGIN
UPDATE_EMPLOYEE(6);
END;

-- Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE RETURNS_EMPLOYEE(E_ID IN NUMBER)
AS
BEGIN
UPDATE EMPLOYEE SET FIRSTNAME='Alex', LASTNAME='Lora', TITLE='Assistant Manager'
WHERE EMPLOYEE.EMPLOYEEID = E_ID;
END;
BEGIN
UPDATE_EMPLOYEE(6);
END;


-- 4.3 STORED PROCEDURE OUTPUT PARAMETERS
-- Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE NAME_COMPANY_CUSTOMER(COMPANY_OF_CUSTOMER OUT VARCHAR2, NAME_OF_CUSTOMER OUT VARCHAR2, CUSTOMER_ID IN NUMBER)
IS
COMPANY_NAME VARCHAR2(1000);
CUSTOMER_FIRST VARCHAR2(1000);
CUSTOMER_LAST VARCHAR2(1000);
BEGIN
    SELECT C.FIRSTNAME
    INTO CUSTOMER_FIRST
    FROM CUSTOMER C
    WHERE CUSTOMER_ID = CUSTOMERID;
    SELECT C.COMPANY
    INTO COMPANY_NAME
    FROM CUSTOMER C
    WHERE CUSTOMER_ID = CUSTOMERID;
    SELECT C.LASTNAME
    INTO CUSTOMER_LAST
    FROM CUSTOMER C
    WHERE CUSTOMER_ID = CUSTOMERID;
    NAME_OF_CUSTOMER := CUSTOMER_FIRST + CUSTOMER_LAST;
    COMPANY_OF_CUSTOMER := COMPANY_NAME;
END;



-- 5. TRANSACTIONS
-- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE TRANSACTIONS (GETINVOICEID NUMBER)
AS
BEGIN
DELETE FROM INVOICE WHERE INVOICEID = GETINVOICEID;
COMMIT;
END;



-- 6. TRIGGERS 

-- 6.1 AFTER/FOR
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER TR_INSERT_TRIGGER
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
DECLARE
NUM_COUNT NUMBER;
BEGIN 
    SELECT COUNT(E.FIRSTNAME) INTO NUM_COUNT FROM EMPLOYEE E;
END;

-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER TR_UPDATE_TRIGGER
AFTER UPDATE ON ALBUM
FOR EACH ROW
DECLARE
NUM_COUNT NUMBER;
BEGIN 
    SELECT COUNT(A.ARTISTID) INTO NUM_COUNT FROM ALBUM A;
END;

-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER TR_DELETE_TRIGGER
AFTER DELETE ON ALBUM
FOR EACH ROW
DECLARE
NUM_COUNT NUMBER;
BEGIN 
    SELECT COUNT(C.ARTISTID) INTO NUM_COUNT FROM CUSTOMER C;
END;



-- 7. JOINS

-- 7.1 INNER
-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT C.FIRSTNAME, C.LASTNAME, I.INVOICEID 
FROM CUSTOMER C
INNER JOIN INVOICE I
ON I.CUSTOMERID = C.CUSTOMERID;


-- 7.2 OUTER
-- Task – Create an full join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT C.CUSTOMERID, C.FIRSTNAME, C.LASTNAME, I.TOTAL, I.INVOICEID 
FROM CUSTOMER C
FULL JOIN INVOICE I
ON I.CUSTOMERID = C.CUSTOMERID;


-- 7.3 RIGHT
-- Task – Create a right join that joins album and artist specifying artist name and title.
SELECT A.NAME, AL.TITLE
FROM ARTIST A
RIGHT JOIN ALBUM AL
ON A.ARTISTID = AL.ARTISTID;


-- 7.4 CROSS
-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM ARTIST A
CROSS JOIN ALBUM AL
ORDER BY A.NAME;


-- 7.5 SELF
-- Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT * FROM EMPLOYEE A, EMPLOYEE B
WHERE A.REPORTSTO = B.REPORTSTO;