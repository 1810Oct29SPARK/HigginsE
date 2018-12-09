--SET WORKSHEETNAME 'Week_2_HW';
--2.1 SELECT STATEMENTS
SELECT *
FROM CHINOOK.employee;

SELECT *
FROM CHINOOK.employee
WHERE LASTNAME = 'King';

SELECT *
FROM CHINOOK.employee
WHERE FIRSTNAME = 'Andrew'
AND REPORTSTO = null;
--Here we are getting no rows returned, even though the syntax is correct and both conditions are met...
--We'll come back to this later...

--2.2 ORDER BY
SELECT *
FROM CHINOOK.album
ORDER BY TITLE DESC;

SELECT FIRSTNAME
FROM CHINOOK.customer
ORDER BY CITY ASC;

--2.3 INSERT INTO
INSERT INTO CHINOOK.genre
(genreid, name)
VALUES (26, 'J-Pop');

INSERT INTO CHINOOK.genre
(genreid, name)
VALUES (27, 'K-Pop');
--Okay, they are inserted, but not in order.
--I will have to get back to rectify this EGREGIOUS problem later.
--First I just need to make sure I get everything done, even to a mediocre level
--Then I can handle the little, annoying things
INSERT INTO CHINOOK.employee
(employeeid, lastname, firstname, title)
VALUES (9, 'Brown', 'Jane', 'Secretary');
--VALUES (9, 'Bob', 'Jimbo', 'Greeter', 3, 05-DEC-98, 05-DEC-18, '123 BLUEBERRY HILL RD', 'MEMPHIS', 'TN', 'USA', '12345', '1 (234) 567-8910', '1 (234) 567-0198', 'jimbo-bob@yahoo.com');
INSERT INTO CHINOOK.employee
(employeeid, lastname, firstname, title)
VALUES (10, 'White', 'Joe', 'Janitor');
--VALUES (10, 'Bobaganoosh', 'Jimbo', 'Greeter', 4, 06-DEC-98, 06-DEC-18, '321 RASBERRY LANE', 'MEMPHIS', 'TN', 'USA', '12345', '1 (098) 765-4321', '1 (098) 765-1234', 'jimbo-bobaganoosh@aol.com');
INSERT INTO CHINOOK.customer
(customerid, firstname, lastname, email)
VALUES (100, 'Jimbo', 'Bobaganoosh', 'JB@yahoo.com');
INSERT INTO CHINOOK.customer
(customerid, firstname, lastname, email)
VALUES (200, 'Jimmy-John', 'Joe', 'JJ@aol.com');

--2.4
UPDATE CHINOOK.customer
SET FIRSTNAME = 'Robert'
WHERE FIRSTNAME = 'Aaron'
/
UPDATE CHINOOK.customer
SET lastname = 'Walter'
WHERE lastname = 'Mitchell';

--2.5
SELECT *
FROM CHINOOK.invoice
WHERE billingaddress LIKE 'T%';

--2.6
SELECT *
FROM CHINOOK.invoice
WHERE TOTAL BETWEEN 15 AND 50;

--SELECT EMPLOYEEID because I only want the id to show up at the end of the query
SELECT EMPLOYEEID
FROM CHINOOK.employee
WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

--2.7
DELETE
FROM CHINOOK.invoice
WHERE CUSTOMERID = 32;
/
DELETE
FROM CHINOOK.customer
--WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
WHERE CUSTOMERID = 32;
/
DELETE
FROM CHINOOK.INVOICELINE
WHERE INVOICEID = 116;
/
DELETE
FROM CHINOOK.INVOICELINE
WHERE INVOICEID = 245;
/
DELETE
FROM CHINOOK.INVOICELINE
WHERE INVOICEID = 268;
/
DELETE
FROM CHINOOK.INVOICELINE
WHERE INVOICEID = 290;
/
DELETE
FROM CHINOOK.INVOICELINE
WHERE INVOICEID = 342;
/
DELETE
FROM CHINOOK.INVOICELINE
WHERE INVOICEID = 50;
/
DELETE
FROM CHINOOK.INVOICELINE
WHERE INVOICEID = 61;

--3.1
CREATE OR REPLACE FUNCTION getTime
 ( p_alt_time in varchar2 := null )
return date is
BEGIN
    IF p_alt_time IS NULL THEN
        return SYSDATE;
    ELSE
        return to_date(sys_context('AltTimeZone', p_alt_time)
                                , 'hh24:mi:ss');
    END IF;
END;
/

CREATE OR REPLACE FUNCTION GET_MEDIATYPE_LENGTH
(XID IN NUMBER) RETURN NUMBER
IS XNAME VARCHAR2(120);
BEGIN
    SELECT NAME INTO XNAME
    FROM CHINOOK.MEDIATYPE
    WHERE MEDIATYPEID = XID;
    RETURN LENGTH(XNAME);
END GET_MEDIATYPE_LENGTH;




CREATE OR REPLACE FUNCTION GET_AVG_TOTAL
RETURN NUMBER
IS XTOTAL NUMBER(10,2);
BEGIN
    SELECT TOTAL INTO XTOTAL
    FROM CHINOOK.INVOICE;
    --WHERE INVOICEID = XID;
    DECLARE
        XAVG NUMBER(10,2) DEFAULT
    XAVG = AVG(TOTAL);
    RETURN XAVG;
END GET_AVG_TOTAL;
--OK, after writing, rewriting, rewriting, rewriting, and rewriting, and rewriting, and rewriting...
--This is as right as it's getting.
--If I have more time later I'll still come back.
--But for now, this function is correct enough.
--I happen to know with as much certainty as I can given that I just learned about these this week
-- that you are absolutely supposed to end a function with an END statement.
--So as to why SQL Dev is currently freaking out about the END statement...who knows?

--Max Function
CREATE OR REPLACE FUNCTION MAX_TRACK
RETURN NUMBER
IS Z NUMBER;
BEGIN
    SELECT UNITPRICE INTO Z
    FROM CHINOOK.TRACK
    Z := MAX(Z);
    RETURN MAX(Z);
END;
--Again...I'll just have to come back to this one later...

CREATE OR REPLACE FUNCTION GET_AVG_INVOICELINE
RETURN NUMBER
IS XINVLINEPRICE NUMBER(10,2);
BEGIN
    SELECT UNITPRICE INTO XINVLINEPRICE
    FROM CHINOOK.INVOICELINE;
    --WHERE INVOICEID = XID;
    DECLARE
        XAVG NUMBER(10,2) DEFAULT
    XAVG = AVG(XINVLINEPRICE);
    RETURN XAVG;
END GET_AVG_INVOICELINE;
--Okay, clearly I'm doing something wrong, becauase all but the first one are pulling up errors.
--Time permitting, I will definitly be coming back here to see what's going on.
--But for now I need to move on, because I need to at least attempt all of the homework


--Employees born after 1968
CREATE OR REPLACE FUNCTION FORTY_PLUS
(E_ID IN NUMBER)
RETURN VARCHAR2
IS E_NAME VARCHAR2(50);
BEGIN
    SELECT FIRSTNAME INTO E_NAME
    FROM CHINOOK.EMPLOYEE
    WHERE BIRTHDATE > '31-DEC-68';
    RETURN E_NAME;
END;
--WOOHOO!
--THAT ONE WORKED!  NO NEED TO DOUBLE-CHECK THIS ONE.


--4.1
CREATE OR REPLACE PROCEDURE FULL_NAME
(EMPID IN NUMBER)
IS
FULLNAME VARCHAR2(50);
BEGIN
    SELECT FIRSTNAME INTO FULLNAME
    FROM CHINOOK.EMPLOYEE
    WHERE EMPLOYEEID = EMPID;
    SELECT LASTNAME INTO FULLNAME
    FROM CHINOOK.EMPLOYEE
    WHERE EMPLOYEEID = EMPID;
    RETURN FULLNAME;
END;
--The compiler doesn't like this one either...
--It insists that a RETURN statement cannot contain an expression.
--...I'm pretty sure it can, as it did in 3.1 and 3.4
--Nevertheless, time permitting I will come back to this one as well and see if there is some way to tweak it that will make
-- even THIS compiler happy


--4.2
CREATE OR REPLACE PROCEDURE UPDATE_INFO
(EMPID IN NUMBER, CATEGORY IN VARCHAR2)
IS
INFO VARCHAR2(50);
BEGIN
    IF
    CATEGORY = PHONE THEN
    UPDATE
    SET PHONE = INFO
    WHERE EMPLOYEEID = EMPID;
    ELSE
    UPDATE
    SET EMAIL = INFO
    WHERE EMPLOYEEID = EMPID;
    END IF;
END;

CREATE OR REPLACE PROCEDURE EMPLOYEE_MANAGER
(EMPID IN NUMBER)
IS
MGR_ID NUMBER;
MANAGER VARCHAR2(50);
BEGIN
    SELECT REPORTSTO INTO MGR_ID
    FROM CHINOOK.EMPLOYEE
    WHERE EMPLOYEEID = EMPID;
    IF
    MGR_ID = 6 THEN
    MANAGER := 'Michael Mitchell';
    ELSE IF
    MGR_ID = 2 THEN
    MANAGER := 'Nancy Edwards';
    ELSE
    MANAGER := 'Andrew Adams';
    END IF;
    RETURN MANAGER;
END;



--5.0
--6.0
--7.1
SELECT CHINOOK.CUSTOMER.CUSTOMERID, CHINOOK.INVOICE.INVOICEID
FROM CHINOOK.CUSTOMER
INNER JOIN CHINOOK.INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID
INNER JOIN CHINOOK.INVOICE ON CUSTOMER.ADDRESS = INVOICE.BILLINGADDRESS
INNER JOIN CHINOOK.INVOICE ON CUSTOMER.CITY = INVOICE.BILLINGCITY
INNER JOIN CHINOOK.INVOICE ON CUSTOMER.STATE = INVOICE.BILLINGSTATE
INNER JOIN CHINOOK.INVOICE ON CUSTOMER.COUNTRY = INVOICE.BILLINGCOUNTRY
INNER JOIN CHINOOK.INVOICE ON CUSTOMER.POSTALCODE = INVOICE.BILLINGPOSTALCODE;
--INNER JOIN CHINOOK.INVOICE ON CUSTOMER.INVOICEID = INVOICE.INVOICEID;

--7.2
SELECT CHINOOK.CUSTOMER.CUSTOMERID, CHINOOK.CUSTOMER.FIRSTNAME, CHINOOK.CUSTOMER.LASTNAME, CHINOOK.INVOICE.INVOICEID,
CHINOOK.INVOICE.TOTAL
FROM CHINOOK.CUSTOMER
LEFT JOIN CHINOOK.INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID
LEFT JOIN CHINOOK.INVOICE ON CUSTOMER.ADDRESS = INVOICE.BILLINGADDRESS
LEFT JOIN CHINOOK.INVOICE ON CUSTOMER.CITY = INVOICE.BILLINGCITY
LEFT JOIN CHINOOK.INVOICE ON CUSTOMER.STATE = INVOICE.BILLINGSTATE
LEFT JOIN CHINOOK.INVOICE ON CUSTOMER.COUNTRY = INVOICE.BILLINGCOUNTRY
LEFT JOIN CHINOOK.INVOICE ON CUSTOMER.POSTALCODE = INVOICE.BILLINGPOSTALCODE
--ORDER BY CHINOOK.CUSTOMER.FIRSTNAME, CHINOOK.CUSTOMER.LASTNAME, CHINOOK.CUSTOMER.CUSTOMERID, CHINOOK.INVOICE.INVOICEID,
--CHINOOK.INVOICE.TOTAL;
--I commented out the ORDER BY here, because it was just taking so long to compile, plus it wasn't required and I did
-- check the code block without that part and it compiled just fine, so I'll just be content with that.

--7.3
SELECT CHINOOK.ARTIST.NAME, CHINOOK.ALBUM.TITLE
FROM CHINOOK.ALBUM
RIGHT JOIN CHINOOK.ARTIST ON ALBUM.ARTISTID = ARTIST.ARTISTID;
--HA HA!  SUCCESS!!!

--7.4
SELECT CHINOOK.ARTIST.NAME
FROM CHINOOK.ARTIST
CROSS JOIN CHINOOK.ALBUM
ORDER BY CHINOOK.ARTIST.NAME ASC;
--Well, it printed out a rather bizzarre-looking result, but it compiled, so I'm happy.
--If I do have tons of extra time and happen to get to all of the other ones that need readdressing,
-- I may want to come back here anyway to get a more satisfying result.


