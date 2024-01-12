-- First Permission
INSERT INTO Permission (title,code,status) VALUES ('All','0',true);
-- First Role
INSERT INTO Role (title,status,code) VALUES ('Root',true,'ROOT');
--First Person
INSERT INTO Person(firstName,middleName,lastName,dob,address) VALUES ('Jesser','Evander','Rojas',CURRENT_DATE(),'por ahi');
