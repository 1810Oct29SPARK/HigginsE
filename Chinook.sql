



-- HOMEWORK
-- 2. SQL QUERIES
-- 2.1 SELECT
-- Task  Select all records from the Employee table.
SELECT * FROM EMPLOYEE;
-- Task  Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE WHERE LASTNAME  = 'King';
-- Task  Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE WHERE FIRSTNAME IN('Andrew') AND REPORTSTO IS NULL;
-- 2.2 ORDER BY
-- Task  Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM ORDER BY TITLE DESC;
-- DESC IS NEEDED TO MAKE AN ORDER BY IN DESCENDING ORDER
-- Task  Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER  ORDER BY CITY ASC;
-- ASC IS OPTIONAL SINCE ORDER BY ALREADY SHOWS THE RESULT IN ASC ORDER
-- 2.3 INSERT INTO
-- Task  Insert two new records into Genre table 
INSERT INTO GENRE(GENREID, NAME)
VALUES(33,'BOBBY');
INSERT INTO GENRE(GENREID, NAME)
VALUES(34,'Leroy');
-- Task  Insert two new records into Employee table
INSERT INTO EMPLOYEE
VALUES(9,'SHROPSHIRE','JEREMY','CEO',NULL,DATE '1989-07-24',DATE '2017-06-24','1212 ACANTHUS ST','PFLUGERVILLE','TX','AFRICA','777 777','+1 (225) 287-5024','+1 (225) 287-5022','SWOP@CHINOOKCORP.COM');
INSERT INTO EMPLOYEE
VALUES(10,'TURNER','TIMMMY','SLAVE',7,DATE '1999-12-24',DATE '2017-06-24','1545 LEMON ST','TEXAS','TX','FRANCE','777 777','+1 (225) 555-5555','+1 (225) 287-5022','TIM@CHINOOKCORP.COM');
-- Task  Insert two new records into Customer table
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (60, 'CHARLES', 'HATFIELD', 'WalMart', '123 Pixar St.', 'Calgary', 'AB', 'Canada', 'T2P 2T4',14032623445, 14032623458, 'wal@mart.com', 3);
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (61, 'Milton', 'Erickson', 'International Psych', '512 Walnut St.', 'Calgary', 'AB', 'Canada', 'T2P 2T5',14032623448, 14032623459, 'milton@erickson.com', 2);
-- 2.4 UPDATE
-- Task  Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
-- Task  Update name of artist in the Artist table Creedence Clearwater Revival to CCR   
UPDATE ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';
-- 2.5 LIKE
-- Task  Select all invoices with a billing address like T% 
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';
-- 2.6 BETWEEN
-- Task  Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
-- Task  Select all employeesID hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUNE-03' AND '01-MARCH-04';
-- 2.7 DELETE
-- Task  Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).

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
-- Task  Create a function that returns the current time.
SELECT TO_CHAR (CURRENT_DATE, 'MM-DD-YYYY HH24:MI:SS') "NOW" FROM DUAL;
-- Task  create a function that return the length of name in MEDIATYPE table   
SELECT LENGTH(NAME) FROM MEDIATYPE;
-- 3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS
-- Task  Create a function that returns the average total of all invoices 
SELECT ROUND(AVG(TOTAL), 2) FROM INVOICE;
-- Task  Create a function that returns the most expensive track
SELECT * FROM TRACK WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK);
-- 3.3 USER DEFINED SCALAR FUNCTIONS
-- Task  Create a function that returns the average price of invoiceline items in the invoiceline table
SELECT ROUND(AVG(UNITPRICE), 2) FROM INVOICELINE;
-- 3.4 USER DEFINED TABLE VALUED FUNCTIONS
-- Task  Create a function that returns all employees who are born after 1968
SELECT LASTNAME, FIRSTNAME FROM EMPLOYEE 
WHERE BIRTHDATE > DATE '1968-12-31';
-- 4. STORED PROCEDURES
--In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
-- 4.1 BASIC STORED PROCEDURE
--Task  Create a stored procedure that selects the first and last names of all the employees.
create or replace PROCEDURE spGetEmployeeName
IS
S SYS_REFCURSOR;
Begin 
OPEN S FOR
SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
-- 4.2 STORED PROCEDURE INPUT 
--Task  Create a stored procedure that updates the personal information of an employee.
--Task  Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE(E_ID IN NUMBER)
AS
BEGIN
UPDATE EMPLOYEE SET FIRSTNAME='Margaret'
WHERE EMPLOYEE.EMPLOYEEID = E_ID;
END;
/
BEGIN
UPDATE_EMPLOYEE(1);
END;
/
--RETURN MANAGERS
CREATE OR REPLACE PROCEDURE MANAGER_GET(E_ID IN NUMBER, MANAGERS OUT VARCHAR2)
IS
NAMES VARCHAR2(30);
BEGIN
SELECT COUNT (E.REPORTSTO)
INTO NAMES
FROM EMPLOYEE E
WHERE E.EMPLOYEEID = E_ID;
MANAGERS := NAMES;
END;
/
DECLARE
MANAGERS VARCHAR2(30);
BEGIN
MANAGER_GET(1, MANAGERS);
END;
-- 4.3 STORED PROCEDURE OUTPUT PARAMETERS
--Task  Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE NAME_AND_COMPANY(CUSTOMER_NAME OUT VARCHAR2, CUSTOMER_COMPANY OUT VARCHAR2, CUSTOMER_ID IN NUMBER)
IS
CUSTOMER_LAST VARCHAR2 (100);
CUSTOMER_FIRST VARCHAR2 (100);
COMPANY_NAME VARCHAR2 (100);
BEGIN
   SELECT J.FIRSTNAME
   INTO CUSTOMER_FIRST
   FROM CUSTOMER J
   WHERE CUSTOMER_ID = CUSTOMERID;
   SELECT J.LASTNAME
   INTO CUSTOMER_LAST
   FROM CUSTOMER J
   WHERE CUSTOMER_ID = CUSTOMERID;
   SELECT J.COMPANY
   INTO CUSTOMER_COMPANY
   FROM CUSTOMER J
   WHERE CUSTOMER_ID = CUSTOMERID;
   CUSTOMER_NAME := CUSTOMER_FIRST + CUSTOMER_LAST;
   CUSTOMER_COMPANY := COMPANY_NAME;
END;
-- 5. TRANSACTIONS
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task  Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
 --4.1
CREATE OR REPLACE PROCEDURE FIRST_LAST
IS
FIRST_LAST_NAME INTEGER;
BEGIN
SELECT COUNT (E.LASTNAME)
INTO FIRST_LAST_NAME
FROM EMPLOYEE E
WHERE E.EMPLOYEEID =1;
END;

--4.2
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE(E_ID IN NUMBER)
AS
BEGIN
UPDATE EMPLOYEE SET FIRSTNAME='Margaret'
WHERE EMPLOYEE.EMPLOYEEID = E_ID;
END;
/
BEGIN
UPDATE_EMPLOYEE(1);
END;
/
--RETURN MANAGERS
CREATE OR REPLACE PROCEDURE MANAGER_GET(E_ID IN NUMBER, MANAGERS OUT VARCHAR2)
IS
NAMES VARCHAR2(30);
BEGIN
SELECT COUNT (E.REPORTSTO)
INTO NAMES
FROM EMPLOYEE E
WHERE E.EMPLOYEEID = E_ID;
MANAGERS := NAMES;
END;
/
DECLARE
MANAGERS VARCHAR2(30);
BEGIN
MANAGER_GET(1, MANAGERS);
END;

--4.3
CREATE OR REPLACE PROCEDURE NAME_AND_COMPANY(CUSTOMER_NAME OUT VARCHAR2, CUSTOMER_COMPANY OUT VARCHAR2, CUSTOMER_ID IN NUMBER)
IS
CUSTOMER_LAST VARCHAR2 (50);
CUSTOMER_FIRST VARCHAR2 (50);
COMPANY_NAME VARCHAR2 (50);
BEGIN
   SELECT C.FIRSTNAME
   INTO CUSTOMER_FIRST
   FROM CUSTOMER C
   WHERE CUSTOMER_ID = CUSTOMERID;
   SELECT C.LASTNAME
   INTO CUSTOMER_LAST
   FROM CUSTOMER C
   WHERE CUSTOMER_ID = CUSTOMERID;
   SELECT C.COMPANY
   INTO CUSTOMER_COMPANY
   FROM CUSTOMER C
   WHERE CUSTOMER_ID = CUSTOMERID;
   CUSTOMER_NAME := CUSTOMER_FIRST + CUSTOMER_LAST;
   CUSTOMER_COMPANY := COMPANY_NAME;
END;


--5.0
CREATE OR REPLACE PROCEDURE DELETE_TRANSACTION (GIVENID NUMBER)
AS
BEGIN
   DELETE FROM INVOICE WHERE INVOICEID = GIVENID;
   COMMIT;
END;

-- 6. TRIGGERS 
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
-- 6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
--Task  Create an after update trigger on the album table that fires after a row is inserted in the table
--Task  Create an after delete trigger on the customer table that fires after a row is deleted from the table
INSERT INTO EMPLOYEE VALUES (11, 'Last Name', 'First Name', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

CREATE OR REPLACE TRIGGER TR_INSERT_EMPLOYEE
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
   DBMS_OUTPUT.PUT_LINE('INSERT TRIGGER WORKED FINE');
END;

INSERT INTO ALBUM VALUES (100000, NULL, NULL);
CREATE OR REPLACE TRIGGER TR_AFTER_ALBUM
AFTER INSERT ON ALBUM
FOR EACH ROW
BEGIN
   DBMS_OUTOUT.PUT_LINE('ALBUM INSERT TRIGGER WORKED FINE');
END;

CREATE OR REPLACE TRIGGER TR_DELETE_CUSTOMER
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
   DBMS_OUTPUT.PUT_LINE('CUSTOMER DELETE TRIGGER WORKED');
END;
-- 7. JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
-- 7.1 INNER
--Task  Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
-- 7.2 OUTER
--Task  Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER
FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
-- 7.3 RIGHT
--Task  Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ALBUM
RIGHT OUTER JOIN ARTIST ON ALBUM.ARTISTID = ARTIST.ARTISTID;
-- 7.4 CROSS
--Task  Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM ALBUM
CROSS JOIN ARTIST
ORDER BY ARTIST.NAME;
-- 7.5 SELF
--Task  Perform a self-join on the employee table, joining on the reportsto column.
SELECT *
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.REPORTSTO = B.REPORTSTO;

