--2.1 SELECT Task – Select all records from the Employee table. 
SELECT * FROM EMPLOYEE;
--Task – Select all records from the Employee table where last name is King. 
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO = NULL;

--2.2 ORDER BY 
--Task – Select all albums in Album table and sort result set in descending order by title. 
SELECT * FROM ALBUM ORDER BY TITLE DESC;
--Task – Select first name from Customer and sort result set in ascending order by city 
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY DESC;





--2.3
--TASK - insert two new recods into Employee
VALUES(60, 'Wally','Billy',NULL,'43 Dork Street','Javaland','CT','USA','45052''13161234567',NULL,'jeanne@gmail.com',4);
INSERT INTO CUSTOMER
VALUE
--2.4
--TASK Delete a record in customer table where the name is Robert Walter (There may be constaraints that rely on this find out
ALTER TABLE CUSTOMER
DROP CONSTRAINT FK_CUSTOMERSUPPORTID;
/
ALTER TABLE CUSTOMER
  ADD CONSTARAINT FK CUSTOMERSUPPORTID
  FOREIGN KEY (SUPPORTID) REFERENCES EMPLOYEE (EMPLOYEEID) ON DELETE CASCADE;
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
  ADD CONSTRAINT FK_INVOICELINEID
  FOREIGN KEY (INVOICEID) REFERENCES INVOICE(INVOICEID) ON DELETE CASCADE;
  /
  DELETE
  FROM CUSTOMER
  WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';


-- In this section you wlll be using the oracle system function, as well as your own functions to perform various actions in your system
-3.1 System defined functions
--Task - Create a function that returns the current time
SELECT TO_CHAR (CURRENT_DATE, 'MM-DD-YYYY HH24:MI:SS')FROM DUAL;
    
--task create a function that returns the length of name in MEDIATYPE table
--SELECT * FROM MEDIATYPE
--SELECT NAME FROM MEDIATYPE
SELECT LENGTH(NAME) FROM MEDIATYPE;

--3.2 System Defined Aggregate Functions
--Task - Create a function that returns the average of all invoices
SELECT ROUND(AVG(TOTAL),2) FROM INVOICE;

--Task - CRETA A FUNCTION THAT RETURNS THE MOST EXPENSIVE TRACK
--SELECT NAME, (MAX(UNITPRICE) FROM TRACK;
SELECT * FROM TRACK WHERE UNITPRICE = (SELECT MAX (UNITPRICE) FROM TRACK);

--3.3 Usr Defined Scalar Functions
-- Task - Create a function tghat returns the average price of invoices intems in the to invoiceline table
SELECT ROUND (AVG(UNITPRICE),2) FROM INVOCIELINE;

-- 3.4 User Defined Table Valued Functions
--TASK - Create a function that returns all mployees who are born agfter 1969
SELECT LASTNAME, FIRSTNAME FROM EMPLOYEE
WHERE BIRTHDATE > DATE '1968-12-31';

--task 4.0 
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure 
--Task – Create a stored procedure that selects the first and last names of all the employees. 
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
--4.2 Stored Procedure Input ParametersA
--Task – Create a stored procedure that updates the personal information of an employee. 
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE(E_ID IN NUMBER)
AS
BEGIN
UPDATE EMPLOYEE SET FIRSTNAME='Nate', LASTNAME='theGreat', TITLE='Boss Monster'
WHERE EMPLOYEE.EMPLOYEEID = E_ID;
END;
BEGIN
UPDATE_EMPLOYEE(6);
END;
--Task – Create a stored procedure that returns the managers of an employee. 
DECLARE
MANAGER2 VARCHAR2(30);
BEGIN
GET_MANAGER(1, MANAGER2);
END;
--4.3 Stored Procedure Output Parameters 
--Task – Create a stored procedure that returns the name and company of a customer. 
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
--5.0 Transactions In this section you will be working with transactions. Transactions are usually nested within a stored procedure. 
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).   
CREATE OR REPLACE PROCEDURE Transactions (GetInvoiceID NUMBER)
AS
BEGIN
DELETE FROM INVOICE WHERE INVOICEID = GetInvoiceID;
COMMIT;
END;
EXECUTE Transactions ();



--6.0 Triggers - In this section you will create various kinds of triggers that work when certain DML statements are executed on a table. 
--6.1 AFTER/FOR Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table. 
CREATE OR REPLACE TRIGGER TR_INSERT_TRIGGER
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
DECLARE
NUM_COUNT NUMBER;
BEGIN 
    SELECT COUNT(E.FIRSTNAME) INTO NUM_COUNT FROM EMPLOYEE E;
END;
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table 
UPDATE TRIGGER TR_INSERT_TRIGGER
AFTER INSERT ON ALBUM
FOR EACH ROW
DECLARE
NUM_COUNT NUMBER;
BEGIN 
    SELECT COUNT(E.FIRSTNAME) INTO NUM_COUNT FROM EMPLOYEE E;
END;
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table. 
DELETE TRIGGER TR_INSERT_TRIGGER
AFTER DELETE ON CUSTOMER
END;
--7.0 JOINS In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins. 
--7.1 INNER Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId. 
SELECT C.FIRSTNAME, I.INVOICEID
FROM CUSTOMER C
INNER JOIN INVOICE I
ON C.CUSTOMERID =  I.CUSTOMERID
--7.2 OUTER Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total. 
SELECT C.FIRSTNAME, C.LASTNAME, C.CUSTOMERID, I.INVOICEID, I.TOTAL
FROM CUSTOMER C
FULL JOIN INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID
--7.3 RIGHT Task – Create a right join that joins album and artist specifying artist name and title.
SELECT ART.NAME, ALB.TITLE
FROM ARTIST ART
RIGHT JOIN ALBUM ALB
ON ART.ARTISTID = ALB.ARTISTID; 
--7.4 CROSS Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT ALB.ALBUM, ART.ARTIST
FROM ARTIST ART
CROSS JOIN ALBUM ALB
ON ART.ARTISTID = ALB.ARTISTID;
/
ORDER BY ARTIST NAME DESC;
--7.5 SELF Task – Perform a self-join on the employee table, joining on the reportsto column. 
SELECT *
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.REPORTSTO = B.REPORTSTO;