--2.1
--Task – Select all records from the Employee table.
SELECT * 
FROM CHINOOK.EMPLOYEE;

--Task – Select all records from the Employee table where last name is King.
SELECT LASTNAME('KING')
FROM EMPLOYEE;

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * 
FROM CHINOOK.EMPLOYEE 
WHERE FIRSTNAME IN('Andrew') 
AND REPORTSTO 
IS NULL;

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * 
FROM CHINOOK.ALBUM 
ORDER BY TITLE 
DESC;

--Task – Select first name from Customer and sort result set in ascending order by city
SELECT * 
FROM CHINOOK.CUSTOMER 
ORDER BY CITY; 

--2.3
--Task – Insert two new records into Genre table 
INSERT INTO CHINOOK.GENRE(GENREID, NAME) 
VALUES(26,'Hardcore Techno');
INSERT INTO CHINOOK.GENRE(GENREID, NAME) 
VALUES(27, 'Eurobeat');

--Task – Insert two new records into Employee table
INSERT INTO CHINOOK.EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (9, 'Newegg', 'Marsha', 'Chemist', 3, '09-SEPT-1988', '14-AUG-2018', '578 Mullberry Lane', 'Tampa', 'FL', 'America', 'T2P 2T3',14032623443, 14032623456, 'neweggm@chinookcorp.com');
INSERT INTO CHINOOK.EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (10, 'Clinton', 'Hillary', 'Politician', 4, '10-JUN-1976', '14-AUG-2018', '3738 Washington Road', 'DC', 'DC', 'America', 'T2P 2T3',14032623444, 14032623457, 'clintonh@chinookcorp.com');

--Task – Insert two new records into Customer table
INSERT INTO CHINOOK.CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (60, 'Jennings', 'Karen', 'Walmart', '4749 Cherry Cirlce', 'Tampa', 'FL', 'America', 'T2P 2T4',14032623445, 14032623458, 'kjennings@hotmail.com', 3);
INSERT INTO CHINOOK.CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (61, 'Yang', 'Doug', 'Water Bear LLC', '8764 Lemon Road', 'Tampa', 'FL', 'America', 'T2P 2T5',14032623448, 14032623459, 'doug34@gmail.com', 2);

--2.4
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CHINOOK.CUSTOMER 
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”    
UPDATE CHINOOK.ARTIST 
SET NAME = 'CCR' 
WHERE NAME = 'Creedence Clearwater Revival';

--2.5
--Task – Select all invoices with a billing address like “T%”     
SELECT * 
FROM INVOICE 
WHERE BILLINGADDRESS 
LIKE 'T%';

--2.6
--Task – Select all invoices that have a total between 15 and 50
SELECT * 
FROM INVOICE 
WHERE TOTAL 
BETWEEN 15 
AND 50;

--Task – Select all employeesID hired between 1st of June 2003 and 1st of March 2004
SELECT * 
FROM EMPLOYEE 
WHERE HIREDATE 
BETWEEN '01-JUNE-03' 
AND '01-MARCH-04';

--2.7
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
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
/


--3 SQL FUNCTIONS
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
SELECT TO_CHAR
(CURRENT_DATE, 'MM-DD-YYYY HH24:MI:SS')"NOW"
FROM DUAL;

--Task – create a function that return the length of name in MEDIATYPE table
SELECT LENGTH(NAME)FROM MEDIATYPE;

--3.2
--Task – Create a function that returns the average total of all invoices 
SELECT ROUND(AVG(TOTAL),2) FROM INVOICE;

--Task – Create a function that returns the most expensive track
SELECT *
FROM TRACK
WHERE UNITPRICE = (SELECT MAX(UNITPRICE))
FROM TRACK;

--3.3
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
SELECT ROUND(AVG(UNITPRICE),2)
FROM INVOICELINE;

--3.4
--Task – Create a function that returns all employees who are born after 1968.
SELECT FIRSTNAME, LASTNAME
FROM EMPLOYEE
WHERE BIRTHDATE > DATE '1996-12-31';

--4 STORED PROCEDURES
--4.1 
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE PROCEDURE SELECT_NAMES
AS
SELECT FIRSTNAME, LASTNAME
FROM CHINOOK.EMPLOYEE;

--4.2
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_INFO
    @LASTNAME VARCHAR2(50),
    @FIRSTNAME VARCHAR2(50),
    @BIRTHDATE DATE(YYY-MM-DD),
    @ADDRESS VARCHAR2(70),
    @CITY VARCHAR2(50),
    @PHONE VARCHAR2(10),
    @EMAIL VARCHAR2(50),
AS
UPDATE EMPLOYEE.CHINOOK
BEGIN
SET 
    LASTNAME = @LASTNAME,
    FIRSTNAME = @FIRSTNAME,
    BIRTHDATE = @BIRTHDATE,
    ADDRESS = @ADDRESS,
    CITY = @CITY,
    PHONE = @PHONE,
    EMAIL = @EMAIL
END;

--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE EMPLOYEE_MANAGERS (EMPLOYEEID_GET IN NUMBER, REPORTSTO_GET IN STRING)
AS
BEGIN   
    SELECT REPORTSTO_GET = REPORTSTO,
    FROM CHINOOK.EMPLOYEE,
    WHERE EMPLOYEEID_GET = EMPLOYEEID,
END;

--4.3
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE GET_CUSTOMER_INFO
@CUSTOMERFIRSTNAME VARCHAR2(50),
@CUSTOMERLASTNAME VARCHAR2(50),
@COMPANY VARCHAR2(50) OUTPUT,
AS
BEGIN
    SELECT LASTNAME = @CUSTOMERLASTAME, FIRSTNAME = @CUSTOMERFIRSTNAME,
    FROM CUSTOMER.CHINOOK,
    RETURN @COMPANY = COMPANY
END;

--5.0 TRANSACTIONS
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE INVOICE.CHINOOK
DROP CONSTRAINT SYSC_0005407, SYSC_0005408, SYSC_0005409, SYSC_0005410
BEGIN TRANSACTION
@INVOICEID NUMBER(100)
SELECT (@INVOICEID = INVOICEID)
DELETE FROM INVOICE.CHINOOK
WHERE INVOICEID = @INVOICEID
END;

--6 TRIGGERS
--6.1
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER NEW_EMPLOYEE
AFTER 
INSERT
ON EMPLOYEE.CHINOOK
AS
BEGIN
     dbms_output.put_line('NEW EMPLOYEE INSERTED');
END;

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER NEW_ALBUM
AFTER 
UPDATE
ON ALBUM.CHINOOK
WHEN NEW ROW
ON ALBUM.CHINOOK
AS
BEGIN
     dbms_output.put_line('NEW ALBUM');
END;

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER REMOVED_CUSTOMER
AFTER
DELETE
ON CUSTOMER.CHINOOK
AS
BEGIN
    dbms_output.put_line('CUSTOMER DELETED');
END;

--7.0 JOINS
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT INVOICE.INVOICEID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME
FROM INVOICE.CHINOOK
INNER JOIN CUSTOMER
ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID;

--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT INVOICE.INVOICEID, INVOICE.TOTAL, CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME
FROM INVOICE.CHINOOK
OUTER JOIN CUSTOMER.CHINOOK
ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID;

--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT ALBUM.TITLE, ARTIST.NAME
FROM ALBUM.CHINOOK
RIGHT JOIN ARTIST.CHINOOK
ON ALBUM.ARTISTID = ARTIST.ARTISTID;

--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT ALBUM.TITLE, ARTIST.NAME
FROM ALBUM.CHINOOK
CROSS JOIN ARTIST.CHINOOK
ON ALBUM.ARTISTID = ARTIST.ARTISTID
ORDER BY ARTIST.NAME;

--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT FIRSTNAME, LASTNAME, EMPLOYEEID, REPORTSTO
FROM EMPLOYEE.CHINOOK
SELECT
    E.FIRSTNAME, E.LASTNAME, E.REPORTSTO
    M.FIRSTNAME, M.LASTNAME, M.REPORTSTO
FROM EMPLOYEE E
INNER JOIN EMPLOYEE M 
ON M.REPORTSTO = E.REPORTSTO;








