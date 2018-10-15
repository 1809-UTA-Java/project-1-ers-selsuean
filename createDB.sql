
DROP USER ERS CASCADE;


CREATE USER ERS
IDENTIFIED BY revature
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;


GRANT connect to ERS;
GRANT resource to ERS;
GRANT create session to ERS;
GRANT create table to ERS;
GRANT create view to ERS;







