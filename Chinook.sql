--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT *
FROM EMPLOYEE;

--Task – Select all records from the Employee table where last name is King.
SELECT *
FROM EMPLOYEE
WHERE LASTNAME = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *
FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' 
AND REPORTSTO IS NULL;

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT *
FROM ALBUM
ORDER BY TITLE DESC;

--Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME
FROM CUSTOMER
ORDER BY CITY ASC;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table 
INSERT ALL
INTO GENRE
VALUES (26, 'Harsh Noise')
INTO GENRE
VALUES (27, 'IDM')
SELECT * FROM DUAL;

--Task – Insert two new records into Employee table
INSERT ALL
INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME)
VALUES (9, 'John','Jimmy')
INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME)
VALUES (10, 'Swanson','Ron')
SELECT * FROM DUAL;

--Task – Insert two new records into Customer table
INSERT ALL
INTO CUSTOMER (CUSTOMERID, LASTNAME, FIRSTNAME, EMAIL)
VALUES (60, 'Smith', 'Shawn','BLAH@gmail.com')
INTO CUSTOMER (CUSTOMERID, LASTNAME, FIRSTNAME, EMAIL)
VALUES (61, 'Jones', 'Jim','SSS@gmail.com')
SELECT * FROM DUAL;

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%” 
SELECT *
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT *
FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

--Task – Select all employeesID hired between 1st of June 2003 and 1st of March 2004
SELECT EMPLOYEEID
FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MARCH-04';

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
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

--3.1 System Defined Functions
--Task – Create a function that returns the current time.·····
SELECT TO_CHAR
(CURRENT_DATE, 'MM-DD-YYYY HH24:MI:SS')
FROM DUAL;

--Task – create a function that return the length of name in MEDIATYPE table
SELECT LENGTH(NAME)
FROM MEDIATYPE;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices 
SELECT ROUND(AVG(TOTAL),2)
FROM INVOICE;

--Task – Create a function that returns the most expensive track
SELECT *
FROM TRACK
WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK);

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
SELECT ROUND(AVG(UNITPRICE),2)
FROM INVOICELINE;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
SELECT * FROM EMPLOYEE
WHERE BIRTHDATE > DATE '1968-12-31';


--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE FIRSTNAME_LASTNAME
IS
S SYS_REFCURSOR;
BEGIN
    OPEN S FOR
    SELECT FIRSTNAME, LASTNAME
    FROM EMPLOYEE;
END;  

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_INFO(E_ID IN NUMBER, E_LNAME IN VARCHAR2, E_FNAME IN VARCHAR2, E_CITY IN VARCHAR2, E_STATE IN VARCHAR2)
IS
BEGIN
    UPDATE EMPLOYEE
    SET
        LASTNAME = E_LNAME,
        FIRSTNAME = E_FNAME,
        CITY = E_CITY,
        STATE = E_STATE
        WHERE EMPLOYEEID = E_ID;
END;

--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE GET_MANAGER(E_ID IN NUMBER, MANAGERNAME OUT VARCHAR2)
IS
BOSS_NAME VARCHAR2(100);
BEGIN
    SELECT REPORTSTO
    INTO BOSS_NAME
    FROM EMPLOYEE
    WHERE EMPLOYEEID = E_ID;
    MANAGERNAME := BOSS_NAME;
END;

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE NAME_COMPANY (C_ID IN NUMBER, C_FNAME OUT VARCHAR2, C_LNAME OUT VARCHAR2, C_COMPANY OUT VARCHAR2)
IS
CUST_FNAME VARCHAR2(100);
CUST_LNAME VARCHAR2(100);
CUST_COMPANY VARCHAR2(100);
BEGIN
    SELECT FIRSTNAME
    INTO CUST_FNAME
    FROM CUSTOMER
    WHERE CUSTOMERID = C_ID;
    C_FNAME := CUST_FNAME;
    
    SELECT LASTNAME
    INTO CUST_LNAME
    FROM CUSTOMER
    WHERE CUSTOMERID = C_ID;
    C_LNAME := CUST_LNAME;
    
    SELECT COMPANY
    INTO CUST_COMPANY
    FROM CUSTOMER
    WHERE COMPANY = C_ID;
    C_COMPANY := CUST_COMPANY;
END;

--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them). 
CREATE OR REPLACE PROCEDURE DELETE_INVOICE(I_ID IN NUMBER)
IS
BEGIN
    DELETE
    FROM INVOICE
    WHERE INVOICEID = I_ID;
    COMMIT;
END;

--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER INSERT_ON_EMPLOYEE
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
COMMIT;
END;

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER AFTER_UPDATE_ALBUM
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
COMMIT;
END;

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER AFTER_DELETE_CUSTOMER
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
COMMIT;
END;

--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID =  INVOICE.CUSTOMERID;

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER
FULL OUTER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST
RIGHT JOIN ALBUM
ON ARTIST.ARTISTID = ALBUM.ARTISTID;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * 
FROM ARTIST 
CROSS JOIN ALBUM
ORDER BY ARTIST.NAME;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT E.FIRSTNAME||' reports to '||F.FIRSTNAME
FROM EMPLOYEE E, EMPLOYEE F
WHERE E.REPORTSTO = F.EMPLOYEEID;







