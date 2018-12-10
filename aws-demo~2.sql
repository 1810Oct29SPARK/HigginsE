
--Task – Select all records from the Employee table.
--Task – Select all records from the Employee table where last name is King.
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
--2.1
SELECT * FROM Employee

WHERE LASTNAME ='King';
SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew'
AND REPORTSTO is null;


-- Task – Select all albums in Album table and sort result set in descending order by title.
--Task – Select first name from Customer and sort result set in ascending order by city
--2.2
SELECT * FROM ALBUM

ORDER BY title DESC;

SELECT FIRSTNAME FROM CUSTOMER

ORDER BY CITY DESC;


--Task – Insert two new records into Genre table 
--Task – Insert two new records into Employee table
--Task – Insert two new records into Customer table
-- 2.3

INSERT INTO GENRE(GENREID, NAME) VALUES (26, 'SALSA');
INSERT INTO GENRE(GENREID, NAME) VALUES (27, 'REGGETON');


INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES (9, 'UMANZOR', 'CARLOS');
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES (10, 'John', 'Doe');

INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (60, 'MALIK','BARRYMORE','MBARRY05@GMAIL.COM');
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (61, 'MALIK','BARRYMORE','MBARRY05@GMAIL.COM');


--Task – Update Aaron Mitchell in Customer table to Robert Walter
--2.4
UPDATE CUSTOMER 
SET FIRSTNAME='ROBERT', LASTNAME='WALTER'
WHERE CUSTOMERID =32;

UPDATE ARTIST 
SET NAME='CCR'
WHERE NAME = 'Creedence Clearwater Revival';


--Task – Select all invoices with a billing address like “T%” 	
--2.5
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';


--Task – Select all invoices that have a total between 15 and 50
--Task – Select all employeesID hired between 1st of June 2003 and 1st of March 2004
--2.6
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN '15' AND '50';

SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN TO_DATE('01/06/2003','DD-MM-YYYY') AND TO_DATE('01/3/2004','DD-MM-YYYY');


--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
--2.7
DELETE FROM INVOICELINE WHERE INVOICELINEID=1860;
DELETE FROM INVOICELINE WHERE INVOICEID=342;
DELETE FROM INVOICELINE WHERE INVOICEID=50;
DELETE FROM INVOICELINE WHERE INVOICEID=61;
DELETE FROM INVOICELINE WHERE INVOICEID=116;
DELETE FROM INVOICELINE WHERE INVOICEID=245;
DELETE FROM INVOICELINE WHERE INVOICEID=268;
DELETE FROM INVOICELINE WHERE INVOICEID=290;
DELETE FROM CUSTOMER WHERE CUSTOMERID=32;
DELETE FROM INVOICE WHERE CUSTOMERID=32;



--Task – Create a function that returns the current time.·····
--Task – create a function that return the length of name in MEDIATYPE table
--3.1
select CURRENT_TIMESTAMP
from dual;

SELECT LENGTH('MEDIATYPE') "LENGTH IN CHARACTERS"
   FROM DUAL;



--Task – Create a function that returns the average total of all invoices 
--Task – Create a function that returns the most expensive track
--3.2
SELECT AVG(UNITPRICE) FROM INVOICELINE;
SELECT * FROM TRACK
WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK);
2


--Task – Create a stored procedure that selects the first and last names of all the employees.
4.1
CREATE OR REPLACE PROCEDURE FIRSTNAME_LASTNAME
IS
FL_NAME VARCHAR2(30);
BEGIN 
SELECT COUNT (E.FIRSTNAME)
INTO FL_NAME
FROM EMPLOYEE E
WHERE E.EMPLOYEEID =1;
END;

BEGIN 
FIRSTNAME_LASTNAME;
END;


--Task – Create a stored procedure that updates the personal information of an employee.
--Task – Create a stored procedure that returns the managers of an employee.
--4.2
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE(E_ID IN NUMBER, NEW_NAME IN VARCHAR2(30))
AS
BEGIN
UPDATE EMPLOYEE SET FIRSTNAME= NEW_NAME
WHERE EMPLOYEE.EMPLOYEEID = E_ID;
END;

DECLARE
NEW_NAME := "TOMMY;
BEGIN
UPDATE_EMPLOYEE(2, NEW_NAME);
END;


--Task – Create a stored procedure that returns the name and company of a customer.
--4.3
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

DECLARE
MANAGER2 VARCHAR2(30);
BEGIN 
GET_MANAGER(1, MANAGER2);
END;



SELECT * FROM INVOICE;

CREATE OR REPLACE CUST_NAME_COMP(C_ID IN NUMBER, C_NAME OUT VARCHAR2, C_COMPANY OUT VARCHAR2)
IS
FNAME VARCHAR2(30);

--CNAME VARCHAR2(30);
BEGIN 
SELECT COUNT (C.COMPANY)
INTO CNAME
FROM CUSTOMER C
WHERE C.CUSTOMERID=C_ID;
SELECT COUNT(C.FIRSTNAME) 
INTO FNAME
FROM CUSTOMER C
WHERE C.CUSOTMERID= C_ID;
C_NAME :=FNAME;
C_COMPANY := CNAME;
END;


--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
--7.1
SELECT C.FIRSTNAME, I.INVOICEID
FROM CUSTOMER C
INNER JOIN INVOICE I
ON C.CUSTOMERID =  I.CUSTOMERID

--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
--7.2
SELECT C.FIRSTNAME, C.LASTNAME, C.CUSTOMERID, I.INVOICEID, I.TOTAL
FROM CUSTOMER C
FULL JOIN INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID


--Task – Create a right join that joins album and artist specifying artist name and title.
--7.3
SELECT ART.NAME, ALB.TITLE
FROM ARTIST ART
RIGHT JOIN ALBUM ALB
ON ART.ARTISTID = ALB.ARTISTID;



--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM ARTIST A
CROSS JOIN ALBUM AL
ORDER BY A.NAME

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT *
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.REPORTSTO = B.REPORTSTO
















