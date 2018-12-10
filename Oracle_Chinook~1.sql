--2.1 Select records from employee table
SELECT * FROM EMPLOYEE;

--2.1 Select records from employee table where last name is King
SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';

--2.1 Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

--2.2 Select albums and sort in descending order
SELECT * FROM ALBUM
ORDER BY TITLE DESC;

--2.2 Select first name from Customer and sort result set in ascending order by city
SELECT * FROM CUSTOMER
ORDER BY CITY ASC;

--2.3 Insert two new records into Genre table 
INSERT INTO GENRE SET VALUES(26, 'Ska');
INSERT INTO GENRE SET VALUES(27, 'Elevator Music');

--2.3 Insert two new records into Employee table
INSERT INTO EMPLOYEE SET VALUES(9,'Hunting', 'Will', 'Janitor', NULL,TO_DATE('1987-08-18 00:00:00','yyyy-mm-dd hh24:mi:ss'),TO_DATE('1997-08-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), '1234 Yellowbrick Road', 'Boston', 'MA', 'USA', 'T2P 2T6', '303-333-3333', '303-222-2222', 'whunting@gmail.com');
INSERT INTO EMPLOYEE SET VALUES(10,'Kumar', 'Varsha', 'CEO', NULL,TO_DATE('1996-07-11 00:00:00','yyyy-mm-dd hh24:mi:ss'),TO_DATE('2018-12-05 00:00:00','yyyy-mm-dd hh24:mi:ss'), '3333 Saratoga Pl', 'Denver', 'CO', 'USA', 'T2P 2T9', '303-808-3333', '303-808-2222', 'vkumar@gmail.com');

--2.3 Insert two new records into Customer table
INSERT INTO CUSTOMER SET VALUES (60,'Matt', 'Damon',NULL,'1234 Hollywood Street','Los Angeles','CA','USA','44444','815-348-3429',NULL,'mdamon@gmail.com',3)
INSERT INTO CUSTOMER SET VALUES (61,'Leo', 'DiCaprio',NULL,'5678 Hollywood Street','Los Angeles','CA','USA','44444','815-348-3420',NULL,'ldicaprio@gmail.com',4)

--2.4 Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER SET FIRSTNAME  = 'Robert' WHERE FIRSTNAME = 'Aaron';
UPDATE CUSTOMER SET LASTNAME  = 'Walter' WHERE LASTNAME = 'Mitchell';

--2.4 Update Creedene Clearwater Revival to CCR
UPDATE ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';

--2.5 Select all invoices with a billing address like “T%” 	
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

--2.6 Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;

--2.6 Select all employeesID hired between 1st of June 2003 and 1st of March 2004
SELECT EMPLOYEEID FROM EMPLOYEE WHERE HIREDATE BETWEEN TO_DATE('2003-06-01 00:00:00','yyyy-mm-dd hh24:mi:ss') AND TO_DATE('2004-03-01 00:00:00','yyyy-mm-dd hh24:mi:ss');

--2.7 Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE CUSTOMER 
DROP CONSTRAINT FK_CUSTOMERSUPPORTREPID;

ALTER TABLE CUSTOMER
ADD CONSTRAINT FK_CUSTOMERSUPPORTREPID
FOREIGN KEY (SUPPORTREPID) REFERENCES EMPLOYEE(EMPLOYEEID) ON DELETE CASCADE;

ALTER TABLE INVOICE
DROP CONSTRAINT FK_INVOICECUSTOMERID;

ALTER TABLE INVOICE
ADD CONSTRAINT FK_INVOICECUSTOMERID
FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER(CUSTOMERID) ON DELETE CASCADE;
    
ALTER TABLE INVOICELINE
DROP CONSTRAINT FK_INVOICELINEINVOICEID;

ALTER TABLE INVOICELINE
ADD CONSTRAINT FK_INVOICELINEINVOICEID
FOREIGN KEY (INVOICEID) REFERENCES INVOICE(INVOICEID) ON DELETE CASCADE;

DELETE 
FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';


--3.1 Create a function that returns the current time.
SELECT TO_CHAR 
    (CURRENT_DATE, 'MM-DD-YYYY HH24:MI:SS')
    FROM DUAL;
    
    
--3.1 Create a function that return the length of name in MEDIATYPE table
SELECT LENGTH(NAME) FROM MEDIATYPE;

--3.2  Create a function that returns the average total of all invoices
SELECT ROUND(AVG(TOTAL),2) FROM INVOICE;

--3.2  Create a function that returns the most expensive track
SELECT * FROM TRACK WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK);

--3.3 Create a function that returns the average price of invoiceline items in the invoiceline table
SELECT ROUND(AVG(UNITPRICE), 2) FROM INVOICELINE;

--3.4 Create a function that returns all employees who are born after 1968.
SELECT * FROM EMPLOYEE;
SELECT LASTNAME, FIRSTNAME FROM EMPLOYEE WHERE BIRTHDATE > DATE '1968-12-31';

--4.1 Create a stored procedure that selects the first and last names of all the employees
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
SET SERVEROUTPUT ON;
EXECUTE SelectEmployees;


--4.2 Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UpdateInfo (p_EmployeeId INT, p_FirstName VARCHAR2 DEFAULT NULL, p_LastName VARCHAR2 DEFAULT NULL, p_Title VARCHAR2 DEFAULT NULL, p_ReportsTo NUMBER DEFAULT NULL, p_Birthdate DATE DEFAULT NULL,
p_Hiredate DATE DEFAULT NULL, p_Address VARCHAR2 DEFAULT NULL, p_City VARCHAR2 DEFAULT NULL, 
p_Country VARCHAR2 DEFAULT NULL, p_PostalCode VARCHAR2 DEFAULT NULL, p_Phone VARCHAR2 DEFAULT NULL, p_Fax VARCHAR2 DEFAULT NULL,
p_Email VARCHAR2 DEFAULT NULL)
AS
BEGIN
UPDATE EMPLOYEE 
SET FIRSTNAME = NVL(p_FirstName, FIRSTNAME), LASTNAME = NVL(p_LastName, LASTNAME), TITLE = NVL(p_Title, TITLE),
REPORTSTO = NVL(p_ReportsTo, REPORTSTO), BIRTHDATE = NVL(p_Birthdate, BIRTHDATE), HIREDATE = NVL(p_Hiredate, HIREDATE),
ADDRESS = NVL(p_Address, ADDRESS), CITY = NVL(p_City, CITY), COUNTRY = NVL(p_Country, COUNTRY), POSTALCODE = NVL(p_PostalCode, POSTALCODE),
PHONE = NVL(p_Phone, PHONE), FAX = NVL(p_Fax, FAX), EMAIL = NVL(p_Email, EMAIL)
WHERE EMPLOYEEID = p_EmployeeId;
COMMIT;
END;



--4.2 Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE ReturnManager 
(FIRST_NAME IN EMPLOYEE.FIRSTNAME%TYPE, LAST_NAME IN EMPLOYEE.LASTNAME%TYPE)
AS 
MANAGER_NAME VARCHAR2(45);
BEGIN
    SELECT E1.FIRSTNAME || ' ' || E1.LASTNAME INTO MANAGER_NAME FROM EMPLOYEE E1, EMPLOYEE E2 
    WHERE E2.FIRSTNAME = FIRST_NAME AND E2.LASTNAME = LAST_NAME AND (E2.REPORTSTO = E1.EMPLOYEEID AND E2.REPORTSTO IS NOT NULL);
    DBMS_OUTPUT.PUT_LINE(MANAGER_NAME);
END;
EXECUTE ReturnManager('Laura', 'Callahan');

--4.3 Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE NameCompany (p_CustomerId IN NUMBER)
AS
p_Name VARCHAR2(50);
p_Company VARCHAR2(60);
BEGIN
SELECT FIRSTNAME || ' ' || LASTNAME, COMPANY INTO p_Name, p_Company FROM CUSTOMER WHERE CUSTOMERID = p_CustomerId;
DBMS_OUTPUT.PUT_LINE(p_Name || ' ' || p_Company);
END;
EXECUTE NameCompany(10);

--5.0 Create a transaction that given a invoiceId will delete that invoice.
CREATE OR REPLACE PROCEDURE DeleteInvoice (p_InvoiceId IN NUMBER)
AS
BEGIN
DELETE FROM INVOICE WHERE INVOICEID = p_InvoiceId;
COMMIT;
END;
EXECUTE DeleteInvoice();

--6.1 Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER Insert_Trigger
AFTER 
INSERT ON EMPLOYEE
FOR EACH ROW
DECLARE NUMBER_COUNT NUMBER;
BEGIN 
    SELECT COUNT(EMPLOYEE.FIRSTNAME) INTO NUMBER_COUNT FROM EMPLOYEE;
END;

--6.1 Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER Update_Trigger
AFTER 
UPDATE ON ALBUM
FOR EACH ROW
DECLARE NUMBER_COUNT NUMBER;
BEGIN 
    SELECT COUNT(ALBUM.ALBUMID) INTO NUMBER_COUNT FROM ALBUM;
END;

--6.1 Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER Delete_Trigger
AFTER 
DELETE ON CUSTOMER
FOR EACH ROW
DECLARE NUMBER_COUNT NUMBER
BEGIN 
    SELECT COUNT(CUSTOMER.FIRSTNAME) INTO NUMBER_COUNT FROM CUSTOMER;
END;

--7.1 Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT FIRSTNAME, LASTNAME, INVOICEID FROM CUSTOMER, INVOICE
WHERE CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.2 Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT C.CUSTOMERID, C.FIRSTNAME, C.LASTNAME, I.INVOICEID, I.TOTAL FROM CUSTOMER C
FULL JOIN INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID;


--7.3 Create a right join that joins album and artist specifying artist name and title.
SELECT ALBUM.TITLE, ARTIST.NAME 
FROM ALBUM
RIGHT JOIN ARTIST ON ALBUM.ARTISTID = ARTIST.ARTISTID;

--7.4 Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT ARTIST.NAME
FROM ALBUM 
CROSS JOIN ARTIST
ORDER BY ARTIST.NAME ASC;

--7.5 Perform a self-join on the employee table, joining on the reportsto column.
SELECT E1.LASTNAME, E1.FIRSTNAME, E2.LASTNAME, E2.FIRSTNAME
FROM EMPLOYEE E1, EMPLOYEE E2
WHERE E1.REPORTSTO = E2.EMPLOYEEID;