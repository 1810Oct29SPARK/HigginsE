
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

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
--Task – Select all employeesID hired between 1st of June 2003 and 1st of March 2004
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).

DELETE
FROM CUSTOMER 
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

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
--4.2 Stored Procedure Input ParametersA
--Task – Create a stored procedure that updates the personal information of an employee.
--Task – Create a stored procedure that returns the managers of an employee.
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
--
--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
-- 
--
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
--
--7.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.


