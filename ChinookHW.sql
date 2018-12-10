
-- #2.1
SELECT * FROM EMPLOYEE;
/
SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';
/
SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew'
AND REPORTSTO IS NULL;
/

-- #2.2
SELECT * FROM ALBUM 
ORDER BY TITLE DESC;
/
SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY;
/

-- #2.3
--Task – Insert two new records into Genre table 
INSERT ALL
INTO GENRE 
VALUES (26,'Fun')
INTO GENRE
VALUES (27,'Stuff')
SELECT * FROM DUAL;
/
--Task – Insert two new records into Employee table
INSERT ALL
INTO EMPLOYEE
VALUES (9,'Johnson', 'Charles','Cashier',3, DATE '1995-11-11', DATE '2009-04-04', '123 Somewhere Drive', 'Tampa', 'FL', 'Canada','T1H 4K8', '+1 (432) 893-3290', '+1 (432) 932-0393', 'charlesjohnson@chinook.com')
INTO EMPLOYEE
VALUES (10,'Johnsons', 'Mei','Teller',2, DATE '1998-03-20', DATE '2011-01-01', '123 Someplace Drive', 'Orlando', 'FL', 'Canada','T1H 8K8', '+1 (232) 193-3290', '+1 (439) 902-0193', 'meijohnsons@chinook.com')
SELECT * FROM DUAL;
/
--Task – Insert two new records into Customer table
INSERT ALL
INTO CUSTOMER
VALUES (60, 'Alex', 'Stephan', 'Revature', '435 Down the Road', 'Winnie Poo', 'NY', 'Canada', '53132', '+4 (432) 432-1341', '+9 (991) 291-0584', 'alexstephan@chinook.com', 9)
INTO CUSTOMER
VALUES (61, 'Alexis', 'Numberman', 'Reveature', '438 Upthe Road', 'Winnie New', 'NJ', 'Canada', '532132', '+4 (432) 462-2341', '+9 (091) 293-0584', 'alexisnumberman@chinook.com', 10)
SELECT * FROM DUAL;
/
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
/
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	
UPDATE ARTIST SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';
/
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%” 
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';
/
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE 
WHERE TOTAL BETWEEN 15 AND 50;
/
--Task – Select all employeesID hired between 1st of June 2003 and 1st of March 2004
SELECT EMPLOYEEID FROM EMPLOYEE
WHERE HIREDATE BETWEEN DATE '2003-06-01' AND DATE '2004-04-01';
/
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE INVOICE
DROP CONSTRAINT FK_INVOICECUSTOMERID;
/
ALTER TABLE INVOICE
ADD CONSTRAINT FK_INVOICECUSTOMERID_CASCADE
FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER ON DELETE CASCADE;
/
ALTER TABLE INVOICELINE
DROP CONSTRAINT FK_INVOICELINEINVOICEID;
/
ALTER TABLE INVOICELINE
ADD CONSTRAINT FK_INVOICELINEINVOICEID_CSD
FOREIGN KEY (INVOICEID) REFERENCES INVOICE ON DELETE CASCADE;
/
DELETE
FROM CUSTOMER 
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
/
-- #3.1
-- TASK - CREATE A FUNCTION THAT RETURNS THE CURRENT TIME
SELECT TO_CHAR
(CURRENT_DATE, 'MM-DD-YYYY HH24:MI:SS')
FROM DUAL;
/
-- TASK - CREATE A FUNCTION THAT RETURNS THE LENGTH OF THE NAME IN MEDIATYPE TABLE
SELECT LENGTH(NAME) FROM MEDIATYPE;
/
-- #3.2
--Task – Create a function that returns the average total of all invoices 
SELECT ROUND(AVG(TOTAL),2) FROM INVOICE
/
--Task – Create a function that returns the most expensive track
SELECT * FROM TRACK
WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK);
/
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
SELECT ROUND(AVG(UNITPRICE),2) FROM INVOICELINE;
/
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
--¶¶¶¶······
SELECT * FROM EMPLOYEE
WHERE BIRTHDATE > DATE '1968-12-31';
/
--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.

--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE FIRST_LAST_EMPLOYEE
AS
EMPLOYEE_FIRST VARCHAR2(1000);
EMPLOYEE_LAST VARCHAR2(1000);
CURSOR NAME_CURSOR IS
SELECT E.FIRSTNAME, E.LASTNAME FROM EMPLOYEE E;
BEGIN
    OPEN NAME_CURSOR;
    LOOP
    FETCH NAME_CURSOR INTO EMPLOYEE_FIRST, EMPLOYEE_LAST;
    EXIT WHEN NAME_CURSOR % NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(EMPLOYEE_FIRST || ' ' || EMPLOYEE_LAST);
    END LOOP;
    CLOSE NAME_CURSOR;
END;
/
--4.2 Stored Procedure Input ParametersA
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_INFO_EMPLOYEE(FIRST_NAME IN STRING, EMPLOYEE_FIRST IN STRING, EMPLOYEE_LAST IN STRING)
AS
BEGIN
    UPDATE EMPLOYEE SET FIRSTNAME = FIRST_NAME
    WHERE LASTNAME = EMPLOYEE_LAST AND FIRSTNAME = EMPLOYEE_FIRST;
END;
/
--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE MANAGER_OF_EMPLOYEE(EMPLOYEE_ID IN NUMBER, MANAGER_NAME2 OUT VARCHAR2)
IS
MANAGER_ID NUMBER;
MANAGER_FIRST VARCHAR2(100);
BEGIN 
    SELECT E.REPORTSTO
    INTO MANAGER_ID
    FROM EMPLOYEE E
    WHERE REPORTSTO = EMPLOYEE_ID;
    SELECT E.FIRSTNAME
    INTO MANAGER_FIRST
    FROM EMPLOYEE E
    WHERE MANAGER_ID = E.EMPLOYEEID;
    MANAGER_NAME2 := MANAGER_FIRST;
END;
/
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
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
/
--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE INVOICE
DROP CONSTRAINT FK_INVOICECUSTOMERID;
/
ALTER TABLE INVOICE
ADD CONSTRAINT FK_INVOICECUSTOMERID_CASCADE
FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER ON DELETE CASCADE;
/
ALTER TABLE INVOICELINE
DROP CONSTRAINT FK_INVOICELINEINVOICEID;
/
ALTER TABLE INVOICELINE
ADD CONSTRAINT FK_INVOICELINEINVOICEID_CSD
FOREIGN KEY (INVOICEID) REFERENCES INVOICE ON DELETE CASCADE;
/
CREATE OR REPLACE PROCEDURE DELETE_INVOICE(INVOICE_ID IN INT)
IS
BEGIN
    DELETE
    FROM INVOICE
    WHERE INVOICEID = INVOICE_ID;
END;
/
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER INSERT_TRIGGER
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
DECLARE
NUM_COUNT NUMBER;
BEGIN
    SELECT COUNT(E.FIRSTNAME) INTO NUM_COUNT FROM EMPLOYEE E;
END;
/
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER UPDATE_TRIGGER
AFTER UPDATE ON ALBUM
FOR EACH ROW
DECLARE 
NUM_COUNT NUMBER;
BEGIN
    SELECT COUNT(AL.TITLE) INTO NUM_COUNT FROM ALBUM AL;
END;
/
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER DELETE_TRIGGER
AFTER DELETE ON CUSTOMER
FOR EACH ROW
DECLARE 
NUM_COUNT NUMBER;
BEGIN
    SELECT COUNT(C.COMPANY) INTO NUM_COUNT FROM CUSTOMER C;
END;
/
--7.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT FIRSTNAME, LASTNAME, I.INVOICEID
FROM CUSTOMER C
INNER JOIN INVOICE I 
ON I.CUSTOMERID = C.CUSTOMERID;
/
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT C.CUSTOMERID, C.FIRSTNAME, C.LASTNAME, I.INVOICEID, I.TOTAL
FROM CUSTOMER C
FULL JOIN INVOICE I
ON C.CUSTOMERID = I.INVOICEID;
/
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT A.NAME, AL.TITLE
FROM ARTIST A
RIGHT JOIN ALBUM AL
ON A.ARTISTID = AL.ARTISTID
/
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM ARTIST A
CROSS JOIN ALBUM AL
ORDER BY A.NAME
/
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT *
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.REPORTSTO = B.REPORTSTO
/


